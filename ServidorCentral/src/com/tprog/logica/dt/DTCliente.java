/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import com.tprog.logica.dt.DTMinReserva;

public class DTCliente extends DTUsuario {

	private Set<DTMinReserva> reservas;
	
	public DTCliente(String nickname, String nombre, String apellido, String email,
			String imagen, Date fechaN, Set<DTMinReserva> reservas) {
		super(nickname, nombre, apellido, email, imagen, fechaN);
		this.reservas = reservas;
	}
	
	public DTCliente(DTUsuario dtU){
		super(dtU.nickname, dtU.nombre, dtU.apellido, dtU.email, dtU.imagen, dtU.fechaNacimiento);
		this.reservas = new HashSet();
	}
        
        public Set<DTMinReserva> getReservas(){
            return reservas;
        }
}
