/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservice.DtPromocion;
import webservice.DtProveedor;
import webservice.DtServicio;
import webservice.WrapperVerInfoProveedor;

/**
 *
 * @author marccio
 */
public class VerInfoProveedor extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
			String idProveedor = request.getParameter("idProveedor");
			Properties properties = new Properties();
			String ruta = System.getProperty("user.home") + "/.Help4Travel/config.properties";
			FileInputStream file = new FileInputStream(ruta);
			properties.load(file);
			file.close();
			URL wsdlLocation = new URL(properties.getProperty("publicador") + "?wsdl");
			webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
			webservice.Publicador proxy = service.getPublicadorPort();
			WrapperVerInfoProveedor result = proxy.verInfoProveedor(idProveedor);
			DtProveedor dt = result.getProveedor();
			//armo mapa de servicios
			List<webservice.WrapperVerInfoProveedor.Servicios.Entry> listServicios
					= result.getServicios().getEntry();
			Map<DtServicio, String> servicios = new HashMap<>();
			for (webservice.WrapperVerInfoProveedor.Servicios.Entry entry : listServicios) {
				servicios.put(entry.getKey(), entry.getValue());
			}
			//armo mapa promociones
			List<WrapperVerInfoProveedor.Promociones.Entry> listPromociones
					= result.getPromociones().getEntry();
			Map<DtPromocion, String> promociones = new HashMap<>();
			for (WrapperVerInfoProveedor.Promociones.Entry entry : listPromociones) {
				promociones.put(entry.getKey(), entry.getValue());
			}
			//seteo atributos de la request
			request.setAttribute("servicios", servicios);
			request.setAttribute("promociones", promociones);
			request.setAttribute("nick", dt.getNickname());
			String nombreCompleto = dt.getNombre() + " " + dt.getApellido();
			request.setAttribute("nombre", nombreCompleto);
			Date fechaNacimiento = new Date(
					dt.getFechaNacimiento().getYear(),
					dt.getFechaNacimiento().getMonth(),
					dt.getFechaNacimiento().getDay());
			String fNac = Integer.toString(fechaNacimiento.getDate()) + "-"
					+ Integer.toString(fechaNacimiento.getMonth() + 1) + "-"
					+ Integer.toString(fechaNacimiento.getYear()) + "\n";
			request.setAttribute("fNac", fNac);
			request.setAttribute("email", dt.getEmail());
			byte[] bytesImagen = result.getImagen();
			if (bytesImagen != null) {
				BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytesImagen));
				String rutaRelativaImagen = "imagenes/clientes/" + dt.getNickname() + ".jpg";
				String rutaCompletaImagen = getServletContext().getRealPath("/") + "/" + rutaRelativaImagen;
				File outputFile = new File(rutaCompletaImagen);
				outputFile.getParentFile().mkdirs();
				ImageIO.write(img, "jpg", outputFile);
				System.out.println("Ruta imagen original = " + dt.getImagen());
				System.out.println("Ruta relativa = " + rutaCompletaImagen);
				request.setAttribute("imagen", rutaRelativaImagen);
			}
			request.setAttribute("empresa", dt.getEmpresa());
			request.setAttribute("webempresa", dt.getWebEmpresa());
			//forwardeo request
			request.getRequestDispatcher("/pages/verInfoProveedor.jsp").forward(request, response);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(VerInfoProveedor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
