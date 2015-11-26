package tprog.web;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Home extends HttpServlet {

	public static void initSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(request.getParameterMap().toString());
		if (session.getAttribute("estado_sesion") == null) {
			session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
		if ((session.getAttribute("tipo_usuario") == null) || (session.getAttribute("tipo_usuario") == TipoUsuario.PROVEEDOR)) {
			session.setAttribute("tipo_usuario", TipoUsuario.CLIENTE);
		}
		if (session.getAttribute("datos_cargados") == null) {
			session.setAttribute("datos_cargados", false);
		}
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initSession(request);
		HttpSession session = request.getSession();
		if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) {
			if (request.getSession().getAttribute("terminos") == null) {
				URL wsdlLocation = new URL(getServletContext().getInitParameter("wsdl"));
				webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
				System.out.println("URL del coso : " + wsdlLocation.toString());
				webservice.Publicador proxy = service.getPublicadorPort();
				JsonParser jsonParser = new JsonParser();
				JsonArray termsArray = (JsonArray) jsonParser.parse(proxy.typeahead());
				request.getSession().setAttribute("terminos", termsArray);
			}
			request.setAttribute("categoriaSeleccionada", null);
			request.setAttribute("busqueda", null);
			request.setAttribute("precio", "0");

		}
		request.getRequestDispatcher("Buscar").forward(request, response);
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
