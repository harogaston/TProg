package tprog.logica.clases;

import java.util.HashMap;
import java.util.Map;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.manejadores.ManejadorProductos;

public class Promocion {

	private String idPromocion;
	private float descuento;

	private Proveedor proveedor;
	private Map<String, Integer> servicios;

	public Promocion(String IdPromocion, float Descuento, Proveedor Proveedor) {
		this.idPromocion = IdPromocion;
		this.descuento = Descuento;
		this.proveedor = Proveedor;
		servicios = new HashMap<>();
	}

	public DTMinPromocion crearDTMin() {
		DTMinPromocion nuevoDT = new DTMinPromocion(this.proveedor.getNickname(), this.idPromocion);
		return nuevoDT;
	}

	public DTPromocion crearDT() {
		HashMap<DTMinServicio, Integer> nuevoSet = new HashMap<>();
		if (servicios != null) {
			for (String it : servicios.keySet()) {
				DTMinServicio dtS = new DTMinServicio(this.getNicknameProveedor(), it);
				nuevoSet.put(dtS, servicios.get(it));
			}
		}
		DTPromocion nuevoDT = new DTPromocion(this.idPromocion, this.getNicknameProveedor(), this.descuento, this.getTotal(), nuevoSet);
		return nuevoDT;
	}

	public void agregarServicio(Servicio s) {
		String idServicio = s.getIdServicio();

		// Si aún no tengo ese servicio, lo agrego con cantidad 1
		if (!servicios.containsKey(idServicio)) {
			servicios.put(idServicio, 1);
		} else {

			// Si ya se encuentra, lo busco y sumo 1 a su cantidad
			for (Map.Entry<String, Integer> par : servicios.entrySet()) {
				if (par.getKey().equals(idServicio)) {
					par.setValue(par.getValue() + 1);
				}
			}
		}
	}

	public void setIdPromocion(String IdPromocion) {
		this.idPromocion = IdPromocion;
	}

	public void setDescuento(float Descuento) {
		this.descuento = Descuento;
	}

	public void setProveedor(Proveedor Proveedor) {
		this.proveedor = Proveedor;
	}

	public String getIdPromocion() {
		return this.idPromocion;
	}

	public float getDescuento() {
		return this.descuento;
	}

	public float getTotal() {
		float result = 0;
		ManejadorProductos mp = ManejadorProductos.getInstance();

		for (Map.Entry<String, Integer> it : servicios.entrySet()) {
			float precioUnit = mp.getPrecioServicio(new DTMinServicio(proveedor.getNickname(), it.getKey()));
			float precioPromocional = (precioUnit * (100 - this.descuento)) / 100;
			result += precioPromocional * it.getValue();
		}
		return result;
	}

	public String getNicknameProveedor() {
		return this.proveedor.getNickname();
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public Map<String, Integer> getServicios() {
		return this.servicios;
	}
}
