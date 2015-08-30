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
public class DTMinServicio {
    
    private final String nicknameP;
    private final String idServicio;
    
    public DTMinServicio(String proveedor, String idServicio) {
        this.nicknameP = proveedor;
        this.idServicio = idServicio;
    }
    
    public String getNicknameP(){
        return this.nicknameP;
    }
    
    public String getIdServicio(){
        return this.idServicio;
    }
    
}