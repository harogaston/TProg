package tprog.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.validator.routines.EmailValidator;

@WebServlet(name = "RegistrarCliente", urlPatterns = {"/RegistrarCliente"})
public class RegistrarCliente extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		URL wsdlLocation = new URL(getServletContext().getInitParameter("wsdl"));
		webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
		webservice.Publicador proxy = service.getPublicadorPort();
		try {
			// leo los datos -falta checkear que sean correctos y esas manos-
			String id = request.getParameter("nickname");
			String mail = request.getParameter("mail");
			// el checkeo de mail y nick es "en tiempo real" con ajax -falta-

			String contrasena = request.getParameter("password");
			String contrasena2 = request.getParameter("password2");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");

			//obtengo strings para las fechas, en formato dd/mm/aaaa, hay que parsearlas
			String fechaNac = request.getParameter("fNac");
			EstadoSesion nuevoEstado;
//			Fabrica f = Fabrica.getInstance();
//			ICtrlUsuarios cu = f.getICtrlUsuarios();

			//Verificación de email
			EmailValidator emailValidator = EmailValidator.getInstance(true);
			boolean okEmail = emailValidator.isValid(mail);

			//Verificacion de nickname
			boolean okEnblanco = !id.matches("^\\s*$");
			boolean okSinEspacios = !id.matches(".*(\\s+).*");
			boolean okNickname = okEnblanco && okSinEspacios;
			boolean nicknameUnico = false;
			if (okNickname) {
				nicknameUnico = proxy.verificarNickname(id);
			}
			boolean emailUnico = true;
			if (okEmail) {
				emailUnico = proxy.verificarEmail(mail);
			}
			boolean okNickMail = false;
			if (okNickname && okEmail && !emailUnico && !nicknameUnico) {
				okNickMail = true;
			}
			if (okNickMail) {
				//Verificacion de contraseña
				boolean okPassword1 = contrasena.length() >= 3 && contrasena.length() <= 20;
				boolean okPassword2 = contrasena2.length() >= 3 && contrasena2.length() <= 20;
				boolean okPassword = (okPassword1 && okPassword2 && contrasena.equals(contrasena2));
				// Verificación de nombre y apellido
				boolean okNombre = !nombre.matches("^\\s*$");
				boolean okApellido = !apellido.matches("^\\s*$");

				if (okNombre && okApellido && okPassword) {
					// doy de alta el cliente
//					DtUsuario dtU = new DtUsuario();
					if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) {
						proxy.altaUsuario(
								id,
								contrasena,
								nombre,
								apellido,
								mail,
								fechaNac,
								"null", //imagen
								false,
								"null",
								"null"
						);
					} else {
						String empresa = (request.getParameter("empresa") == null) ? "null" : request.getParameter("empresa");
						String linkEmpresa = (request.getParameter("UrlEmpresa") == null) ? "null" : request.getParameter("UrlEmpresa");
						proxy.altaUsuario(
								id,
								contrasena,
								nombre,
								apellido,
								mail,
								fechaNac,
								"null",
								true,
								empresa,
								linkEmpresa
						);
					}

					//ya logueo el usuario registrado
//					ICtrlReservas cr = f.getICtrlReservas(); //se lo asocio por la duracion de la sesion
//					cr.liberarMemoriaControlador();
//					session.setAttribute("ctrlReservas", cr);
					nuevoEstado = EstadoSesion.OK_LOGIN;
					request.getSession().setAttribute("usuario_logueado", id);
					session.setAttribute("estado_sesion", nuevoEstado);
					session.setAttribute("cant_items", 0);

					request.getRequestDispatcher("/pages/subirImagen.jsp").forward(request, response);
				} else {
					if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/Home");
						dispatcher.forward(request, response);
					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/Proveedores");
						dispatcher.forward(request, response);
					}
				}

			} else {
				if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Home");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Proveedores");
					dispatcher.forward(request, response);
				}
			}

		} catch (ServletException | IOException ex) {
			Logger.getLogger(RegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
