package tprog.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webservice.DtProveedor;
import webservice.Exception_Exception;
import webservice.WrapperReserva;
import webservice.WrapperVerPerfilCliente;
import webservice.WrapperVerPerfilProveedor;

/**
 *
 * @author MartinPorta
 */
public class ReservasProveedor extends HttpServlet {

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
			throws ServletException, IOException, Exception_Exception {
		HttpSession session = request.getSession();
		webservice.PublicadorService service = new webservice.PublicadorService();
		webservice.Publicador proxy = service.getPublicadorPort();
		WrapperVerPerfilProveedor result = proxy.verPerfilProveedor((String) request.getSession().getAttribute("usuario_logueado"));
		DtProveedor dtP = result.getDtP();
		request.setAttribute("nick", dtP.getNickname());
		String nombreCompleto = dtP.getNombre() + " " + dtP.getApellido();
		request.setAttribute("nombre", nombreCompleto);
		String fNac = Integer.toString(dtP.getFechaNacimiento().getDay()) + "-"
				+ Integer.toString(dtP.getFechaNacimiento().getMonth() + 1) + "-"
				+ Integer.toString(dtP.getFechaNacimiento().getYear()) + "\n";
		request.setAttribute("fNac", fNac);
		request.setAttribute("email", dtP.getEmail());
		request.setAttribute("imagen", dtP.getImagen());
		request.setAttribute("linkEmpresa", dtP.getWebEmpresa());
		request.setAttribute("nombreEmpresa", dtP.getEmpresa());
		request.setAttribute("reservas", result.getReservasCliente());
		request.getRequestDispatcher("/pages/reservasProveedor.jsp").forward(request, response);
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
		try {
			processRequest(request, response);
		} catch (Exception_Exception ex) {
			Logger.getLogger(ReservasProveedor.class.getName()).log(Level.SEVERE, null, ex);
		}
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
		try {
			processRequest(request, response);
		} catch (Exception_Exception ex) {
			Logger.getLogger(ReservasProveedor.class.getName()).log(Level.SEVERE, null, ex);
		}
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
