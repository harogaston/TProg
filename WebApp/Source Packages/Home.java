/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import tprog.logica.clases.EstadoSesion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Martin
 */
public class Home extends HttpServlet {

    
    public static void initSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("estado_sesion") == null) {
			session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
	}
	
	public static EstadoSesion getEstado(HttpServletRequest request)
	{
		return (EstadoSesion) request.getSession().getAttribute("estado_sesion");
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initSession(request);
		
		switch(getEstado(request)){
			case NO_LOGIN:
				// hace que se ejecute el jsp sin cambiar la url
				request.getRequestDispatcher("/WEB-INF/inicio.jsp").forward(request, response);
				break;
			case LOGIN_INCORRECTO:
				// hace que se ejecute el jsp sin cambiar la url
				request.getRequestDispatcher("/WEB-INF/inicio.jsp").forward(request, response);
                                // te devuelve en al pagina de inicio como si nada hubiera pasado
                                //hay que hacer una pag de login incorrecto
                                
				break;
			case LOGIN_CORRECTO:
				// manda una redirección a otra URL (cambia la URL)
				//response.sendRedirect("/WEB-INF/sesion.jsp");
                                request.getRequestDispatcher("/WEB-INF/sesion.jsp").forward(request, response);
				break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
