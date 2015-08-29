/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

import java.util.Date;

/**
 *
 * @author Martins
 */
public class DTCliente extends DTUsuario {
    
    public DTCliente(String nickname, String nombre, String apellido, String email, 
			String imagen, Date fechaN){
        super(nickname, nombre, apellido, email, imagen, fechaN);
    }
    
}
