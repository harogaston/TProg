/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.interfaces.ICtrlReservas;

/**
 *
 * @author marccio
 */
public class Carrito extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		//solo redirige al carrito
		request.getRequestDispatcher("/pages/carrito.jsp").forward(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
			//aca se reciben parametros y se modifica la reserva (agregando lineas)
			HttpSession session = request.getSession(false);
			ICtrlReservas ctrlReservas = (ICtrlReservas) session.getAttribute("ctrlReservas"); //el controlador asociado a la sesion
			ctrlReservas.seleccionarCliente((String) session.getAttribute("usuario_logueado")); //selecciono cliente
			String idProveedor = request.getParameter("idProveedor");
//			if (request.getParameter("idServicio") != null) { da lo mismo controlar así o con lo que está
			if (request.getHeader("referer").contains("VerServicio")) {
				//en este caso llame al servlet desde un servicio
				String idServicio = request.getParameter("idServicio");
				DTMinServicio dt = new DTMinServicio(idProveedor, idServicio);
				ctrlReservas.seleccionarServicio(dt);
			} else if (request.getHeader("referer").contains("VerPromocion")) {
				//la llame desde una promocion

				//esto es para evitar un problema de diseño del servidor central, que se fija si es null el dtServicio
				//cuando en realidad tendría que preguntar qué se le está pidiendo
				ctrlReservas.seleccionarServicio(null);
				String idPromocion = request.getParameter("idPromocion");
				DTMinPromocion dt = new DTMinPromocion(idProveedor, idPromocion);
				ctrlReservas.seleccionarPromocion(dt);
			}
			//corregir la fecha de acuerdo a parámetros de entrada
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));

			//obtengo strings para las fechas, en formato dd/mm/aaaa, hay que parsearlas
			String fechaInicio = request.getParameter("inicio");
			String fechaFin = request.getParameter("fin");

			DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateInicio = sourceFormat.parse(fechaInicio);
			Date dateFin = sourceFormat.parse(fechaFin);

			ctrlReservas.ingresarLineaReserva(cantidad, dateInicio, dateFin);
			session.setAttribute("cant_items", ((Integer) session.getAttribute("cant_items")) + 1);
			session.setAttribute("reservaTemporal", ctrlReservas.mostrarReservaTemporal());
			request.getRequestDispatcher("/pages/carrito.jsp").forward(request, response);
		} catch (ParseException ex) {
			Logger.getLogger(Carrito.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
