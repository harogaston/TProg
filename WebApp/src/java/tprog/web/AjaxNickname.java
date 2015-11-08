package tprog.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxNickname extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("nickname");
		String resultado;
		webservice.PublicadorService service = new webservice.PublicadorService();
		webservice.Publicador proxy = service.getPublicadorPort();
		if (id.matches("^\\s*$") && (id.length() >= 3)) {
			resultado = "";
		} else if (id.matches(".*(\\s+).*")) {
			resultado = "SIN_ESPACIOS";
		} else if (id.length() < 3) {
			resultado = "CORTO";
		} else if (!proxy.verificarNickname(id)) {
			resultado = "OK";
		} else {
			resultado = "EN_USO";
		}// se agregan mas if si hay q verificar que sea correcto tambien
		response.setContentType("text/plain");
		response.getWriter().write(resultado);
	}
}
