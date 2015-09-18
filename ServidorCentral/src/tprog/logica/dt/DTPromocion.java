/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.dt;

import tprog.logica.clases.ItemPromocion;
import java.util.Set;

public class DTPromocion {

	private String idPromocion;
	private float descuento;
	private float total;
	private Set<DTItemPromocion> servicios;

	public DTPromocion(String idPromocion, float descuento, float total, Set<DTItemPromocion> servicios) {
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

	public Set<DTItemPromocion> getServicios() {
		return this.servicios;
	}

	@Override
	public String toString() {
		String output = "ID de promocion: " + idPromocion
				+ "\n" + "Descuento: " + Float.toString(descuento)
				+ "\n" + "Total: " + Float.toString(this.total)
				+ "\n" + "Servicios: " + "\n";
		int i = 1;
		for (DTItemPromocion dt : servicios) {
			output = output.concat("Servicio" + Integer.toString(i) + ": ");
			output = output.concat(dt.getDTMinServicio().getIdServicio()) + " cantidad: " +
                                Integer.toString(dt.getCantidad()) + "\n";
			i++;
		}
		return output;
	}

}
