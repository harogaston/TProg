/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.clases;

import com.tprog.logica.dt.DTCliente;
import com.tprog.logica.dt.DTMinCliente;
import com.tprog.logica.dt.DTMinReserva;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cliente extends Usuario {

	Map<Integer, Reserva> reservas;

	public Cliente(String nickname, String nombre, String apellido, String email, String imagen, Date fechaN) {
            super(nickname, nombre, apellido, email, imagen, fechaN);
            this.reservas = new HashMap();
	}

	public Cliente(DTCliente dtC) {
            super(dtC.getNickname(), dtC.getNombre(), dtC.getApellido(), dtC.getEmail(), dtC.getImagen(), dtC.getFechaNacimiento());
            this.reservas = new HashMap();
	}

	public DTCliente crearDT() {
            Set<DTMinReserva> nuevoSetReservas = new HashSet();
            for (Reserva r : reservas.values()) {
                    nuevoSetReservas.add(r.crearDTMinReserva());
            }
            DTCliente dt = new DTCliente(this.nickname, this.nombre, this.apellido, this.email,
                            this.imagen, this.fechaNacimiento, nuevoSetReservas);
            return dt;
	}

	public DTMinCliente crearDTMin() {
		return new DTMinCliente(this.nickname, this.email);
	}

	public void agregarReserva(Reserva reserva) {
		reservas.put(reserva.getIdReserva(), reserva);
	}
}
