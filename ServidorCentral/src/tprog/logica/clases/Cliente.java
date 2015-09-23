/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.clases;

import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTMinCliente;
import tprog.logica.dt.DTMinReserva;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cliente extends Usuario {

	Map<Integer, Reserva> reservas;

	public Cliente(String nickname, String password, String nombre, String apellido, String email, String imagen, Date fechaN) {
		super(nickname, password, nombre, apellido, email, imagen, fechaN);
		this.reservas = new HashMap();
	}

	public Cliente(DTCliente dtC) {
		super(dtC.getNickname(), dtC.getPassword(), dtC.getNombre(), dtC.getApellido(), dtC.getEmail(), dtC.getImagen(), dtC.getFechaNacimiento());
		this.reservas = new HashMap();
	}

	public DTCliente crearDT() {
		Set<DTMinReserva> nuevoSetReservas = new HashSet<>();
		for (Reserva r : reservas.values()) {
			nuevoSetReservas.add(r.crearDTMin());
		}
		DTCliente dt = new DTCliente(this.nickname, this.password, this.nombre, this.apellido, this.email,
				this.imagen, this.fechaNacimiento, nuevoSetReservas);
		return dt;
	}

	public DTMinCliente crearDTMin() {
		return new DTMinCliente(this.nickname, this.email);
	}

	public void agregarReserva(Reserva reserva) {
		reservas.put(reserva.getIdReserva(), reserva);
	}
	
	public void quitarReserva(int idReserva){
		reservas.remove(idReserva);
	}
	
	@Override
	public boolean equals(Object o) {
		Cliente c = (Cliente) o;
		return this.reservas.equals(c.reservas);
	}
}
