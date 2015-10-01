/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.io.IOException;
import java.util.Date;
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
		processRequest(request, response);
		//aca se reciben parametros y se modifica la reserva (agregando lineas)
		HttpSession session = request.getSession(false);
//		Map<LineaReserva, Integer> lineasReserva = (Map<LineaReserva, Integer>) session.getAttribute("lineasReserva");
		//si no tengo una estructura en mi sesion para lineas de reserva, la inicializo
//		if (lineasReserva == null) {
//			lineasReserva = new HashMap<LineaReserva, Integer>();
//		}
		ICtrlReservas ctrlReservas = (ICtrlReservas) session.getAttribute("ctrlReservas"); //el controlador asociado a la sesion
		ctrlReservas.seleccionarCliente((String) session.getAttribute("usuario_logueado")); //selecciono cliente
		String idProveedor = request.getParameter("idProveedor");
		if (request.getParameter("idServicio") != null) {
			//en este caso llame al servlet desde un servicio
			String idServicio = request.getParameter("idServicio");
			DTMinServicio dt = new DTMinServicio(idProveedor, idServicio);
			ctrlReservas.seleccionarServicio(dt);

		} else {
			//la llame desde una promocion
			String idPromocion = request.getParameter("idPromocion");
			DTMinPromocion dt = new DTMinPromocion(idProveedor, idPromocion);
			ctrlReservas.seleccionarPromocion(dt);
		}
		//corregir la fecha de acuerdo a parámetros de entrada
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		ctrlReservas.ingresarLineaReserva(cantidad, new Date(1992, 8, 10), new Date(1993, 8, 11));
		session.setAttribute("cant_items", ((Integer) session.getAttribute("cant_items")) + 1);
		session.setAttribute("reservaTemporal", ctrlReservas.mostrarReservaTemporal());
		request.getRequestDispatcher("/pages/carrito.jsp").forward(request, response);
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
