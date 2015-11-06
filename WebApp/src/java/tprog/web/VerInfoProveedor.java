/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlUsuarios;

/**
 *
 * @author marccio
 */
public class VerInfoProveedor extends HttpServlet {

	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
			String idProveedor = request.getParameter("idProveedor");
			ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
			ctrlUsuarios.seleccionarProveedor(idProveedor);
			DTProveedor dt = ctrlUsuarios.infoProveedor();

			Set<DTMinServicio> servicios = ctrlUsuarios.listarServiciosProveedor();
			Set<DTMinPromocion> promociones = ctrlUsuarios.listarPromocionesProveedor();
			request.setAttribute("servicios", servicios);
			request.setAttribute("promociones", promociones);
			request.setAttribute("nick", dt.getNickname());
			String nombreCompleto = dt.getNombre() + " " + dt.getApellido();
			request.setAttribute("nombre", nombreCompleto);
			Date fechaNacimiento = dt.getFechaNacimiento();
			String fNac = Integer.toString(fechaNacimiento.getDate()) + "-"
					+ Integer.toString(fechaNacimiento.getMonth() + 1) + "-"
					+ Integer.toString(fechaNacimiento.getYear()) + "\n";
			request.setAttribute("fNac", fNac);
			request.setAttribute("email", dt.getEmail());
			request.setAttribute("imagen", dt.getImagen());
			request.setAttribute("empresa", dt.getEmpresa());
			request.setAttribute("webempresa", dt.getWebEmpresa());

			request.getRequestDispatcher("/pages/verInfoProveedor.jsp").forward(request, response);
		} catch (Exception ex) {
			Logger.getLogger(VerInfoProveedor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
