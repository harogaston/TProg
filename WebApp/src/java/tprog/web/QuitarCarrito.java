/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tprog.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webservice.DtReserva;

/**
 *
 * @author ignacio.prandi
 */
@WebServlet(name = "QuitarCarrito", urlPatterns = {"/QuitarCarrito"})
public class QuitarCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
	webservice.PublicadorService service = new webservice.PublicadorService();
	webservice.Publicador proxy = service.getPublicadorPort();
	System.out.println("Llego hasta el servlet");
	String idLineaReservaString = request.getParameter("idLineaReserva");
        int idLineaReserva = Integer.parseInt(idLineaReservaString);
	int idCtrlReservas = (int) session.getAttribute("idCtrlReservas");
        DtReserva reservaTemporal = null;
	reservaTemporal = proxy.quitarlineaReserva(idCtrlReservas, idLineaReserva);
        session.setAttribute("cant_items", ((Integer) session.getAttribute("cant_items")) - 1);
	session.setAttribute("reservaTemporal", reservaTemporal);
	request.getRequestDispatcher("/pages/carrito.jsp").forward(request, response);
    }

}
