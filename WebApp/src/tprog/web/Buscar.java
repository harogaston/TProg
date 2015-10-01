/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.tree.DefaultMutableTreeNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import tprog.logica.dt.DTMinPromocion;
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
    public static CharSequence busquedaAnterior = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //        response.setContentType("text/html;charset=UTF-8");
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
                if (!listado.hasMoreElements()) { //agrego nodo Promociones
                    tmp.put("id", "Promociones");
                    tmp.put("parent", "#");
                    tmp.put("text", "Promociones");
                }
                list.add(tmp);
            }

            request.setAttribute("arbolJson", list);

            CharSequence busqueda = request.getParameter("busqueda"); //extraigo texto buscado
            Set<DTMinServicio> serviciosBusqueda;
            try {
                serviciosBusqueda = ctrlProductos.listarServicios();
            } catch (Exception ex) {
                serviciosBusqueda = new HashSet();
            }
            if (busqueda != null) {
                busquedaAnterior = busqueda;
                //filtro resultados de la búsqueda
                if (!serviciosBusqueda.isEmpty()) {
                    Iterator<DTMinServicio> iterator = serviciosBusqueda.iterator();
                    while (iterator.hasNext()) {
                        DTMinServicio servicio = iterator.next();
                        ctrlProductos.seleccionarServicio(servicio);
                        Set<String> listaCategorias = ctrlProductos.listarCategoriasServicio();
                        DTServicio infoServicio = ctrlProductos.infoServicio();
                        //chequeo si alguna categoria del servicio coincide con la búsqueda
                        boolean matcheaCategoria = false;
                        for (String categoria : listaCategorias) {
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
            } else if (busquedaAnterior != null) { //si busqueda es null, entonces agarro la busqueda anterior y filtro según los resultados de ella
                if (!serviciosBusqueda.isEmpty()) {
                    Iterator<DTMinServicio> iterator = serviciosBusqueda.iterator();
                    while (iterator.hasNext()) {
                        DTMinServicio servicio = iterator.next();
                        ctrlProductos.seleccionarServicio(servicio);
                        Set<String> listaCategorias = ctrlProductos.listarCategoriasServicio();
                        DTServicio infoServicio = ctrlProductos.infoServicio();
                        //chequeo si alguna categoria del servicio coincide con la búsqueda
                        boolean matcheaCategoria = false;
                        for (String categoria : listaCategorias) {
                            if (categoria.contains(busquedaAnterior)) {
                                matcheaCategoria = true;
                                break;
                            }
                        }
                        if (!(infoServicio.getDescripcion().contains(busquedaAnterior)
                                || infoServicio.getIdServicio().contains(busquedaAnterior)
                                || matcheaCategoria)) { //si no matchea nada
                            iterator.remove();
                        }

                    }
                }
            }
            //filtro servicios de acuerdo a categoria
            if (request.getParameter("categoriaSeleccionada") != null) {
                String categoriaSeleccionada = (String) request.getParameter("categoriaSeleccionada");
                if (busqueda != null) {
                    Set<DTMinServicio> serviciosPorCategoria = ctrlProductos.listarServiciosCategoria(categoriaSeleccionada);
                    if (!serviciosPorCategoria.isEmpty() && !serviciosBusqueda.isEmpty()) { //hay posible interseccion
                        //entrego lista de servicios para que la página jsp los muestre
                        //construyo mapa para la interfaz usando el set
                        //para no tener elementos repetidos
                        Set<DTMinServicio> serviciosInterseccion = new HashSet<>(); //interseccion entre busqueda y filtro por categorias
                        for (DTMinServicio dt1 : serviciosBusqueda) {
                            for (DTMinServicio dt2 : serviciosPorCategoria) {
                                if (dt1.toString().equals(dt2.toString())) {
                                    serviciosInterseccion.add(dt1);
                                }
                            }
                        }
                        request.setAttribute("servicios", serviciosInterseccion);
                        if (serviciosInterseccion.isEmpty()) {
                            request.setAttribute("noHayServicios", true);
                        } else {
                            request.setAttribute("noHayServicios", false);
                        }
                    } else { //no es posible la intersección
                        request.setAttribute("noHayServicios", true);
                    }
                } else {
                    Set<DTMinServicio> servicios = ctrlProductos.listarServiciosCategoria(categoriaSeleccionada);
                    request.setAttribute("servicios", servicios);
                    if (servicios.isEmpty()) {
                        request.setAttribute("noHayServicios", true);
                    } else {
                        request.setAttribute("noHayServicios", false);
                    }

                }
            } else {
                request.setAttribute("servicios", serviciosBusqueda);
                if (serviciosBusqueda.isEmpty()) {
                    request.setAttribute("noHayServicios", true);
                } else {
                    request.setAttribute("noHayServicios", false);
                }
            }

            //si se selecciona una categoria, no puedo mostrar promociones
            //solo muestro promociones cuando no hay busqueda ni filtro (salvo "Promociones" en categoria y/o búsqueda)
            if ((request.getParameter("categoriaSeleccionada") == null && busqueda == null)
                    || (request.getParameter("categoriaSeleccionada") != null && request.getParameter("categoriaSeleccionada").equals("Promociones"))
                    || (busqueda != null && busqueda.equals("Promociones"))) {
                Set<DTMinPromocion> promociones;
                try {
                    promociones = ctrlProductos.listarPromociones();
                } catch (Exception ex) {
                    promociones = new HashSet();
                }
                request.setAttribute("promociones", promociones);
                if (!promociones.isEmpty()) {
                    request.setAttribute("mostrarPromociones", true);
                } else {
                    request.setAttribute("mostrarPromociones", false);
                }
            } else {
                request.setAttribute("mostrarPromociones", false);
            }

            request.setAttribute("categoriaSeleccionada", request.getParameter("categoriaSeleccionada"));
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
