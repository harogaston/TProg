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
		ManejadorProductos mp = ManejadorProductos.getInstance();
		LineaReserva linea; // debe declararse fuera de los if
		for (DTLineaReserva dtLinea : dtR.getLineasReserva()) {
			if (dtLinea.getServicio() != null) {
				DTMinServicio dtMinS = new DTMinServicio(dtLinea.getNicknameProveedor(), dtLinea.getServicio());
				Servicio s = mp.getServicio(dtMinS);
				linea = new LineaReserva(dtLinea.getCantidad(), dtLinea.getFechaInicio(), dtLinea.getFechaFin(), s, null, dtLinea.getPrecio());
			} else if (dtLinea.getPromocion() != null) {
				DTMinPromocion dtMinP = new DTMinPromocion(dtLinea.getNicknameProveedor(), dtLinea.getPromocion());
				Promocion p = mp.getPromocion(dtMinP);
				linea = new LineaReserva(dtLinea.getCantidad(), dtLinea.getFechaInicio(), dtLinea.getFechaFin(), null, p, dtLinea.getPrecio());
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

	public void setPrecioTotal(float p) {
		this.precioTotal = p;
	}

	public DTReserva crearDT() {
		Set<DTLineaReserva> dtsLR = new HashSet();

		Iterator<LineaReserva> it = lineasReserva.iterator();
		while (it.hasNext()) {
			LineaReserva l = it.next();
			DTLineaReserva temp = l.crearDT();
			dtsLR.add(temp);
			System.out.println("Linea de reserva");
		}
		DTReserva dt = new DTReserva(this.idReserva, this.fCreacion, this.estado,
				this.precioTotal, dtsLR);
		return dt;
	}

	public DTMinReserva crearDTMin() {
		DTMinReserva dt = new DTMinReserva(this.idReserva, this.fCreacion);
		return dt;
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
