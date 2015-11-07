/*
 * Header Test
 */
package tprog.webservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.DTServicio;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlProductos;
import tprog.logica.interfaces.ICtrlUsuarios;

/**
 *
 * @author marccio
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Publicador {

	private Endpoint endpoint = null;

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://localhost:9128/publicador", this);
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
				Logger.getLogger(Publicador.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		result.imagenes = imagenes;
		return result;
	}

	@WebMethod
	public WrapperVerPromocion verPromocion(String idPromocion, String idProveedor) {
		Fabrica f = Fabrica.getInstance();
		ICtrlProductos ctrlProductos = f.getICtrlProductos();
		DTMinPromocion dtMin = new DTMinPromocion(idProveedor, idPromocion);
		ctrlProductos.seleccionarPromocion(dtMin);
		DTPromocion dtFull = ctrlProductos.infoPromocion();
		Map<DTMinServicio, Integer> servicios = dtFull.getServicios();
		WrapperVerPromocion result = new WrapperVerPromocion();
		result.promocion = dtFull;
		result.servicios = servicios;
		return result;
	}

	//este metodo se podria incorporar a ver Promocion, pero
	//no me pintó
	@WebMethod
	public DTServicio seleccionarInfoServicio(DTMinServicio dt) {
		//selecciona y servicio y devuelve su información
		//se combinan operaciones para hacerla atómica y evitar problemas
		ICtrlProductos ctrlProductos = Fabrica.getInstance().getICtrlProductos();
		ctrlProductos.seleccionarServicio(dt);
		return ctrlProductos.infoServicio();
	}

	@WebMethod
	public WrapperVerInfoProveedor verInfoProveedor(String idProveedor) {
		try {
			ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
			ctrlUsuarios.seleccionarProveedor(idProveedor);
			DTProveedor dtProveedor = ctrlUsuarios.infoProveedor();
			ICtrlProductos ctrlProductos = Fabrica.getInstance().getICtrlProductos();
			Set<DTMinPromocion> setPromociones = ctrlUsuarios.listarPromocionesProveedor();
			Map<DTPromocion, String> mapPromociones = new HashMap<>();
			for (DTMinPromocion dt : setPromociones) {
				ctrlProductos.seleccionarPromocion(dt);
				DTPromocion tmp = ctrlProductos.infoPromocion();
				mapPromociones.put(tmp, tmp.toString());
			}
			Set<DTMinServicio> setServicios = ctrlUsuarios.listarServiciosProveedor();
			Map<DTServicio, String> mapServicios = new HashMap<>();
			for (DTMinServicio dt : setServicios) {
				ctrlProductos.seleccionarServicio(dt);
				DTServicio tmp = ctrlProductos.infoServicio();
				mapServicios.put(tmp, tmp.toString());
			}
			WrapperVerInfoProveedor result = new WrapperVerInfoProveedor();
			result.promociones = mapPromociones;
			result.servicios = mapServicios;
			result.proveedor = dtProveedor;
			return result;
		} catch (Exception ex) {
			Logger.getLogger(Publicador.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@WebMethod
	public WrapperVerPerfilCliente verPerfilCliente(String idCliente) {
		try {
			Fabrica f = Fabrica.getInstance();
			ICtrlUsuarios ctrlU = f.getICtrlUsuarios();
			ctrlU.seleccionarCliente(idCliente);
			DTCliente dtC = ctrlU.infoCliente();
			Set<DTMinReserva> reservasMin = dtC.getReservas();
			// Voy a crear un Set<DTReserva> para pasarle a la jsp
			Collection<DTReserva> reservas = new TreeSet<>();
			for (DTMinReserva dtMinR : reservasMin) {
				ctrlU.seleccionarReserva(dtMinR.getIdReserva());
				reservas.add(ctrlU.infoReserva());
			}
			WrapperVerPerfilCliente result = new WrapperVerPerfilCliente();
			result.cliente = dtC;
			result.reservas = reservas;
			return result;
		} catch (Exception ex) {
			Logger.getLogger(Publicador.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@WebMethod
	public DTProveedor verPerfilProveedor(String idProveedor) {
		try {
			Fabrica f = Fabrica.getInstance();
			ICtrlUsuarios ctrlU = f.getICtrlUsuarios();
			ctrlU.seleccionarProveedor(idProveedor);
			return ctrlU.infoProveedor();
		} catch (Exception ex) {
			Logger.getLogger(Publicador.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@WebMethod
	public <T> String toString(T o) {
		return o.toString();
	}

//ésto quedó inutilizado porque ya se hace en verInfoProveedor
//	@WebMethod
//	public DTPromocion seleccionarInfoPromocion(DTMinPromocion dt) {
//		//selecciona y servicio y devuelve su información
//		//se combinan operaciones para hacerla atómica y evitar problemas
//		ICtrlProductos ctrlProductos = Fabrica.getInstance().getICtrlProductos();
//		ctrlProductos.seleccionarPromocion(dt);
//		return ctrlProductos.infoPromocion();
//	}
}
