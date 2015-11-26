/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import webservice.ObjectFactory;
import webservice.WrapperImagen;

public class FileUploadHandler extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//process only if its multipart content
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				String id = (String) request.getSession().getAttribute("usuario_logueado");
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);
				if (!multiparts.isEmpty()) {
					for (FileItem item : multiparts) {
						if (!item.isFormField()) {
							String path = getServletContext().getRealPath("/");
							File f = new File(path + File.separator + "imagenes" + File.separator + "clientes");
							if (!f.exists()) {
								f.mkdir();
							}
							String rutaImagen = f.getAbsolutePath() + File.separator + id + ".jpg";
							item.write(new File(rutaImagen));
							byte[] data = Files.readAllBytes(Paths.get(rutaImagen));
							URL wsdlLocation = new URL(getServletContext().getInitParameter("wsdl"));
							webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
							webservice.Publicador proxy = service.getPublicadorPort();
							ObjectFactory factory = new ObjectFactory();
							WrapperImagen wrapper = factory.createWrapperImagen();
							wrapper.setImagen(data);
							wrapper.setNombre(id + ".jpg");
							proxy.cambiarImagenCliente(new WrapperImagen());

						} else {
							response.sendRedirect("VerPerfil");
						}
					}
				}
				response.sendRedirect("VerPerfil");
			} catch (Exception ex) {
				response.sendRedirect("VerPerfil");
			}
		} else {
			response.sendRedirect("VerPerfil");
		}
	}
}
