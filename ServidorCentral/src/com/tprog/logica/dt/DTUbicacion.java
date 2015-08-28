/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

/**
 *
 * @author sofia
 */
public class DTUbicacion {
    private final String ciudad;
    private final String pais;
    
    public DTUbicacion(String c, String p) {
        this.ciudad = c;
        this.pais = p;
    }
    
    public String getCiudad(){
        return this.ciudad;
    }
    
    public String getPais(){
        return this.pais;
    }
}
