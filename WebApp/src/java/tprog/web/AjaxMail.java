package tprog.web;

import org.apache.commons.validator.EmailValidator;
import java.io.IOException;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxMail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("mail");
		String resultado;
		URL wsdlLocation = new URL(getServletContext().getInitParameter("wsdl"));
		webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
		webservice.Publicador proxy = service.getPublicadorPort();
		if (id.matches("^\\s*$")) {
			resultado = "";
		} else if (id.matches(".*(\\s+).*")) {
			resultado = "SIN_ESPACIOS";
		} else if (!EmailValidator.getInstance().isValid(id)) {
			resultado = "FORMATO_INVALIDO";
		} else if (!proxy.verificarEmail(id)) {
			resultado = "OK";
		} else {
			resultado = "EN_USO";
		}// se agregan mas if si hay q verificar que sea correcto tambien
		response.setContentType("text/plain");
		response.getWriter().write(resultado);
	}
}
