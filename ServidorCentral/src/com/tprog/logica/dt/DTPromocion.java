/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

import java.util.Set;

public class DTPromocion {

	private String idPromocion;
	private float descuento;
	private float total;
	private Set<DTMinServicio> servicios;

	public DTPromocion(String idPromocion, float descuento, float total, Set<DTMinServicio> servicios) {
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

	public Set<DTMinServicio> getServicios() {
		return this.servicios;
	}

    @Override
    public String toString() {
        String output = "ID de promocion: " + idPromocion
                + "\n" + "Descuento: " + Float.toString(descuento)
                + "\n" + "Total: " + Float.toString(total)
                + "\n" + "Servicios: " + "\n";
        int i = 1;
        for (DTMinServicio dt : servicios) {
            output.concat("Servicio " + Integer.toString(i) + ": ");
            output.concat(dt.toString());
        }
        return output;
    }
        
        

}
