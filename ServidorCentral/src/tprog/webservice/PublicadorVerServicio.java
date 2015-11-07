/*
 * Header Test
 */
package tprog.webservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlProductos;

/**
 *
 * @author marccio
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PublicadorVerServicio {

	private Endpoint endpoint = null;

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://localhost:9128/publicadorverservicio", this);
	}

	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}

	@WebMethod
	public WrapperVerServicio verServicio(String idServicio, String idProveedor) {
		//hay que ver como pido las clases de la lógica cuando se saca el .jar
		Fabrica f = Fabrica.getInstance();
		ICtrlProductos ctrlProductos = f.getICtrlProductos();
		DTMinServicio dtMin = new DTMinServicio(idProveedor, idServicio);
		ctrlProductos.seleccionarServicio(dtMin);
		//necesito el nickname del proveedor
//		request.setAttribute("idProveedor", dtMin.getNicknameP());
		//y el resto de la info del servicio
		WrapperVerServicio result = new WrapperVerServicio();
		result.dtServicio = ctrlProductos.infoServicio();;
		//busco categorias y las seteo como atributo a pasarle a la pagina jsp
		result.categorias = ctrlProductos.listarCategoriasServicio();
		//devuelvo una lista con bytes para generar las imagenes
		//desde el lado de la web app
		List<byte[]> imagenes = new ArrayList<>();
		for (String imagen : result.dtServicio.getImagenes()) {
			try {
				File file = new File(imagen);
				FileInputStream streamer = new FileInputStream(file);
				byte[] byteArray = new byte[streamer.available()];
				streamer.read(byteArray);
				imagenes.add(byteArray);
			} catch (IOException ex) {
				Logger.getLogger(PublicadorVerServicio.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		result.imagenes = imagenes;
		return result;
	}

}
