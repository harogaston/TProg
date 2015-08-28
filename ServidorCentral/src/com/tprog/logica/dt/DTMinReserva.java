/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

/**
 *
 * @author MarG
 */
import java.util.Date;
public class DTMinReserva {
    private String idReserva;
    private Date creacion;
    
    public DTMinReserva(String id, Date crea){
        this.idReserva = id;
        this.creacion = crea;
    }
    
    public String getIdReserva(){
        return idReserva;
    }
    
    public Date getFCreacion(){
        return creacion;
    }
}
