package tprog.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tprog.logica.dt.EstadoReserva;
import tprog.logica.interfaces.ICtrlReservas;

public class CancelarReserva extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		String idReserva = request.getParameter("idReserva");
		ICtrlReservas ctrlReservas = (ICtrlReservas) request.getSession().getAttribute("ctrlReservas");
		ctrlReservas.seleccionarReserva(Integer.parseInt(idReserva));
		ctrlReservas.cambiarEstadoReserva(EstadoReserva.Cancelada);
		request.getSession().setAttribute("reservaCancelada", "La reserva ha sido cancelada con éxito");
		// volver a la página que llamó al servlet
		response.sendRedirect("/WebApp/VerPerfil#reservas");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
