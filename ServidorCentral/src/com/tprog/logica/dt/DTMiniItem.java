/*
 * Header Test
 */
package com.tprog.logica.dt;

/**
 *
 * @author sofia
 */
public class DTMiniItem {
    private DTMinServicio servicio;
    private int cantidad;
    
    public DTMiniItem(DTMinServicio servicio, int cantidad){
        this.servicio = servicio;
        this.cantidad = cantidad;
    }
    
    public DTMinServicio getDTMinServicio(){
        return servicio;
    }
    
    public int getCantidad(){
        return cantidad;
    }
}