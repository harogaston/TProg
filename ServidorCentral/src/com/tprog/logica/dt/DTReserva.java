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

	private int idReserva;
	private Date fCreacion;
	private EstadoReserva estado;
	private float precioTotal;
	Set<DTLineaReserva> lineasReserva;

	public DTReserva(int idReserva, Date fCreacion, EstadoReserva estado, float precioTotal, Set<DTLineaReserva> lineasReserva) {
		this.idReserva = idReserva;
		this.fCreacion = fCreacion;
		this.estado = estado;
		this.precioTotal = precioTotal;
		this.lineasReserva = lineasReserva;
        }

	public int getIdReserva() {
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
