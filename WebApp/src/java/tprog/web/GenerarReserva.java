package tprog.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GenerarReserva extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//es imposible llegar acá si no hay una reserva temporal no vacía,
			//debido a la interfaz; entonces acá asumo que está todo bien
			webservice.PublicadorService service = new webservice.PublicadorService();
			webservice.Publicador proxy = service.getPublicadorPort();
			int idCtrlReservas = (int) request.getSession().getAttribute("idCtrlReservas");
			//es imposible llegar acá si no hay una reserva temporal no vacía,
			//debido a la interfaz; entonces acá asumo que está todo bien
			String nickname = (String) request.getSession().getAttribute("usuario_logueado");
			proxy.generarReserva(nickname, idCtrlReservas);

			request.getSession().setAttribute("reservaTemporal", null);
			request.getSession().setAttribute("cant_items", 0);

			request.getSession().setAttribute("reservaGenerada", "OK");
			request.getRequestDispatcher("Home").forward(request, response);

		} catch (Exception ex) {
			Logger.getLogger(GenerarReserva.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
