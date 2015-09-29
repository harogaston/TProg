/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.tree.DefaultMutableTreeNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlProductos;

/**
 *
 * @author marccio
 */
public class VerInfoServicio extends HttpServlet {

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
        Fabrica f = Fabrica.getInstance();
        ICtrlProductos ctrlProductos = f.getICtrlProductos();
        DefaultMutableTreeNode categorias = ctrlProductos.listarCategorias();
        Enumeration listado = categorias.breadthFirstEnumeration();
        // armo objeto de JSON para armar el árbol con jstree

        JSONArray list = new JSONArray();
        while (listado.hasMoreElements()) {
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) listado.nextElement();
            String categoria = nodo.toString(); //recupero categoria
            DefaultMutableTreeNode padre = (DefaultMutableTreeNode) nodo.getParent();
            String categoriaPadre = "#";
            if (padre != null) {
                categoriaPadre = padre.toString();
            }
            JSONObject tmp = new JSONObject();
            tmp.put("id", categoria);
            tmp.put("parent", categoriaPadre);
            tmp.put("text", categoria);
            list.add(tmp);
        }

        request.setAttribute("arbolJson", list);
        //seteo noHayServicios en false porque al ser la ejecucion inicial de la pagina,
        //no se si hay o no servicios para la categoria seleccionada
        if (request.getAttribute("noHayServicios") == null) { //si no fue seteado anteriormente
            request.setAttribute("noHayServicios", false);
        }

        request.getRequestDispatcher("/pages/verinfoservicio.jsp").forward(request, response);
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
