package tprog.logica.dt;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTLineaReserva {

	private int cantidad;
	private Date fechaInicio;
	private Date fechaFin;
	private String servicio;
	private String promocion;
	private String nicknameProveedor;
	private float precio;

	public DTLineaReserva(int Cantidad, Date FechaInicio, Date FechaFin, String Servicio, String Promocion, String NicknameProveedor, float Precio) {
		this.cantidad = Cantidad;
		this.fechaInicio = FechaInicio;
		this.fechaFin = FechaFin;
		this.servicio = Servicio;
		this.promocion = Promocion;
		this.nicknameProveedor = NicknameProveedor;
		this.precio = Precio;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public String getServicio() {
		return this.servicio;
	}

	public String getPromocion() {
		return this.promocion;
	}

	public float getPrecio() {
		return this.precio;
	}

	public String getNicknameProveedor() {
		return this.nicknameProveedor;
	}

	@Override
	public String toString() {
		if (promocion == null) {
			return "Cantidad: " + Integer.toString(cantidad)
					+ "\n" + "Fecha de inicio: "
					+ Integer.toString(fechaInicio.getDate()) + "-"
					+ Integer.toString(fechaInicio.getMonth() + 1) + "-"
					+ Integer.toString(fechaInicio.getYear())
					+ "\n" + "Fecha de fin: "
					+ Integer.toString(fechaFin.getDate()) + "-"
					+ Integer.toString(fechaFin.getMonth() + 1) + "-"
					+ Integer.toString(fechaFin.getYear())
					+ "\n" + "Servicio: " + servicio
					+ "\n" + "Precio: " + Float.toString(precio) + "\n";
		} else {
			return "Cantidad: " + Integer.toString(cantidad)
					+ "\n" + "Fecha de inicio: "
					+ Integer.toString(fechaInicio.getDate()) + "-"
					+ Integer.toString(fechaInicio.getMonth() + 1) + "-"
					+ Integer.toString(fechaInicio.getYear())
					+ "\n" + "Fecha de fin: "
					+ Integer.toString(fechaFin.getDate()) + "-"
					+ Integer.toString(fechaFin.getMonth() + 1) + "-"
					+ Integer.toString(fechaFin.getYear())
					+ "\n" + "Promocion: " + promocion
					+ "\n" + "Precio: " + Float.toString(precio) + "\n";
		}
	}
}
