package tprog.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webservice.DtCliente;
import webservice.DtProveedor;
import webservice.DtReserva;
import webservice.WrapperVerPerfilCliente;

public class VerPerfil extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		webservice.PublicadorService service = new webservice.PublicadorService();
		webservice.Publicador proxy = service.getPublicadorPort();

		if (request.getSession().getAttribute("usuario_logueado") != null) {
			if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) {
				WrapperVerPerfilCliente result = proxy.verPerfilCliente((String) request.getSession().getAttribute("usuario_logueado"));
				DtCliente dtC = result.getCliente();
				request.setAttribute("nick", dtC.getNickname());
				String nombreCompleto = dtC.getNombre() + " " + dtC.getApellido();
				request.setAttribute("nombre", nombreCompleto);
				String fNac = Integer.toString(dtC.getFechaNacimiento().getDay()) + "-"
						+ Integer.toString(dtC.getFechaNacimiento().getMonth() + 1) + "-"
						+ Integer.toString(dtC.getFechaNacimiento().getYear()) + "\n";
				request.setAttribute("fNac", fNac);
				request.setAttribute("email", dtC.getEmail());
				request.setAttribute("imagen", dtC.getImagen());
				// Voy a crear un Set<DTReserva> para pasarle a la jsp
				Set<DtReserva> reservas = new HashSet(result.getReservas());
				request.setAttribute("reservas", reservas);
				request.getRequestDispatcher("/pages/perfil.jsp").forward(request, response);
			} else {
				try {
					DtProveedor dtP = proxy.verPerfilProveedor((String) request.getSession().getAttribute("usuario_logueado"));
					request.setAttribute("nick", dtP.getNickname());
					String nombreCompleto = dtP.getNombre() + " " + dtP.getApellido();
					request.setAttribute("nombre", nombreCompleto);
					String fNac = Integer.toString(dtP.getFechaNacimiento().getDay()) + "-"
							+ Integer.toString(dtP.getFechaNacimiento().getMonth() + 1) + "-"
							+ Integer.toString(dtP.getFechaNacimiento().getYear()) + "\n";
					request.setAttribute("fNac", fNac);
					request.setAttribute("email", dtP.getEmail());
					request.setAttribute("imagen", dtP.getImagen());
					request.setAttribute("linkEmpresa", dtP.getWebEmpresa());
					request.setAttribute("nombreEmpresa", dtP.getEmpresa());
					request.getRequestDispatcher("/pages/perfil.jsp").forward(request, response);
				} catch (ServletException | IOException ex) {
					Logger.getLogger(VerPerfil.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		} else {
			// Si por algún motivo el atributo ya no exite (ej: expiró la sesión) lo mando al inicio
			request.getRequestDispatcher("/pages/inicio.jsp").forward(request, response);
		}
	}
}
