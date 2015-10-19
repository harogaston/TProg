package tprog.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.validator.routines.EmailValidator;
import tprog.logica.dt.DTUsuario;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlUsuarios;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import tprog.logica.interfaces.ICtrlReservas;

@WebServlet(name = "RegistrarCliente", urlPatterns = {"/RegistrarCliente"})
public class RegistrarCliente extends HttpServlet {
         

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
                try{
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
			DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateNac = sourceFormat.parse(fechaNac);
			EstadoSesion nuevoEstado;
			Fabrica f = Fabrica.getInstance();
			ICtrlUsuarios cu = f.getICtrlUsuarios();
                         
			//Verificación de email
			EmailValidator emailValidator = EmailValidator.getInstance(true);
			boolean okEmail = emailValidator.isValid(mail);

			//Verificacion de nickname
			boolean okEnblanco = !id.matches("^\\s*$");
			boolean okSinEspacios = !id.matches(".*(\\s+).*");
			boolean okNickname = okEnblanco && okSinEspacios;
			boolean nicknameUnico = false;
			if (okNickname) {
				nicknameUnico = cu.verificarNickname(id);
			}
			boolean emailUnico = true;
			if (okEmail) {
				emailUnico = cu.verificarEmail(mail);
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
					DTUsuario dtU = new DTUsuario(id, contrasena, nombre, apellido, mail, null, dateNac);
					cu.ingresarDatosUsuario(dtU, false);
					cu.altaUsuario();
                                        
                                        //ya logueo el usuario registrado
                                        
                                        ICtrlReservas cr = f.getICtrlReservas(); //se lo asocio por la duracion de la sesion
                                        cr.liberarMemoriaControlador();
                                        session.setAttribute("ctrlReservas", cr);
                                        nuevoEstado = EstadoSesion.OK_LOGIN;
                                        request.getSession().setAttribute("usuario_logueado", id);
                                        session.setAttribute("estado_sesion", nuevoEstado);
                                        session.setAttribute("cant_items", 0);
                                    
					request.getRequestDispatcher("/pages/subirImagen.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("Home").forward(request, response);
				}

			} else {
				request.getRequestDispatcher("Home").forward(request, response);
			}

		
                    } catch (ParseException ex) {
			Logger.getLogger(RegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
             Logger.getLogger(RegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
         }
	}
}

