package tprog.logica.clases;

import java.util.Date;
import tprog.logica.dt.DTLineaReserva;

public class LineaReserva {

	private int Cantidad;
	private Date FechaInicio;
	private Date FechaFin;
	private float Precio;

	private Servicio servicio;
	private Promocion promocion;

	public LineaReserva(int cantidad, Date fInicio, Date fFin, Servicio Servicio, Promocion Promocion, float precio) {
		this.Cantidad = cantidad;
		this.FechaInicio = fInicio;
		this.FechaFin = fFin;
		this.servicio = Servicio;
		this.promocion = Promocion;
		this.Precio = precio;
	}

	public int getCantidad() {
		return this.Cantidad;
	}

	public Date getFechaInicio() {
		return this.FechaInicio;
	}

	public Date getFechaFin() {
		return this.FechaFin;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public Promocion getPromocion() {
		return this.promocion;
	}

	public float getPrecio() {
		return this.Precio;
	}

	public void setCantidad(int cantidad) {
		this.Cantidad = cantidad;
	}

	public void setFechaInicio(Date finicio) {
		this.FechaInicio = finicio;
	}

	public void setFechaFin(Date ffin) {
		this.FechaFin = ffin;
	}

	public void setServicio(Servicio service) {
		this.servicio = service;
	}

	public void setPromocion(Promocion promo) {
		this.promocion = promo;
	}

	public DTLineaReserva crearDT() {
		DTLineaReserva dtL = null;
		if ((this.servicio == null) && (this.promocion != null)) {
			dtL = new DTLineaReserva(this.Cantidad, this.FechaInicio, this.FechaFin, null, this.promocion.getIdPromocion(), this.promocion.getNicknameProveedor(), this.Precio);
		} else if ((this.servicio != null) && (this.promocion == null)) {
			dtL = new DTLineaReserva(this.Cantidad, this.FechaInicio, this.FechaFin, this.servicio.getIdServicio(), null, this.servicio.getNicknameProveedor(), this.Precio);
		}
		return dtL;
	}

}
