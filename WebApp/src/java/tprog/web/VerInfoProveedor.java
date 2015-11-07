/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservice.DtProveedor;
import webservice.WrapperVerInfoProveedor;

/**
 *
 * @author marccio
 */
public class VerInfoProveedor extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
			String idProveedor = request.getParameter("idProveedor");
			webservice.PublicadorService service = new webservice.PublicadorService();
			webservice.Publicador proxy = service.getPublicadorPort();
			WrapperVerInfoProveedor result = proxy.verInfoProveedor(idProveedor);
			DtProveedor dt = result.getProveedor();
			request.setAttribute("servicios", new HashSet(result.getServicios()));
			request.setAttribute("promociones", new HashSet(result.getPromociones()));
			request.setAttribute("nick", dt.getNickname());
			String nombreCompleto = dt.getNombre() + " " + dt.getApellido();
			request.setAttribute("nombre", nombreCompleto);
			Date fechaNacimiento = new Date(
					dt.getFechaNacimiento().getYear(),
					dt.getFechaNacimiento().getMonth(),
					dt.getFechaNacimiento().getDay());
			String fNac = Integer.toString(fechaNacimiento.getDate()) + "-"
					+ Integer.toString(fechaNacimiento.getMonth() + 1) + "-"
					+ Integer.toString(fechaNacimiento.getYear()) + "\n";
			request.setAttribute("fNac", fNac);
			request.setAttribute("email", dt.getEmail());
			request.setAttribute("imagen", dt.getImagen());
			request.setAttribute("empresa", dt.getEmpresa());
			request.setAttribute("webempresa", dt.getWebEmpresa());

			request.getRequestDispatcher("/pages/verInfoProveedor.jsp").forward(request, response);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(VerInfoProveedor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
