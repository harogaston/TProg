/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

 import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import tprog.logica.clases.Cliente;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlUsuarios;
import tprog.logica.manejadores.ManejadorUsuarios;


public class FileUploadHandler extends HttpServlet {
    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
                String name;
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String path = getServletContext().getRealPath("/");
                        File f = new File(path+File.separator+"imagenes"+File.separator+"clientes");
                        if(!f.exists())f.mkdir();
                        name = new File(item.getName()).getName();
                        item.write( new File(f.getAbsolutePath()+File.separator+name));
                        
                        Fabrica fabrica = Fabrica.getInstance();
                        ICtrlUsuarios ctrlU = fabrica.getICtrlUsuarios();
                        ctrlU.seleccionarCliente((String) request.getSession().getAttribute("usuario_logueado"));
                        ctrlU.cambiarImagenCliente("imagenes/clientes/"+name);
                        
                    }
                }
           
               //File uploaded successfully
               
               //request.setAttribute("message", "File Uploaded Successfully");
               request.getRequestDispatcher("/pages/perfil.jsp").forward(request, response);
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
    
        request.getRequestDispatcher("Home").forward(request, response);
     
    }
  
}