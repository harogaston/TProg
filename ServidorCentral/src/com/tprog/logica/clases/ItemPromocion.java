/*
 * Header Test
 */
package com.tprog.logica.clases;

/**
 *
 * @author gianc_000
 */
public class ItemPromocion {
    protected Servicio servicio;
    protected int cantidad;
    
    public ItemPromocion(Servicio servicio){
        servicio = servicio;
        cantidad = 1;
    }
    
    public void addServicio(){
        cantidad++;
    }
    
    public Servicio getServicio(){
        return servicio;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
}
