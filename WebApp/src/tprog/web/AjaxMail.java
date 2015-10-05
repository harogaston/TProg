/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlUsuarios;

/**
 *
 * @author Martin
 */
public class AjaxMail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();        
	String id = request.getParameter("mail");
        String resultado;
        ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
	if (id.matches("^\\s*$")){
            resultado = "";
        }else if (id.matches(".*(\\s+).*")){
            resultado = "No utilice espacios.";
        }else if (!ctrlUsuarios.verificarEmail(id)) {
		resultado = " El mail esta disponible";
	} else {
		resultado = " El mail no esta disponible";
	}// se agregan mas if si hay q verificar que sea correcto tambien
	response.setContentType("text/plain");
	response.getWriter().write(resultado);

}
}