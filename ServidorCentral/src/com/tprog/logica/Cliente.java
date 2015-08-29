/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica;

/**
 *
 * @author Martins
 */
import com.tprog.logica.dt.DTCliente;
import com.tprog.logica.dt.DTMinCliente;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class Cliente extends Usuario {
    Map<String, Reserva> reservas;
    
    public Cliente(String nickname, String nombre, String apellido, String email, String imagen, Date fechaN){
            super(nickname, nombre, apellido, email, imagen, fechaN);
		this.reservas = new HashMap();
	}
            
    public DTCliente crearDTCliente(){
        DTCliente dt = new DTCliente(this.nickname, this.nombre, this.apellido, this.email, 
				this.imagen, this.fechaNacimiento);
        return dt;
    }
    
    public DTMinCliente crearDTMin(){
        DTMinCliente dt = new DTMinCliente(this.nickname, this.email);
        return dt;
    }
}
