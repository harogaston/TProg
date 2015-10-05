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
public class AjaxNickname extends HttpServlet {

    
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("nickname");
        String resultado;
        ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
        if (id.matches("^\\s*$")){
            resultado = "";
        }else if (id.matches(".*(\\s+).*")){
            resultado = "No utilice espacios.";
        }else if(!ctrlUsuarios.verificarNickname(id)) {
		resultado = " El nickname esta disponible.";
	} else {
		resultado = " El nickname no esta disponible.";
	}// se agregan mas if si hay q verificar que sea correcto tambien
	response.setContentType("text/plain");
	response.getWriter().write(resultado);
        
        
}

}
