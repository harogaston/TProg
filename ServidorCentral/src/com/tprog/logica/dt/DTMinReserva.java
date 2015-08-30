/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

import java.util.Date;

public class DTMinReserva {

	private int idReserva;
	private Date fechaCreacion;

	public DTMinReserva(int idReserva, Date fechaCreacion) {
		this.idReserva = idReserva;
		this.fechaCreacion = fechaCreacion;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}
}
