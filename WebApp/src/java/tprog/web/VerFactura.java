/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webservice.DtFacturaF;
import webservice.WrapperVerFactura;

/**
 *
 * @author User
 */
@WebServlet(name = "VerFactura", urlPatterns = {"/VerFactura"})
public class VerFactura extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Properties properties = new Properties();
		String ruta = System.getProperty("user.home") + "/.Help4Travel/config.properties";
		FileInputStream file = new FileInputStream(ruta);
		properties.load(file);
		file.close();
		URL wsdlLocation = new URL(properties.getProperty("publicador") + "?wsdl");
		webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
		webservice.Publicador proxy = service.getPublicadorPort();
		System.out.println("Llego hasta el servlet");
		String idReservaString = request.getParameter("idReserva");
		Integer idReserva = Integer.parseInt(idReservaString);
		WrapperVerFactura wrapper = proxy.verFactura(idReserva);
		DtFacturaF dtF = wrapper.getFactura();
		request.setAttribute("factura", dtF);
		System.out.println("factura " + dtF.getIdReserva());
		System.out.println("cliente " + dtF.getNicknameCliente());
		request.getRequestDispatcher("/pages/factura.jsp").forward(request, response);
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
