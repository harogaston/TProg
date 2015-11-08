package tprog.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import webServices.Publicador;
//import webServices.PublicadorService;

@WebServlet(name = "NuevoCliente", urlPatterns = {"/NuevoCliente"})
public class NuevoCliente extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            HttpSession session = request.getSession();
//                PublicadorService service =  new PublicadorService();
//                Publicador port = service.getPublicadorPort();
//                int ret = port.nuevoCliente(0);
            if(session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE){
                request.getRequestDispatcher("/pages/registrarCliente.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("/pages/registrarProveedor.jsp").forward(request, response);
            }
		
	}
}
