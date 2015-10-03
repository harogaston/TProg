/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tprog.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tprog.logica.dt.DTUsuario;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlReservas;
import tprog.logica.interfaces.ICtrlUsuarios;

/**
 *
 * @author ignacio.prandi
 */
@WebServlet(name = "RegistrarCliente", urlPatterns = {"/RegistrarCliente"})
public class RegistrarCliente extends HttpServlet {

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
                HttpSession session = request.getSession();
                if (session.getAttribute("estado_sesion") != EstadoSesion.OK_LOGIN) { //no estoy logueado
                    System.out.println(request.getParameterMap().toString());
                    
                    // leo los datos -falta checkear que sean correctos y esas manos-
                    
                    String id = request.getParameter("nickname"); 
                    String mail = request.getParameter("mail"); 
                    // el checkeo de mail y nick es "en tiempo real" con ajax -falta-
                    
                    String contrasena = request.getParameter("password");
                    String contrasena2 = request.getParameter("password2");
                    String nombre = request.getParameter("nombre"); 
                    String apellido = request.getParameter("apellido");
                    //falta imagen
                    String imagen = request.getParameter("imagen"); 
                    //obtengo strings para las fechas, en formato dd/mm/aaaa, hay que parsearlas
                    String fechaNac = request.getParameter("fNac");
                    DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date dateNac = sourceFormat.parse(fechaNac); 
                    EstadoSesion nuevoEstado;
                    Fabrica f = Fabrica.getInstance();
                    ICtrlUsuarios cu = f.getICtrlUsuarios();
                    // se checkean los datos del registro
                    //Verificación de email
                    
                    //EmailValidator emailValidator = EmailValidator.getInstance(true);
                    //boolean okEmail = emailValidator.isValid(email);

                    //Verificacion de nickname
                    boolean okEnblanco = !id.matches("^\\s*$");
                    boolean okSinEspacios = !id.matches(".*(\\s+).*");
                    boolean okNickname = okEnblanco && okSinEspacios;
                    
                    boolean nicknameUnico = false;
                    if (okNickname) {
                            nicknameUnico = cu.verificarNickname(id);
                    }
                    boolean emailUnico = false;
                   // if (okEmail) 
                            emailUnico = cu.verificarEmail(mail);
                    boolean okNickMail = false;
                    if (okNickname && emailUnico && nicknameUnico){ // &&okEmail
                        okNickMail = true;
                    }
                    if (okNickMail){ //mail y nick correctos - falta hacer con ajax
                         //Verificacion de contraseña
                        boolean okPassword1 = contrasena.length() >= 4 && contrasena.length() <= 20;
                        boolean okPassword2 = contrasena2.length() >= 4 && contrasena2.length() <= 20;
                        boolean okPassword = (okPassword1 && okPassword2 && contrasena.equals(contrasena2));



                        // Verificación de nombre y apellido
                        boolean okNombre = !nombre.matches("^\\s*$");
                        boolean okApellido = !apellido.matches("^\\s*$");

                        // Verificación de la fecha de nacimiento - falta
                        boolean okFecha = true;
                        
                        //Verificación de Imagen - falta
                        boolean okImagen = true;

                        if (okNombre && okApellido && okFecha && okImagen && okPassword) { // &&okEmail
                            // doy de alta el cliente
                            DTUsuario dtU = new DTUsuario(id, contrasena, nombre, apellido, mail, null, dateNac);
                            cu.ingresarDatosUsuario(dtU, false);
                            cu.altaUsuario();


                            //logueo el usuario recien registrado
                            ICtrlReservas cr = f.getICtrlReservas(); //se lo asocio por la duracion de la sesion
                            cr.liberarMemoriaControlador();
                            session.setAttribute("ctrlReservas", cr);
                            nuevoEstado = EstadoSesion.OK_LOGIN;
                            request.getSession().setAttribute("usuario_logueado", id);
                            session.setAttribute("estado_sesion", nuevoEstado);
                            session.setAttribute("cant_items", 0);
                        }
                        request.getRequestDispatcher("/pages/registrarCliente.jsp").forward(request, response);
                    }

                }else{
                        //ya estoy logueado. Deslogueo automaticamente? no lo dejo registrarse?
                        // FALTA 
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("<html>");
                        out.println("<body>");
                        out.println("<h1>YA ESTAS LOGUEADO PAPU, deslogueate o algo</h1>");
                        out.println("</body>");
                        out.println("</html>");   
                    }
            } catch (ParseException ex) {
                        Logger.getLogger(RegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
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
