package tprog.logica.dt;

import java.util.HashMap;
import java.util.Map;

public class DTPromocion implements Comparable<DTPromocion> {

	private String idPromocion;
	private String nicknameProveedor;
	private float descuento;
	private float total;
	private HashMap<DTMinServicio, Integer> servicios;

	public DTPromocion(String idPromocion, String nicknameP, float descuento, float total, HashMap<DTMinServicio, Integer> servicios) {
		this.idPromocion = idPromocion;
		this.nicknameProveedor = nicknameP;
		this.descuento = descuento;
		this.total = total;
		this.servicios = servicios;
	}

	public String getIdPromocion() {
		return this.idPromocion;
	}

	public String getNicknameProveedor() {
		return this.nicknameProveedor;
	}

	public float getDescuento() {
		return this.descuento;
	}

	public float getTotal() {
		return this.total;
	}

	public HashMap<DTMinServicio, Integer> getServicios() {
		return this.servicios;
	}

	@Override
	public String toString() {
		String output = "ID de promocion: " + idPromocion
				+ "\n" + "Descuento: " + Float.toString(descuento)
				+ "\n" + "Total: " + Float.toString(this.total)
				+ "\n" + "Servicios: " + "\n";
		for (Map.Entry<DTMinServicio, Integer> par : servicios.entrySet()) {
			output = output.concat("ID de servicio: " + par.getKey().getIdServicio() + "\n" + "Cantidad: "
					+ Integer.toString(par.getValue()) + "\n");
		}
		return output;
	}

	@Override
	public int compareTo(DTPromocion o) {
		if (this.idPromocion.equals(o.getIdPromocion())) {
			return (this.nicknameProveedor.compareToIgnoreCase(o.getNicknameProveedor()));
		} else {
			return (this.idPromocion.compareToIgnoreCase(o.getIdPromocion()));
		}
	}
	
	public int comparePrecio(DTPromocion o){
		if (Float.compare(total, o.getTotal()) == 0) {
			return this.compareTo(o);
		} else {
			return Float.compare(total, o.getTotal());
		}
	}
}
