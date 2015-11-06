/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlProductos;

/**
 *
 * @author marccio
 */
public class VerPromocion extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idPromocion = request.getParameter("idPromocion");
        String idProveedor = request.getParameter("idProveedor");
        Fabrica f = Fabrica.getInstance();
        ICtrlProductos ctrlProductos = f.getICtrlProductos();
        DTMinPromocion dtMin = new DTMinPromocion(idProveedor, idPromocion);
        ctrlProductos.seleccionarPromocion(dtMin);
        DTPromocion dtFull = ctrlProductos.infoPromocion();
        Map<DTMinServicio, Integer> servicios = dtFull.getServicios();
        //necesito el nickname del proveedor
        request.setAttribute("idProveedor", dtMin.getNicknameP());
        //y el resto de la info del servicio
        request.setAttribute("infoPromocion", dtFull);
        //paso los servicios
        request.setAttribute("servicios", servicios);
        request.getRequestDispatcher("/pages/verPromocion.jsp").forward(request, response);
    }


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

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
