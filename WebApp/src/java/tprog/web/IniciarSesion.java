package tprog.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IniciarSesion extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
                webservice.PublicadorService service = new webservice.PublicadorService();
		webservice.Publicador proxy = service.getPublicadorPort();
		String id = request.getParameter("nickname"); //puede ser email o nickname
		String contrasena = request.getParameter("password");
		EstadoSesion nuevoEstado;
                // se checkean los datos de login
                if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE){
                    if (proxy.verificarCliente(id, contrasena)) {
                        
                        //session.setAttribute("ctrlReservas", cr);
			nuevoEstado = EstadoSesion.OK_LOGIN;
                        
			//en caso de que id sea un email
			id = proxy.obtenerIdCliente(id, contrasena);
			request.getSession().setAttribute("usuario_logueado", id);
                        
			session.setAttribute("estado_sesion", nuevoEstado);
			session.setAttribute("cant_items", 0);
                    } else {
			session.setAttribute("inicioIncorrecto", "Las credenciales que ingresó no corresponden a ningún cliente registrado en el sistema");
                    }
                }
                    
                if (session.getAttribute("tipo_usuario") == TipoUsuario.PROVEEDOR){
                    if (proxy.verificarProveedor(id, contrasena)) {
                        
                        
			nuevoEstado = EstadoSesion.OK_LOGIN;
                        //en caso de que id sea un email
			id = proxy.obtenerIdProveedor(id, contrasena);
			request.getSession().setAttribute("usuario_logueado", id);
                        session.setAttribute("estado_sesion", nuevoEstado);
			session.setAttribute("cant_items", 0);
                    } else {
			session.setAttribute("inicioIncorrecto", "Las credenciales que ingresó no corresponden a ningún proveedor registrado en el sistema");
                    }
                }
		// redirige a la página principal para que luego rediriga a la página
		// que corresponde
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Home");
		dispatcher.forward(request, response);
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
