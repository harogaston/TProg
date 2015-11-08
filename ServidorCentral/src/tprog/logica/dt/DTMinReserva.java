package tprog.logica.dt;

import java.util.Date;

public class DTMinReserva {

	private int idReserva;
	private Date fechaCreacion;

	public DTMinReserva(int IdReserva, Date FechaCreacion) {
		this.idReserva = IdReserva;
		this.fechaCreacion = FechaCreacion;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	@Override
	public String toString() {
		return "ID de reserva: " + Integer.toString(idReserva)
				+ "\n" + "Fecha de creacion: "
				+ Integer.toString(fechaCreacion.getDate()) + "-"
				+ Integer.toString(fechaCreacion.getMonth() + 1) + "-"
				+ Integer.toString(fechaCreacion.getYear() + 1900) + "\n";
	}

	@Override
	public boolean equals(Object objeto) {
		DTMinReserva dtMinR = (DTMinReserva) objeto;
		return (this.idReserva == dtMinR.idReserva) && this.fechaCreacion.equals(dtMinR.fechaCreacion);
	}

}
