package tprog.logica.dt;

import java.util.Map;

public class DTPromocion implements Comparable<DTPromocion> {

	private String idPromocion;
	private String nicknameProveedor;
	private float descuento;
	private float total;
	private Map<DTMinServicio, Integer> servicios;

	public DTPromocion(String IdPromocion, String NicknameP, float Descuento, float Total, Map<DTMinServicio, Integer> Servicios) {
		this.idPromocion = IdPromocion;
		this.nicknameProveedor = NicknameP;
		this.descuento = Descuento;
		this.total = Total;
		this.servicios = Servicios;
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

	public Map<DTMinServicio, Integer> getServicios() {
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
	public int compareTo(DTPromocion object) {
		if (this.idPromocion.equals(object.getIdPromocion())) {
			return this.nicknameProveedor.compareToIgnoreCase(object.getNicknameProveedor());
		} else {
			return this.idPromocion.compareToIgnoreCase(object.getIdPromocion());
		}
	}
	
	public int comparePrecio(DTPromocion object) {
		if (Float.compare(total, object.getTotal()) == 0) {
			return this.compareTo(object);
		} else {
			return Float.compare(total, object.getTotal());
		}
	}
}
