package tprog.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservice.WrapperVerServicio;

public class VerServicio extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		webservice.PublicadorVerServicioService service = new webservice.PublicadorVerServicioService();
		webservice.PublicadorVerServicio proxy = service.getPublicadorVerServicioPort();
		String idServicio = request.getParameter("idServicio");
		String idProveedor = request.getParameter("idProveedor");
		WrapperVerServicio wrapper = proxy.verServicio(idServicio, idProveedor);
		request.setAttribute("idProveedor", idProveedor);
		request.setAttribute("infoServicio", wrapper.getDtServicio());
		Set<String> categorias = new HashSet<>(wrapper.getCategorias());
		System.out.println("Web App");
		System.out.println("Ciudad origen : " + wrapper.getDtServicio().getOrigen().getCiudad());
		System.out.println("Pais origen : " + wrapper.getDtServicio().getOrigen().getPais());
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("/pages/verServicio.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
