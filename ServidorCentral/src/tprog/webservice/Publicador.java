/*
 * Header Test
 */
package tprog.webservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.ws.Endpoint;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SortedSet;
import javax.jws.WebParam;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTLineaReserva;
import tprog.logica.dt.DTMinCliente;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUsuario;
import tprog.logica.dt.EstadoReserva;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlProductos;
import tprog.logica.interfaces.ICtrlReservas;
import tprog.logica.interfaces.ICtrlUsuarios;

/**
 *
 * @author marccio
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Publicador {

	private int sigNumCliente = 0;
	Map<Integer, ICtrlReservas> mapControladoresReserva = new HashMap<>();
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
	public int pedirNumeroCtrlReservas() {
		while (mapControladoresReserva.containsKey(sigNumCliente)) {
			sigNumCliente++;
		}
		mapControladoresReserva.put(sigNumCliente, Fabrica.getInstance().getICtrlReservas());
		mapControladoresReserva.get(sigNumCliente).liberarMemoriaControlador();
		return sigNumCliente;
	}

	@WebMethod
	public WrapperVerServicio verServicio(
			@WebParam(name = "id_servicio") String idServicio,
			@WebParam(name = "id_proveedor") String idProveedor
	) {
		//hay que ver como pido las clases de la lógica cuando se saca el .jar
		Fabrica f = Fabrica.getInstance();
		ICtrlProductos ctrlProductos = f.getICtrlProductos();
		DTMinServicio dtMin = new DTMinServicio(idProveedor, idServicio);
		ctrlProductos.seleccionarServicio(dtMin);
		//necesito el nickname del proveedor
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
	public WrapperVerPromocion verPromocion(
			@WebParam(name = "id_promocion") String idPromocion,
			@WebParam(name = "id_proveedor") String idProveedor
	) {
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
	public DTServicio seleccionarInfoServicio(
			@WebParam(name = "dt") DTMinServicio dt
	) {
		//selecciona y servicio y devuelve su información
		//se combinan operaciones para hacerla atómica y evitar problemas
		ICtrlProductos ctrlProductos = Fabrica.getInstance().getICtrlProductos();
		ctrlProductos.seleccionarServicio(dt);
		return ctrlProductos.infoServicio();
	}

	@WebMethod
	public WrapperVerInfoProveedor verInfoProveedor(
			@WebParam(name = "id_proveedor") String idProveedor
	) {
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
	public DTProveedor verPerfilProveedor(String nickProveedor) {
		try {
			ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
			ctrlUsuarios.seleccionarProveedor(nickProveedor);
			return ctrlUsuarios.infoProveedor();
		} catch (Exception ex) {
			Logger.getLogger(Publicador.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@WebMethod
	public WrapperVerServiciosProveedor verServiciosProveedor(String nickProveedor) {
		Fabrica f = Fabrica.getInstance();
		ICtrlProductos ctrlProductos = f.getICtrlProductos();
		Set<DTMinServicio> serviciosTodos;
		try {
			serviciosTodos = ctrlProductos.listarServicios();
		} catch (Exception ex) {
			serviciosTodos = new HashSet();
		}
		WrapperVerServiciosProveedor result = new WrapperVerServiciosProveedor();
		result.servicios = new HashMap<>();
		for (DTMinServicio dt : serviciosTodos) {
			if (dt.getNicknameP().equals(nickProveedor)) {
				ctrlProductos.seleccionarServicio(dt);
				DTServicio servicio = ctrlProductos.infoServicio();
				result.servicios.put(servicio, servicio.toString());
			}
		}
		return result;
	}

	@WebMethod
	public WrapperVerPromocionesProveedor verPromocionesProveedor(String nickProveedor) {
		Fabrica f = Fabrica.getInstance();
		ICtrlProductos ctrlProductos = f.getICtrlProductos();
		Set<DTMinPromocion> promocionesTodas;
		try {
			promocionesTodas = ctrlProductos.listarPromociones();
		} catch (Exception ex) {
			promocionesTodas = new HashSet();
		}
		WrapperVerPromocionesProveedor result = new WrapperVerPromocionesProveedor();
		result.promociones = new HashMap<>();
		for (DTMinPromocion dt : promocionesTodas) {
			if (dt.getNicknameP().equals(nickProveedor)) {
				ctrlProductos.seleccionarPromocion(dt);
				DTPromocion promocion = ctrlProductos.infoPromocion();
				result.promociones.put(promocion, promocion.toString());
			}
		}
		return result;
	}

	@WebMethod
	public WrapperVerPerfilCliente verPerfilCliente(
			@WebParam(name = "id_cliente") String idCliente
	) {
		try {
			Fabrica f = Fabrica.getInstance();
			ICtrlUsuarios ctrlU = f.getICtrlUsuarios();
			ctrlU.seleccionarCliente(idCliente);
			DTCliente dtC = ctrlU.infoCliente();
			Set<DTMinReserva> reservasMin = dtC.getReservas();
			// Voy a crear un Set<DTReserva> para pasarle a la jsp
			Set<DTReserva> reservas = new TreeSet<>();
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
	public WrapperVerReservasProveedor verReservasProveedor(
			@WebParam(name = "id_proveedor") String idProveedor
	) throws Exception {
		ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
		ctrlUsuarios.seleccionarProveedor(idProveedor);
		WrapperVerReservasProveedor result = new WrapperVerReservasProveedor();
		result.reservasCliente = new TreeSet<>();
		DTProveedor dtProveedor = ctrlUsuarios.infoProveedor();
		result.dtP = dtProveedor;
		ICtrlReservas ctrlReservas = Fabrica.getInstance().getICtrlReservas();
		ctrlReservas.seleccionarProveedor(idProveedor);
		Set<DTReserva> reservas = ctrlReservas.listarReservasProveedor();
		for (DTReserva reserva : reservas) {
			ctrlReservas.seleccionarReserva(reserva.getIdReserva());
			WrapperReserva tmp = new WrapperReserva();
			tmp.nickCliente = ctrlReservas.getClienteAsociado().getNickname();
			tmp.reserva = reserva;
			result.reservasCliente.add(tmp);
		}
		return result;
	}

	@WebMethod
	public WrapperBuscar buscar(
			@WebParam(name = "busqueda_previa") String busquedaPrevia,
			@WebParam(name = "seleccion_previa") String seleccionPrevia,
			@WebParam(name = "tipo_orden") String tipoOrden,
			@WebParam(name = "busqueda") String busqueda,
			@WebParam(name = "categoria_seleccionada") String categoriaSeleccionada
	) {
		WrapperBuscar result = new WrapperBuscar();
		Fabrica f = Fabrica.getInstance();
		ICtrlProductos ctrlProductos = f.getICtrlProductos();
		DefaultMutableTreeNode categorias = ctrlProductos.listarCategorias();
		Enumeration listado = categorias.breadthFirstEnumeration();

		// armo objeto de JSON para armar el árbol con jstree
		JsonArray list = new JsonArray();
		while (listado.hasMoreElements()) {
			DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) listado.nextElement();
			String categoria = nodo.toString(); //recupero categoria
			DefaultMutableTreeNode padre = (DefaultMutableTreeNode) nodo.getParent();
			String categoriaPadre = "#";
			if (padre != null) {
				categoriaPadre = padre.toString();
			}
			JsonObject tmp = new JsonObject();
			tmp.addProperty("id", categoria);
			tmp.addProperty("parent", categoriaPadre);
			tmp.addProperty("text", categoria);
			if (!listado.hasMoreElements()) { //agrego nodo Promociones
				tmp.addProperty("id", "Promociones");
				tmp.addProperty("parent", "#");
				tmp.addProperty("text", "Promociones");
			}
			list.add(tmp);
		}
		result.arbolCategorias = list.toString();
		// Obtengo todos los servicios del sistema
		Set<DTMinServicio> serviciosTodos;
		try {
			serviciosTodos = ctrlProductos.listarServicios();
		} catch (Exception ex) {
			serviciosTodos = new HashSet();
		}
		// Obtengo todas las promociones del sistema
		Set<DTMinPromocion> promocionesTodas;
		try {
			promocionesTodas = ctrlProductos.listarPromociones();
		} catch (Exception ex) {
			promocionesTodas = new HashSet();
		}
		result.terminosTypeAhead = typeahead();
		// Defino el orden
		Collection<DTServicio> serviciosResultado;
		Collection<DTPromocion> promocionesResultado;
		if (tipoOrden != null && tipoOrden.equals("precio")) {
			// Ordenados por precio
			busqueda = busquedaPrevia;
			categoriaSeleccionada = seleccionPrevia;
			serviciosResultado = new TreeSet<>(DTServicio::comparePrecio);
			promocionesResultado = new TreeSet<>(DTPromocion::comparePrecio);
			result.tipoOrden = "precio";
		} else if (tipoOrden != null && tipoOrden.equals("alfabetico")) {
			// Ordenados por nombre
			busqueda = busquedaPrevia;
			categoriaSeleccionada = seleccionPrevia;
			serviciosResultado = new TreeSet<>();
			promocionesResultado = new TreeSet<>();
			result.tipoOrden = "alfabetico";
		} else {
			// Orden por defecto
			serviciosResultado = new HashSet<>();
			promocionesResultado = new HashSet<>();
			result.tipoOrden = "";
		}
		// Si no hay busqueda ni categoría muestro todo
		if ((busqueda == null || busqueda.equals("null"))
				&& (categoriaSeleccionada == null || categoriaSeleccionada.equals("null"))) {
			// Todos los servicios
			if (!serviciosTodos.isEmpty()) {
				for (DTMinServicio dtMinS : serviciosTodos) {
					ctrlProductos.seleccionarServicio(dtMinS);
					DTServicio infoServicio = ctrlProductos.infoServicio();
					serviciosResultado.add(infoServicio);
				}
			}
			// Todas las promociones
			if (!promocionesTodas.isEmpty()) {
				for (DTMinPromocion dtMinP : promocionesTodas) {
					ctrlProductos.seleccionarPromocion(dtMinP);
					DTPromocion infoPromocion = ctrlProductos.infoPromocion();
					promocionesResultado.add(infoPromocion);
				}
			}
			// Si se realizó una búsqueda
		} else if (busqueda != null && !busqueda.equals("null")) {
			System.out.println("if de busqueda");
			// Busco servicios que contengan el término buscado
			serviciosResultado = ctrlProductos.listarServiciosPorTermino(busqueda);
			// Busco promociones que contengan el término buscado
			promocionesResultado = ctrlProductos.listarPromocionesPorTermino(busqueda);
			// Si se seleccionó una categoría del árbol
		} else if (categoriaSeleccionada != null && !categoriaSeleccionada.equals("null")) {
			System.out.println("if de categorias");
			// Me fijo si debo listar las promociones
			if (categoriaSeleccionada.equals("Promociones")) {
				// Devuelvo todas las promociones
				if (!promocionesTodas.isEmpty()) {
					for (DTMinPromocion dtMinP : promocionesTodas) {
						ctrlProductos.seleccionarPromocion(dtMinP);
						DTPromocion infoPromocion = ctrlProductos.infoPromocion();
						promocionesResultado.add(infoPromocion);
					}
				}
			} else {
				// Agrego todos los servicios de esa categoría
				Set<DTMinServicio> serviciosDeCategoria = ctrlProductos.listarServiciosCategoria(categoriaSeleccionada);
				for (DTMinServicio dtMinS : serviciosDeCategoria) {
					ctrlProductos.seleccionarServicio(dtMinS);
					DTServicio infoServicio = ctrlProductos.infoServicio();
					serviciosResultado.add(infoServicio);
				}
			}
		}
		Map<DTServicio, String> servicios = new HashMap<>();
		for (DTServicio dt : serviciosResultado) {
			servicios.put(dt, dt.toString());
		}
		Map<DTPromocion, String> promociones = new HashMap<>();
		for (DTPromocion dt : promocionesResultado) {
			promociones.put(dt, dt.toString());
		}
		result.servicios = servicios;
		result.promociones = promociones;
		result.categoriaPrevia = categoriaSeleccionada;
		result.busquedaPrevia = busqueda;
		return result;
	}

	@WebMethod
	public String typeahead() {
		Fabrica f = Fabrica.getInstance();
		ICtrlProductos ctrlProductos = f.getICtrlProductos();
		Set<DTMinServicio> serviciosTodos;
		try {
			serviciosTodos = ctrlProductos.listarServicios();
		} catch (Exception ex) {
			serviciosTodos = new HashSet();
		}
		// Obtengo todas las promociones del sistema
		Set<DTMinPromocion> promocionesTodas;
		try {
			promocionesTodas = ctrlProductos.listarPromociones();
		} catch (Exception ex) {
			promocionesTodas = new HashSet();
		}
		// TYPEAHEAD
		JsonArray termsArray = new JsonArray();
		if (!serviciosTodos.isEmpty()) {
			for (DTMinServicio dtMinS : serviciosTodos) {
				termsArray.add(dtMinS.getIdServicio());
			}
		}
		if (!promocionesTodas.isEmpty()) {
			for (DTMinPromocion dtMinP : promocionesTodas) {
				termsArray.add(dtMinP.getIdPromocion());
			}
		}
		return termsArray.toString();
	}

	@WebMethod
	public boolean verificarEmail(
			@WebParam(name = "email") String email
	) {
		ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
		return ctrlUsuarios.verificarEmail(email);
	}

	@WebMethod
	public boolean verificarNickname(
			@WebParam(name = "nickname") String nickname
	) {
		ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
		return ctrlUsuarios.verificarNickname(nickname);
	}

	@WebMethod
	public boolean verificarLoginProveedor(
			@WebParam(name = "id") String id,
			@WebParam(name = "pass") String pass) {
		ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
		return ctrlUsuarios.idCorrectaProveedor(id) && ctrlUsuarios.pwCorrectaProveedor(id, pass);
	}

	@WebMethod
	public boolean verificarLoginCliente(
			@WebParam(name = "id") String id,
			@WebParam(name = "pass") String pass) {
		ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
		return ctrlUsuarios.idCorrecta(id) && ctrlUsuarios.pwCorrecta(id, pass);
	}

	@WebMethod
	public String obtenerIdCliente(
			@WebParam(name = "id") String id,
			@WebParam(name = "pass") String pass) {
		ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
		return ctrlUsuarios.obtenerIdCliente(id, pass);
	}

	@WebMethod
	public String obtenerIdProveedor(
			@WebParam(name = "id") String id,
			@WebParam(name = "pass") String pass) {
		ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
		return ctrlUsuarios.obtenerIdProveedor(id, pass);
	}

	@WebMethod
	public void altaUsuario(
			String id,
			String contrasena,
			String nombre,
			String apellido,
			String mail,
			String fechaNac,
			String imagen,
			boolean esProveedor,
			String empresa,
			String web
	) {

		try {
			DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateNac = sourceFormat.parse(fechaNac);
			ICtrlUsuarios ctrlUsuarios = Fabrica.getInstance().getICtrlUsuarios();
			//se crea un nuevo dt por quilombos con la fecha
			DTUsuario dtNuevo = new DTUsuario(
					id,
					contrasena,
					nombre,
					apellido,
					mail,
					imagen,
					dateNac
			);
			ctrlUsuarios.ingresarDatosUsuario(dtNuevo, esProveedor);
			if (esProveedor) {
				ctrlUsuarios.ingresarDatosProveedor(empresa, web);
			}
			ctrlUsuarios.altaUsuario();

		} catch (ParseException ex) {
			Logger.getLogger(Publicador.class
					.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@WebMethod
	public void cancelarReserva(
			@WebParam(name = "id_ctrl_reservas") int idCtrlReservas,
			@WebParam(name = "id_reserva") String idReserva) {
		ICtrlReservas ctrlReservas = mapControladoresReserva.get(idCtrlReservas);
		ctrlReservas.seleccionarReserva(Integer.parseInt(idReserva));
		ctrlReservas.cambiarEstadoReserva(EstadoReserva.Cancelada);
	}

	@WebMethod
	public void generarReserva(
			@WebParam(name = "nickname") String nickname,
			@WebParam(name = "idCtrlReservas") int idCtrlReservas) {
		try {
			ICtrlReservas ctrlReservas = mapControladoresReserva.get(idCtrlReservas);
			ctrlReservas.seleccionarCliente(nickname);
			ctrlReservas.altaReserva(ctrlReservas.mostrarReservaTemporal());
			ctrlReservas.liberarMemoriaControlador();

		} catch (Exception ex) {
			Logger.getLogger(Publicador.class
					.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@WebMethod
	public DTReserva agregarServicioCarrito(
			@WebParam(name = "id_ctrl_reservas") int idCtrlReservas,
			@WebParam(name = "nickname") String nickname,
			@WebParam(name = "id_servicio") String idServicio,
			@WebParam(name = "id_proveedor") String idProveedor,
			@WebParam(name = "cantidad") int cantidad,
			@WebParam(name = "fecha_inicio") String fechaInicio,
			@WebParam(name = "fecha_fin") String fechaFin
	) {
		//devuelve reserva temporal
		try {
			ICtrlReservas ctrlReservas = mapControladoresReserva.get(idCtrlReservas);
			ctrlReservas.seleccionarCliente(nickname);
			ctrlReservas.seleccionarPromocion(null);
			DTMinServicio dt = new DTMinServicio(idProveedor, idServicio);
			ctrlReservas.seleccionarServicio(dt);
			DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateInicio = sourceFormat.parse(fechaInicio);
			Date dateFin = sourceFormat.parse(fechaFin);
			ctrlReservas.ingresarLineaReserva(cantidad, dateInicio, dateFin);
			return ctrlReservas.mostrarReservaTemporal();

		} catch (ParseException ex) {
			Logger.getLogger(Publicador.class
					.getName()).log(Level.SEVERE, null, ex);

			return null;
		}
	}

	@WebMethod
	public DTReserva agregarPromocionCarrito(
			@WebParam(name = "id_ctrl_reservas") int idCtrlReservas,
			@WebParam(name = "nickname") String nickname,
			@WebParam(name = "id_promocion") String idPromocion,
			@WebParam(name = "id_proveedor") String idProveedor,
			@WebParam(name = "cantidad") int cantidad,
			@WebParam(name = "fecha_inicio") String fechaInicio,
			@WebParam(name = "fecha_fin") String fechaFin
	) {
		//devuelve reserva temporal
		try {
			ICtrlReservas ctrlReservas = mapControladoresReserva.get(idCtrlReservas);
			ctrlReservas.seleccionarCliente(nickname);
			ctrlReservas.seleccionarServicio(null);
			DTMinPromocion dt = new DTMinPromocion(idProveedor, idPromocion);
			ctrlReservas.seleccionarPromocion(dt);
			DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateInicio = sourceFormat.parse(fechaInicio);
			Date dateFin = sourceFormat.parse(fechaFin);
			ctrlReservas.ingresarLineaReserva(cantidad, dateInicio, dateFin);
			return ctrlReservas.mostrarReservaTemporal();

		} catch (ParseException ex) {
			Logger.getLogger(Publicador.class
					.getName()).log(Level.SEVERE, null, ex);

			return null;
		}
	}

	@WebMethod
	public <T> String toString(
			@WebParam(name = "objeto_generico") T o) {
		return o.toString();
	}

	@WebMethod
	public boolean verificarCliente(String idCliente, String contrasena) {

		Fabrica f = Fabrica.getInstance();
		ICtrlUsuarios ctrlU = f.getICtrlUsuarios();
		return ctrlU.idCorrecta(idCliente) && ctrlU.pwCorrecta(idCliente, contrasena);

	}

	@WebMethod
	public boolean verificarProveedor(String idProveedor, String contrasena) {

		Fabrica f = Fabrica.getInstance();
		ICtrlUsuarios ctrlU = f.getICtrlUsuarios();
		return ctrlU.idCorrectaProveedor(idProveedor) && ctrlU.pwCorrectaProveedor(idProveedor, contrasena);

	}

}
