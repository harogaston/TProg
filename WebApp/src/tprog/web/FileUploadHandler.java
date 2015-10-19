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
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlUsuarios;

public class FileUploadHandler extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//process only if its multipart content
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);
				String name;
				if (!multiparts.isEmpty()) {
					for (FileItem item : multiparts) {
						if (!item.isFormField()) {
							String path = getServletContext().getRealPath("/");
							File f = new File(path + File.separator + "imagenes" + File.separator + "clientes");
							if (!f.exists()) {
								f.mkdir();
							}
							name = new File(item.getName()).getName();
							item.write(new File(f.getAbsolutePath() + File.separator + name));

							Fabrica fabrica = Fabrica.getInstance();
							ICtrlUsuarios ctrlU = fabrica.getICtrlUsuarios();
							ctrlU.seleccionarCliente((String) request.getSession().getAttribute("usuario_logueado"));
							ctrlU.cambiarImagenCliente("imagenes/clientes/" + name);

						} else {
							response.sendRedirect("VerPerfil");
						}
					}
				}
				//File uploaded successfully
				response.sendRedirect("VerPerfil");
			} catch (Exception ex) {
				response.sendRedirect("VerPerfil");
			}
		} else {
			response.sendRedirect("VerPerfil");
		}
	}
}
