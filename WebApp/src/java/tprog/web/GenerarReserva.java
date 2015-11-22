package tprog.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
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
			Properties properties = new Properties();
			String ruta = System.getProperty("user.home") + "/.Help4Travel/config.properties";
			FileInputStream file = new FileInputStream(ruta);
			properties.load(file);
			file.close();
			URL wsdlLocation = new URL(properties.getProperty("publicador") + "?wsdl");
			webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
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
