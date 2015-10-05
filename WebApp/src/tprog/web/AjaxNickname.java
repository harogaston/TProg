package tprog.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlUsuarios;

public class AjaxNickname extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("nickname");
		String resultado;
		ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
		if (id.matches("^\\s*$")) {
			resultado = "";
		} else if (id.matches(".*(\\s+).*")) {
			resultado = "SIN_ESPACIOS";
		} else if (!ctrlUsuarios.verificarNickname(id)) {
			resultado = "OK";
		} else {
			resultado = "EN_USO";
		}// se agregan mas if si hay q verificar que sea correcto tambien
		response.setContentType("text/plain");
		response.getWriter().write(resultado);
	}
}
