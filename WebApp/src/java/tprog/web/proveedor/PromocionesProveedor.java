/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web.proveedor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webservice.DtPromocion;
import webservice.DtServicio;
import webservice.WrapperVerPromocionesProveedor;
//import webservice.WrapperVerServiciosProveedor;

/**
 *
 * @author marccio
 */
@WebServlet(name = "PromocionesProveedor", urlPatterns = {"/PromocionesProveedor"})
public class PromocionesProveedor extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//establezco proxy con el web service
        response.setContentType("text/html;charset=UTF-8");
		webservice.PublicadorService servicio
				= new webservice.PublicadorService();
		webservice.Publicador proxy = servicio.getPublicadorPort();
		WrapperVerPromocionesProveedor result
				= proxy.verPromocionesProveedor((String) request.getSession().getAttribute("usuario_logueado"));
		//rearmo el map de servicios
		List<webservice.WrapperVerPromocionesProveedor.Promociones.Entry> listPromociones
				= result.getPromociones().getEntry();
		Map<DtPromocion, String> promociones = new HashMap<>();
		for (webservice.WrapperVerPromocionesProveedor.Promociones.Entry entry : listPromociones) {
			promociones.put(entry.getKey(), entry.getValue());
		}
		HttpSession session = request.getSession();
		String idProveedor = (String) session.getAttribute("usuario_logueado");
		//asigno atributos de la request
		List<String> notificaciones = proxy.listarNotificacionesProveedor(idProveedor).getNotificaciones();
		session.setAttribute("notificaciones", notificaciones);
		session.setAttribute("cant_notificaciones", notificaciones.size());
		request.setAttribute("promociones", promociones);
		//redirijo request
		request.getRequestDispatcher("/pages/proveedor/verPromocionesProveedor.jsp").forward(request, response);
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
