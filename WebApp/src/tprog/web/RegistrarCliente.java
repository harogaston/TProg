package tprog.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.commons.validator.routines.EmailValidator;
import tprog.logica.dt.DTUsuario;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlUsuarios;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "RegistrarCliente", urlPatterns = {"/RegistrarCliente"})
public class RegistrarCliente extends HttpServlet {
         

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
                // configures upload settings
        // checks if the request actually contains upload file
                boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
                if (isMultiPart){
                    ServletFileUpload upload = new ServletFileUpload();
                    try{
                        FileItemIterator itr = upload.getItemIterator(request);
                        while(itr.hasNext()){
                            FileItemStream item = itr.next();
                            if(item.isFormField()){
                                //do field specific process
                                
                            }else{
                                //do field upload specific process
                                String path = getServletContext().getRealPath("/");
                                //call a method to upload file
                                if (FileUpload.processFile(path, item)){
                                    
                                }else response.getWriter().println("file uploaded failed");
                            }
                        }
                        
                    
               
		
                        
                        
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

			//Verificación de email
			EmailValidator emailValidator = EmailValidator.getInstance(true);
			boolean okEmail = emailValidator.isValid(mail);

			//Verificacion de nickname
			boolean okEnblanco = !id.matches("^\\s*$");
			boolean okSinEspacios = !id.matches(".*(\\s+).*");
			boolean okNickname = okEnblanco && okSinEspacios;
			boolean nicknameUnico = false;
			if (okNickname) {
				nicknameUnico = cu.verificarNickname(id);
			}
			boolean emailUnico = true;
			if (okEmail) {
				emailUnico = cu.verificarEmail(mail);
			}
			boolean okNickMail = false;
			if (okNickname && okEmail && !emailUnico && !nicknameUnico) {
				okNickMail = true;
			}
			if (okNickMail) {
				//Verificacion de contraseña
				boolean okPassword1 = contrasena.length() >= 4 && contrasena.length() <= 20;
				boolean okPassword2 = contrasena2.length() >= 4 && contrasena2.length() <= 20;
				boolean okPassword = (okPassword1 && okPassword2 && contrasena.equals(contrasena2));
				// Verificación de nombre y apellido
				boolean okNombre = !nombre.matches("^\\s*$");
				boolean okApellido = !apellido.matches("^\\s*$");

				//Verificación de Imagen - falta
				boolean okImagen = true;

				if (okNombre && okApellido && okImagen && okPassword) {
					// doy de alta el cliente
					DTUsuario dtU = new DTUsuario(id, contrasena, nombre, apellido, mail, null, dateNac);
					cu.ingresarDatosUsuario(dtU, false);
					cu.altaUsuario();

					//logueo el usuario recien registrado
					request.getRequestDispatcher("IniciarSesion").forward(request, response);
				} else {
					request.getRequestDispatcher("Home").forward(request, response);
				}

			} else {
				request.getRequestDispatcher("Home").forward(request, response);
			}

		}catch(FileUploadException fue){
                        fue.printStackTrace();
                    } catch (ParseException ex) {
			Logger.getLogger(RegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
             Logger.getLogger(RegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
         }
	}
}
}
