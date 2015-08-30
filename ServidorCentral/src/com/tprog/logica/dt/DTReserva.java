/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;
import com.tprog.logica.clases.LineaReserva;

public class DTReserva {

	private String idReserva;
	private Date fCreacion;
	private EstadoReserva estado;
	private float precioTotal;
	Set<DTLineaReserva> lineasReserva;

	public DTReserva(String idReserva, Date fCreacion, EstadoReserva estado, float precioTotal, Set<LineaReserva> lineasReserva) {
		this.idReserva = idReserva;
		this.fCreacion = fCreacion;
		this.estado = estado;
		this.precioTotal = precioTotal;
		this.lineasReserva = new HashSet();

		Iterator<LineaReserva> it = lineasReserva.iterator();
		while (it.hasNext()) {
			LineaReserva l = it.next();
			DTLineaReserva temp = l.crearDTLineaReserva();
			this.lineasReserva.add(temp);
		}
	}

	public String getIdReserva() {
		return idReserva;
	}

	public Date getFCreacion() {
		return fCreacion;
	}

	public EstadoReserva getEstadoReserva() {
		return estado;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public Set<DTLineaReserva> getLineasReserva() {
		return this.lineasReserva;
	}
}
