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
    Map<String, Reserva> reservas = new HashMap<String, Reserva>(); // habilitar al haber reserva
    
    public Cliente(String nick, String nom, String ap, String email,String imagen, Date fecha){
            super(nick,nom,ap,email,imagen,fecha);
    }
            
    public DTCliente crearDTCliente(){
        DTCliente dt = new DTCliente(getNickname(),getNombre(),getApellido(),getEmail(),getImagen(),
        getFechaNacimiento());
        
        return dt;
    }
    
    public DTMinCliente crearDTMin(){
        DTMinCliente dt = new DTMinCliente(getNickname(),getEmail());
        return dt;
    }
}
