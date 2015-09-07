/*
 * Header Test
 */
package com.tprog.logica.dt;

/**
 *
 * @author sofia
 */
public class DTMiniItem {
    private String idServicio;
    private int cantidad;
    
    public DTMiniItem(String idServicio, int cantidad){
        this.idServicio = idServicio;
        this.cantidad = cantidad;
    }
    
    public String getIdServicio(){
        return idServicio;
    }
    
    public int getCantidad(){
        return cantidad;
    }
}
