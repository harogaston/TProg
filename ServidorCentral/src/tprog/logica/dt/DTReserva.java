package tprog.logica.dt;

import java.util.Date;
import java.util.Set;

public class DTReserva implements Comparable<DTReserva> {

	private int idReserva;
	private Date fCreacion;
	private EstadoReserva estado;
	private float precioTotal;
	Set<DTLineaReserva> lineasReserva;

	public DTReserva(int IdReserva, Date FCreacion, EstadoReserva Estado, float PrecioTotal, Set<DTLineaReserva> LineasReserva) {
		this.idReserva = IdReserva;
		this.fCreacion = FCreacion;
		this.estado = Estado;
		this.precioTotal = PrecioTotal;
		this.lineasReserva = LineasReserva;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public Date getFCreacion() {
		return fCreacion;
	}

	public EstadoReserva getEstadoReserva() {
		return estado;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public Set<DTLineaReserva> getLineasReserva() {
		return this.lineasReserva;
	}

	@Override
	public String toString() {
		String output = "ID de reserva: " + Integer.toString(idReserva)
				+ "\n" + "Fecha de creacion: "
				+ Integer.toString(fCreacion.getDate()) + "-"
				+ Integer.toString(fCreacion.getMonth() + 1) + "-"
				+ Integer.toString(fCreacion.getYear()) + "\n"
				+ "\n" + "Estado: " + estado.toString()
				+ "\n" + "Precio total: " + Float.toString(precioTotal)
				+ "\n" + "\n";
		if (!lineasReserva.isEmpty()) {
			output = output.concat("Lineas de reserva: " + "\n" + "\n");
			int iterador = 1;
			for (DTLineaReserva dtL : lineasReserva) {
				if (dtL != null) {
					output = output.concat("Linea " + Integer.toString(iterador) + "\n" + "\n");
					output = output.concat(dtL.toString() + "\n");
					iterador++;
				}
			}
		}
		return output;
	}

	@Override
	public int compareTo(DTReserva object) {
		if (this.idReserva == object.getIdReserva()) {
			return (this.fCreacion.toString().compareToIgnoreCase(object.getFCreacion().toString()));
		} else {
			return idReserva - object.getIdReserva();
		}
	}

}
