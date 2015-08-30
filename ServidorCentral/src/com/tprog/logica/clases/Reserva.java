/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.clases;

import com.tprog.logica.dt.DTLineaReserva;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.EstadoReserva;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Reserva {

	private int idReserva;
	private static int contador;
	private Date fcreacion;
	private EstadoReserva estado;
	private float precioTotal;
	Set<LineaReserva> lineasReserva;

	public Reserva(Date creacion, EstadoReserva estado, float p) {
		this.idReserva = Reserva.contador;
		Reserva.contador++;
		this.fcreacion = creacion;
		this.estado = estado;
		this.precioTotal = p;
		this.lineasReserva = new HashSet();
	}

	public int getIdReserva() {
		return idReserva;
	}

	public Date getFCreacion() {
		return fcreacion;
	}

	public EstadoReserva getEstadoReserva() {
		return estado;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void agregarLineaReserva(LineaReserva linea) {
		lineasReserva.add(linea);
		float p = linea.getPrecio();
		p = p + this.getPrecioTotal();
		setPrecioTotal(p);
	}

	public void setEstadoReserva(EstadoReserva est) {
		this.estado = est;
	}

	public void setPrecioTotal(float p) {
		this.precioTotal = p;
	}

	public DTReserva crearDTReserva() {
		Set<DTLineaReserva> dtsLR = new HashSet();

		Iterator<LineaReserva> it = lineasReserva.iterator();
		while (it.hasNext()) {
			LineaReserva l = it.next();
			DTLineaReserva temp = l.crearDTLineaReserva();
			dtsLR.add(temp);
		}
		DTReserva dt = new DTReserva(this.idReserva, this.fcreacion, this.estado,
				this.precioTotal, dtsLR);
		return dt;
	}

	public DTMinReserva crearDTMinReserva() {
		DTMinReserva dt = new DTMinReserva(this.idReserva, this.fcreacion);
		return dt;
	}

	public boolean cambiarEstadoReserva(EstadoReserva nuevoEstado) {
		if (("Registrada".equals(this.getEstadoReserva().toString()))
				&& (!"Facturada".equals(nuevoEstado.toString()))) {
			setEstadoReserva(nuevoEstado);
			return true;
		} else {
			return false;
		}
	}

	public void eliminar() {
		this.lineasReserva.clear();

	}
}
