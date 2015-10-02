package tprog.logica.dt;

import java.util.Date;
import java.util.Set;

public class DTReserva implements Comparable<DTReserva> {

	private int idReserva;
	private Date fCreacion;
	private EstadoReserva estado;
	private float precioTotal;
	Set<DTLineaReserva> lineasReserva;

	public DTReserva(int idReserva, Date fCreacion, EstadoReserva estado, float precioTotal, Set<DTLineaReserva> lineasReserva) {
		this.idReserva = idReserva;
		this.fCreacion = fCreacion;
		this.estado = estado;
		this.precioTotal = precioTotal;
		this.lineasReserva = lineasReserva;
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
			int i = 1;
			for (DTLineaReserva dt : lineasReserva) {
				if (dt != null) {
					output = output.concat("Linea " + Integer.toString(i) + "\n" + "\n");
					output = output.concat(dt.toString() + "\n");
					i++;
				}
			}
		}
		return output;
	}

	@Override
	public int compareTo(DTReserva o) {
		if (this.idReserva == o.getIdReserva()) {
			return (this.fCreacion.toString().compareToIgnoreCase(o.getFCreacion().toString()));
		} else {
			return idReserva - o.getIdReserva();
		}
	}

}
