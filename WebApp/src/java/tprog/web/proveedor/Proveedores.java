/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web.proveedor;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tprog.web.EstadoSesion;
import tprog.web.TipoUsuario;

/**
 *
 * @author Martin
 */
public class Proveedores extends HttpServlet {

    public static void initSession2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(request.getParameterMap().toString());
		if (session.getAttribute("estado_sesion") == null) {
			session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
		if ((session.getAttribute("tipo_usuario") == null) || (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE)) {
			session.setAttribute("tipo_usuario", TipoUsuario.PROVEEDOR);
		}
		if (session.getAttribute("datos_cargados") == null) {
			session.setAttribute("datos_cargados", false);
		}
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initSession2(request);
		HttpSession session = request.getSession();
		if (session.getAttribute("tipo_usuario") == TipoUsuario.PROVEEDOR) {
			if (session.getAttribute("estado_sesion") == EstadoSesion.OK_LOGIN) {
				request.getRequestDispatcher("VerPerfil").forward(request, response);
			} else {
				request.getRequestDispatcher("/pages/proveedor.jsp").forward(request, response);
			}
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
