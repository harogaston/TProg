package tprog.web;

import java.io.IOException;
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
        if (session.getAttribute("datos_cargados") == null) {
            session.setAttribute("datos_cargados", false);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initSession(request);
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
