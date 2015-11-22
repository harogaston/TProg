package tprog.logica.clases;

import java.util.Date;
import tprog.logica.dt.DTLineaReserva;

public class LineaReserva {
        
    private int idLineaReserva;
    public static int contador = 1;
	private int cantidad;
	private Date fechaInicio;
	private Date fechaFin;
	private float precio;

	private Servicio servicio;
	private Promocion promocion;

	public LineaReserva(int Cantidad, Date FInicio, Date FFin, Servicio Servicio
            , Promocion Promocion, float Precio) {
                this.idLineaReserva = contador;
                contador++;
		this.cantidad = Cantidad;
		this.fechaInicio = FInicio;
		this.fechaFin = FFin;
		this.servicio = Servicio;
		this.promocion = Promocion;
		this.precio = Precio;
	}
        
        public int getidLineaReserva(){
            return this.idLineaReserva;
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

	public Servicio getServicio() {
		return this.servicio;
	}

	public Promocion getPromocion() {
		return this.promocion;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setCantidad(int Cantidad) {
		this.cantidad = Cantidad;
	}

	public void setFechaInicio(Date Finicio) {
		this.fechaInicio = Finicio;
	}

	public void setFechaFin(Date Ffin) {
		this.fechaFin = Ffin;
	}

	public void setServicio(Servicio Service) {
		this.servicio = Service;
	}

	public void setPromocion(Promocion promo) {
		this.promocion = promo;
	}

	public DTLineaReserva crearDT() {
		DTLineaReserva dtL = null;
		if ((this.servicio == null) && (this.promocion != null)) {
                    dtL = new DTLineaReserva(this.getCantidad(), this.getFechaInicio(),
                    this.getFechaFin(), null,
                    this.getPromocion().getIdPromocion(), 
                    this.getPromocion().getNicknameProveedor(), 
                    this.getPrecio());
		} else if ((this.servicio != null) && (this.promocion == null)) {
                    dtL = new DTLineaReserva(this.getCantidad(), this.getFechaInicio(), 
                    this.getFechaFin(), this.getServicio().getIdServicio(), 
                    null, this.getServicio().getNicknameProveedor(), 
                    this.getPrecio());
		}
		return dtL;
	}

}
