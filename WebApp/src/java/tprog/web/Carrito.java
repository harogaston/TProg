package tprog.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webservice.DtReserva;

public class Carrito extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		//solo redirige al carrito
		request.getRequestDispatcher("/pages/carrito.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		//aca se reciben parametros y se modifica la reserva (agregando lineas)
		HttpSession session = request.getSession(false);
		URL wsdlLocation = new URL(getServletContext().getInitParameter("wsdl"));
		webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
		webservice.Publicador proxy = service.getPublicadorPort();
		int idCtrlReservas = (int) session.getAttribute("idCtrlReservas");
		String nickname = (String) session.getAttribute("usuario_logueado");
		String idProveedor = request.getParameter("idProveedor");
		//corregir la fecha de acuerdo a parámetros de entrada
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		//obtengo strings para las fechas, en formato dd/mm/aaaa, hay que parsearlas
		String fechaInicio = request.getParameter("inicio");
		String fechaFin = request.getParameter("fin");
		DtReserva reservaTemporal = null;
		if (request.getHeader("referer").contains("VerServicio")) {
			//en este caso llame al servlet desde un servicio
			String idServicio = request.getParameter("idServicio");
			reservaTemporal = proxy.agregarServicioCarrito(
					idCtrlReservas,
					nickname,
					idServicio,
					idProveedor,
					cantidad,
					fechaInicio,
					fechaFin
			);

		} else if (request.getHeader("referer").contains("VerPromocion")) {
			//la llame desde una promocion
			//esto es para evitar un problema de diseño del servidor central, que se fija si es null el dtServicio
			//cuando en realidad tendría que preguntar qué se le está pidiendo
			String idPromocion = request.getParameter("idPromocion");
			reservaTemporal = proxy.agregarPromocionCarrito(
					idCtrlReservas,
					nickname,
					idPromocion,
					idProveedor,
					cantidad,
					fechaInicio,
					fechaFin
			);
		}
		session.setAttribute("cant_items", ((Integer) session.getAttribute("cant_items")) + 1);
		session.setAttribute("reservaTemporal", reservaTemporal);
		request.getRequestDispatcher("/pages/carrito.jsp").forward(request, response);
	}
}
