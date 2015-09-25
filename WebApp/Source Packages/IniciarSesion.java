/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tprog.logica.clases.EstadoSesion;
import tprog.logica.controladores.CtrlUsuarios;

/**
 *
 * @author Martin
 */
public class IniciarSesion extends HttpServlet {

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
        HttpSession objSesion = request.getSession();
        String id = request.getParameter("Nickname"); //puede ser email o nickname
        String contraseña = request.getParameter("Password");
        EstadoSesion nuevoEstado;
        CtrlUsuarios cu = new CtrlUsuarios();
        // se checkean los datos de login
        if (cu.idCorrecta(id) & cu.pwCorrecta(id, contraseña)){
            nuevoEstado = EstadoSesion.LOGIN_CORRECTO; 
            request.getSession().setAttribute("usuario_logueado", id);
        }else{
            nuevoEstado = EstadoSesion.LOGIN_INCORRECTO; // ahora da siempre login incorrecot dado que no estan cargados los datos
        }
        objSesion.setAttribute("estado_sesion", nuevoEstado);
        // redirige a la página principal para que luego rediriga a la página
		// que corresponde
	RequestDispatcher dispatcher = request.getRequestDispatcher("/Home");
        dispatcher.forward(request, response);
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
