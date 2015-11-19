package tprog.logica.clases;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinProveedor;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.EstadoReserva;
import tprog.logica.interfaces.Observer;

public class Proveedor extends Usuario implements Observer {

	private String empresa;
	private String webEmpresa;

	private Map<String, Promocion> promociones;
	private Map<String, Servicio> servicios;
	private Map<Integer, Reserva> reservas;
	//para cada reserva, se mantiene un estado local al proveedor
	private Map<Integer, EstadoReserva> estadosParciales;
	private Set<String> notificaciones;

	public Proveedor(DTProveedor dtP) {
		super(dtP.getNickname(), dtP.getPassword(), dtP.getNombre(), dtP.getApellido(), dtP.getEmail(), dtP.getImagen(), dtP.getFechaNacimiento());
		this.empresa = dtP.getEmpresa();
		this.webEmpresa = dtP.getWebEmpresa();
		this.promociones = new HashMap();
		this.servicios = new HashMap();
		this.reservas = new HashMap();
		this.estadosParciales = new HashMap();
		this.notificaciones = new HashSet();
	}

	public DTMinProveedor crearDTMin() {
		DTMinProveedor nuevoDT = new DTMinProveedor(this.getNickname(), this.getEmail(), this.getEmpresa());
		return nuevoDT;
	}

	public DTProveedor crearDT() {
		DTProveedor nuevoDT = new DTProveedor(this.getNickname(), this.getPassword(), this.getNombre(), this.getApellido(),
				this.getEmail(), this.getImagen(), this.getFechaNacimiento(), this.getEmpresa(), this.getWebEmpresa());
		return nuevoDT;
	}

	public Set<DTMinServicio> listarServicios() {
		Set<DTMinServicio> nuevoSet = new HashSet();
		for (Servicio serv : servicios.values()) {
			DTMinServicio temp = serv.crearDTMin();
			nuevoSet.add(temp);
		}
		return nuevoSet;
	}

	public Set<DTMinPromocion> listarPromociones() {
		Set<DTMinPromocion> nuevoSet = new HashSet();
		for (Promocion promo : promociones.values()) {
			DTMinPromocion temp = promo.crearDTMin();
			nuevoSet.add(temp);
		}
		return nuevoSet;
	}

	/**
	 * Devuelve un conjunto de DTReserva considerando el estado parcial de la
	 * reserva por sobre el estado real
	 *
	 * @return
	 */
	public Set<DTReserva> listarReservasParciales() {
		//devuelve reservas considerando el estado parcial de la reserva
		//por sobre el estado real
		Set<DTReserva> nuevoSet = new HashSet();
		for (Reserva reserva : reservas.values()) {
			DTReserva temp = reserva.crearDT();
			//asigno el estado que ve localmente el proveedor
			//SOLO SI ES FACTURADA
			if (estadosParciales.get(reserva.getIdReserva()) == EstadoReserva.Facturada) {
				temp.setEstadoReserva(estadosParciales.get(reserva.getIdReserva()));
			}
			nuevoSet.add(temp);
		}
		return nuevoSet;
	}

	/**
	 * Modifica el estado de una reserva, en principio desde el punto de vista
	 * del proveedor. Si todos los proveedores asociados a una reserva modifican
	 * su estado parcial a Facturada, entonces el estado global de la reserva
	 * cambiará a Facturada.
	 *
	 * @param idReserva
	 * @param nuevoEstado
	 */
	public boolean facturarReserva(int idReserva) {
		estadosParciales.put(idReserva, EstadoReserva.Facturada);
		boolean facturaGlobal = reservas.get(idReserva).facturarReserva();
                return facturaGlobal;
	}

	public void addServicio(Servicio service) {
		servicios.put(service.getIdServicio(), service);
	}

	public void addPromocion(Promocion promo) {
		promociones.put(promo.getIdPromocion(), promo);
	}

	public void addReserva(Reserva reserva) {
		reservas.put(reserva.getIdReserva(), reserva);
		estadosParciales.put(reserva.getIdReserva(), reserva.getEstado());
		reserva.register(this);
	}

	public void setEmpresa(String Empresa) {
		this.empresa = Empresa;
	}

	public void setWebEmpresa(String WebEmpresa) {
		this.webEmpresa = WebEmpresa;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public String getWebEmpresa() {
		return this.webEmpresa;
	}

	public Map<String, Servicio> getServicios() {
		return this.servicios;
	}

	public Map<String, Promocion> getPromociones() {
		return this.promociones;
	}

	public Map<Integer, Reserva> getReservas() {
		return reservas;
	}

	public Map<Integer, EstadoReserva> getEstadosParciales() {
		return estadosParciales;
	}

	public Set<String> getNotificaciones() {
		return notificaciones;
	}

	@Override
	public void update(String message) {
		notificaciones.add(message);
		System.out.println("Notificacion agregada para " + getNickname() + ": " + message);
	}

	public void limpiarNotificaciones() {
		notificaciones.clear();
	}

}
