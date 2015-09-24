/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.dt;

import java.util.HashMap;
import java.util.Map;

public class DTPromocion {

	private String idPromocion;
	private float descuento;
	private float total;
	private Map<DTMinServicio, Integer> servicios;

	public DTPromocion(String idPromocion, float descuento, float total, HashMap<DTMinServicio, Integer> servicios) {
		this.idPromocion = idPromocion;
		this.descuento = descuento;
		this.total = total;
		this.servicios = servicios;
	}

	public String getIdPromocion() {
		return this.idPromocion;
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
		int i = 1;
		for (Map.Entry<DTMinServicio, Integer> par : servicios.entrySet()) {
			output = output.concat(par.getKey().toString() + "Cantidad: "
				+ Integer.toString(par.getValue()) + "\n");
		}
		return output;
	}

}
