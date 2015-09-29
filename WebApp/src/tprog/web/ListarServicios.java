/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlProductos;

/**
 *
 * @author marccio
 */
public class ListarServicios extends HttpServlet {

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
        String categoriaSeleccionada = request.getParameter("categoriaSeleccionada");
        Fabrica f = Fabrica.getInstance();
        ICtrlProductos ctrlProductos = f.getICtrlProductos();
        Set<DTMinServicio> servicios = ctrlProductos.listarServiciosCategoria(categoriaSeleccionada);
        if (servicios.isEmpty()) {
            request.setAttribute("noHayServicios", true);
            request.getRequestDispatcher("VerInfoServicio").forward(request, response);
        } else { //redirijo a la página de listado de servicios

            //construyo lista para la interfaz usando el set
            //para no tener elementos repetidos
            Set<String> listaServiciosSinRepetir = new HashSet<>();
            for (DTMinServicio dt : servicios) {
                String servicioActual = dt.getIdServicio();
                if (!listaServiciosSinRepetir.contains(servicioActual)) {
                    listaServiciosSinRepetir.add(dt.getIdServicio());
                }
            }

            request.setAttribute("servicios", listaServiciosSinRepetir);
            request.getRequestDispatcher("/pages/listarservicios.jsp").forward(request, response);
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
