package tprog.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IniciarSesion extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		URL wsdlLocation = new URL(getServletContext().getInitParameter("wsdl"));
		webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
		webservice.Publicador proxy = service.getPublicadorPort();
		String id = request.getParameter("nickname"); //puede ser email o nickname
		String contrasena = request.getParameter("password");
		EstadoSesion nuevoEstado;

		// se checkean los datos de login
		if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) {
			if (proxy.verificarLoginCliente(id, contrasena)) {
				int idCtrlReservas = proxy.pedirNumeroCtrlReservas();
				session.setAttribute("idCtrlReservas", idCtrlReservas);
				nuevoEstado = EstadoSesion.OK_LOGIN;

				//en caso de que id sea un email
				id = proxy.obtenerIdCliente(id, contrasena);
				request.getSession().setAttribute("usuario_logueado", id);

				session.setAttribute("estado_sesion", nuevoEstado);
				session.setAttribute("cant_items", 0);
			} else {
				session.setAttribute("inicioIncorrecto", "Las credenciales que ingresó no corresponden a ningún cliente registrado en el sistema");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Home");
			dispatcher.forward(request, response);
		}

		if (session.getAttribute("tipo_usuario") == TipoUsuario.PROVEEDOR) {
			if (proxy.verificarLoginProveedor(id, contrasena)) {
				nuevoEstado = EstadoSesion.OK_LOGIN;
				//en caso de que id sea un email
				if (request.getParameter("remember") != null) {
					response.addCookie(new Cookie("cookieName", "cookie1"));
					response.addCookie(new Cookie("cookie1Value", id));
					response.addCookie(new Cookie("cookie1Timeout", "60*60*24*365"));
					response.addCookie(new Cookie("cookiePass", "cookie2"));
					response.addCookie(new Cookie("cookie2Value", contrasena));
					response.addCookie(new Cookie("cookie2Timeout", "60*60*24*365"));
				}
				id = proxy.obtenerIdProveedor(id, contrasena);
				request.getSession().setAttribute("usuario_logueado", id);
				session.setAttribute("estado_sesion", nuevoEstado);
				List<String> notificaciones = proxy.listarNotificacionesProveedor(id).getNotificaciones();
				session.setAttribute("notificaciones", notificaciones);
				session.setAttribute("cant_notificaciones", notificaciones.size());

			} else {
				session.setAttribute("inicioIncorrecto", "Las credenciales que ingresó no corresponden a ningún proveedor registrado en el sistema");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Proveedores");
			dispatcher.forward(request, response);
		}

		// redirige a la página principal para que luego rediriga a la página
		// que corresponde
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
