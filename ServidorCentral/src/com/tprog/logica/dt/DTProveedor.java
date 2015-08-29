/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;
import java.util.*;
/**
 *
 * @author sofia
 */
public class DTProveedor extends DTUsuario {
    private final String empresa;
    private final String webEmpresa;
    
    public DTProveedor(String nickname, String nombre, String apellido, String email,
			String imagen, Date fechaN, String empresa, String webEmpresa){
        super(nickname, nombre, apellido, email, imagen, fechaN);
        this.empresa = empresa;
        this.webEmpresa = webEmpresa;
    }
    
    String getEmpresa(){
        return this.empresa;
    }
    
    String getWeb(){
        return this.webEmpresa;
    }
    
}
