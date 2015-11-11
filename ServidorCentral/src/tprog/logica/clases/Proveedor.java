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
import tprog.logica.interfaces.Subject;

public class Proveedor extends Usuario implements Observer {

	private String empresa;
	private String webEmpresa;

	private Map<String, Promocion> promociones;
	private Map<String, Servicio> servicios;
	private Map<Integer, Reserva> reservas;
	//para cada reserva, se mantiene un estado local al proveedor
	private Map<Integer, EstadoReserva> estadosParciales;

	public Proveedor(DTProveedor dtP) {
		super(dtP.getNickname(), dtP.getPassword(), dtP.getNombre(), dtP.getApellido(), dtP.getEmail(), dtP.getImagen(), dtP.getFechaNacimiento());
		this.empresa = dtP.getEmpresa();
		this.webEmpresa = dtP.getWebEmpresa();
		this.promociones = new HashMap();
		this.servicios = new HashMap();
		this.reservas = new HashMap();
		this.estadosParciales = new HashMap();
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
			temp.setEstadoReserva(estadosParciales.get(reserva.getIdReserva()));
			nuevoSet.add(temp);
		}
		return nuevoSet;
	}

	/**
	 * Modifica el estado de una reserva a ojos de un proveedor. Para usarse a
	 * la hora de facturar una reserva localmente.
	 *
	 * @param idReserva
	 * @param nuevoEstado
	 */
	public void modificarEstadoParcial(int idReserva, EstadoReserva nuevoEstado) {
		estadosParciales.put(idReserva, nuevoEstado);
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

	@Override
	public void update() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void setSubject(Subject sub) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
