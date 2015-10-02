package tprog.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tprog.logica.dt.DTReserva;
import tprog.logica.interfaces.ICtrlReservas;

public class GenerarReserva extends HttpServlet {

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
			//es imposible llegar acá si no hay una reserva temporal no vacía,
			//debido a la interfaz; entonces acá asumo que está todo bien
			ICtrlReservas ctrlReservas = (ICtrlReservas) request.getSession().getAttribute("ctrlReservas");
			//doy de alta a la reserva temporal

			DTReserva dtr = ctrlReservas.mostrarReservaTemporal();
			ctrlReservas.altaReserva(dtr);
			ctrlReservas.liberarMemoriaControlador();
			request.getSession().setAttribute("reservaTemporal", null);
			request.getSession().setAttribute("cant_items", 0);

			request.getSession().setAttribute("reservaGenerada", "La reserva ha sido generada con éxito");
			request.getRequestDispatcher("Home").forward(request, response);
		} catch (Exception ex) {
			Logger.getLogger(GenerarReserva.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
