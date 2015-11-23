/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web.proveedor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marccio
 */
@WebServlet(name = "FacturarReserva", urlPatterns = {"/FacturarReserva"})
public class FacturarReserva extends HttpServlet {

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
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String idProveedor = (String) session.getAttribute("usuario_logueado");
		int idReserva = Integer.parseInt((String) request.getParameter("idReserva"));
		String nickCliente = request.getParameter("nickCliente");
		String emailCliente = request.getParameter("emailCliente");
		//System.out.println(emailCliente);
		Properties properties = new Properties();
		String ruta = System.getProperty("user.home") + "/.Help4Travel/config.properties";
		FileInputStream file = new FileInputStream(ruta);
		properties.load(file);
		file.close();
		URL wsdlLocation = new URL(properties.getProperty("publicador") + "?wsdl");
		webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
		webservice.Publicador proxy = service.getPublicadorPort();
		//enviar mail
		if (proxy.facturarReserva(idProveedor, nickCliente, idReserva)) {
			System.out.println("estoy");
			// Recipient's email ID needs to be mentioned.
			String to = "nachoprbd@gmail.com";

			// Sender's email ID needs to be mentioned
			String from = "web@gmail.com";

			// Assuming you are sending email from localhost
			String host = "localhost";

			// Setup mail server
			properties.setProperty("mail.smtp.host", "smtp.gmail.com");

			// Get the default Session object.
			Session sesion = Session.getDefaultInstance(properties);

			try {
				// Create a default MimeMessage object.
				MimeMessage message = new MimeMessage(sesion);

				// Set From: header field of the header.
				message.setFrom(new InternetAddress(from));

				// Set To: header field of the header.
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

				// Set Subject: header field
				message.setSubject("Help4Traveling");

				// Now set the actual message
				message.setText("el mensaje wea");

				// Send message
				Transport.send(message);
				System.out.println("Sent message successfully....");
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}
		}

		//asigno atributos de la request
		List<String> notificaciones = proxy.listarNotificacionesProveedor(idProveedor).getNotificaciones();
		session.setAttribute("notificaciones", notificaciones);
		session.setAttribute("cant_notificaciones", notificaciones.size());
		request.getRequestDispatcher("ReservasProveedor").forward(request, response);
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
