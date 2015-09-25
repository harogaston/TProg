package tprog.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tprog.logica.controladores.CtrlUsuarios;

public class IniciarSesion extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession objSesion = request.getSession();
		String id = request.getParameter("Nickname"); //puede ser email o nickname
		String contraseña = request.getParameter("Password");
		EstadoSesion nuevoEstado;
		CtrlUsuarios cu = new CtrlUsuarios();
		// se checkean los datos de login
		if (!(cu.idCorrecta(id) & cu.pwCorrecta(id, contraseña))) {
			nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
			request.getSession().setAttribute("usuario_logueado", id);
		} else {
			nuevoEstado = EstadoSesion.LOGIN_INCORRECTO; // ahora da siempre login incorrecot dado que no estan cargados los datos
		}
		objSesion.setAttribute("estado_sesion", nuevoEstado);
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

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
