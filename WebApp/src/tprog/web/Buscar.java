/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTServicio;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlProductos;

/**
 *
 * @author marccio
 */
@WebServlet(name = "Buscar", urlPatterns = {"/Buscar"})
public class Buscar extends HttpServlet {

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
        try {
            //        response.setContentType("text/html;charset=UTF-8");
            CharSequence busqueda = request.getParameter("busqueda"); //extraigo texto buscado
            ICtrlProductos ctrlProductos = Fabrica.getInstance().getICtrlProductos();
            Set<DTMinServicio> servicios;
            servicios = ctrlProductos.listarServicios();
            if (busqueda != null) {
                //filtro resultados de la búsqueda

                Iterator<DTMinServicio> iterator = servicios.iterator();
                while (iterator.hasNext()) {
                    DTMinServicio servicio = iterator.next();
                    ctrlProductos.seleccionarServicio(servicio);
                    Set<String> categorias = ctrlProductos.listarCategoriasServicio();
                    DTServicio infoServicio = ctrlProductos.infoServicio();
                    //chequeo si alguna categoria del servicio coincide con la búsqueda
                    boolean matcheaCategoria = false;
                    for (String categoria : categorias) {
                        if (categoria.contains(busqueda)) {
                            matcheaCategoria = true;
                            break;
                        }
                    }
                    if (!(infoServicio.getDescripcion().contains(busqueda)
                            || infoServicio.getIdServicio().contains(busqueda)
                            || matcheaCategoria)) { //si no matchea nada
                        iterator.remove();
                    }

                }
            }
            request.setAttribute("servicios", servicios);
            request.getRequestDispatcher("/pages/busqueda.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
