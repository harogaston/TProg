package tprog.logica.clases;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import tprog.logica.dt.DTLineaReserva;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.EstadoReserva;
import tprog.logica.manejadores.ManejadorProductos;

public class Reserva {

	private int idReserva;
	private Cliente cliente;
	private static int contador = 1;
	private Date fCreacion;
	private EstadoReserva estado;
	private float precioTotal;
	private Set<LineaReserva> lineasReserva;

	public Reserva(Cliente client, DTReserva dtR) throws Exception {
		this.idReserva = Reserva.contador;
		Reserva.contador++;
		this.cliente = client;
		this.fCreacion = dtR.getFCreacion();
		this.estado = dtR.getEstadoReserva();
		this.lineasReserva = new HashSet();
		this.precioTotal = dtR.getPrecioTotal();

		// Creo y agrego las lineasReserva
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		LineaReserva linea; // debe declararse fuera de los if
		for (DTLineaReserva dtLinea : dtR.getLineasReserva()) {
			if (dtLinea.getServicio() != null) {
				DTMinServicio dtMinS = new DTMinServicio(dtLinea.getNicknameProveedor(), dtLinea.getServicio());
				Servicio servicio = manejadorP.getServicio(dtMinS);
				linea = new LineaReserva(dtLinea.getCantidad(), dtLinea.getFechaInicio(), dtLinea.getFechaFin(), servicio, null, dtLinea.getPrecio());
			} else if (dtLinea.getPromocion() != null) {
				DTMinPromocion dtMinP = new DTMinPromocion(dtLinea.getNicknameProveedor(), dtLinea.getPromocion());
				Promocion promo = manejadorP.getPromocion(dtMinP);
				linea = new LineaReserva(dtLinea.getCantidad(), dtLinea.getFechaInicio(), dtLinea.getFechaFin(), null, promo, dtLinea.getPrecio());
			} else {
				throw new Exception("DTLineaReserva sin Servicio o Promocion especificado");
			}
			lineasReserva.add(linea);
		}
	}

	public int getIdReserva() {
		return idReserva;
	}

	public Date getFCreacion() {
		return fCreacion;
	}

	public EstadoReserva getEstado() {
		return estado;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void agregarLineaReserva(LineaReserva linea) {
		lineasReserva.add(linea);
		precioTotal += linea.getPrecio() * linea.getCantidad();
	}

	public void setEstadoReserva(EstadoReserva est) {
		this.estado = est;
	}

	public void setPrecioTotal(float precio) {
		this.precioTotal = precio;
	}

	public DTReserva crearDT() {
		Set<DTLineaReserva> dtsLR = new HashSet();

		Iterator<LineaReserva> iterador = lineasReserva.iterator();
		while (iterador.hasNext()) {
			LineaReserva linea = iterador.next();
			DTLineaReserva temp = linea.crearDT();
			dtsLR.add(temp);
			System.out.println("Linea de reserva");
		}
		DTReserva dtR = new DTReserva(this.idReserva, this.fCreacion, this.estado,
				this.precioTotal, dtsLR);
		return dtR;
	}

	public DTMinReserva crearDTMin() {
		DTMinReserva dtMinR = new DTMinReserva(this.idReserva, this.fCreacion);
		return dtMinR;
	}

	public boolean cambiarEstadoReserva(EstadoReserva nuevoEstado) {
		if (nuevoEstado != null) {
			switch (this.estado) {
				case Registrada: {
					if (nuevoEstado == EstadoReserva.Cancelada || nuevoEstado == EstadoReserva.Pagada) {
						setEstadoReserva(nuevoEstado);
						return true;
					}
					return false;
				}
				case Pagada: {
					if (nuevoEstado == EstadoReserva.Facturada) {
						setEstadoReserva(nuevoEstado);
						return true;
					}
					return false;
				}
			}
		}
		return false;
	}

	public void eliminar() {
		this.lineasReserva.clear();
		this.lineasReserva = null;
	}

	public Set<LineaReserva> getLineasReserva() {
		return this.lineasReserva;
	}
}
