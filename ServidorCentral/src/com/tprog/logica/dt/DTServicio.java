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
public class DTServicio {
    
    private final String idServicio;
    private final String descripcion;
    private final float precio;
    private final String[] imagenes;
    private final DTUbicacion origen;
    private final DTUbicacion destino;
    
    public DTServicio(String prov, String id, String desc, float p,
            String[] img, DTUbicacion origen, DTUbicacion destino) {
        this.idServicio = id;
        this.descripcion = desc;
        this.precio = p;
        this.imagenes = img;
        this.origen = origen;
        this.destino = destino;
    }
   
    public String getIdServicio(){
        return this.idServicio;
    }
    
	public String getDescripcion(){
		return this.descripcion;
	}
	
    public float getPrecio(){
        return this.precio;
    }
    
    public String[] getImagenes(){
        return this.imagenes;
    }
    
    public DTUbicacion getOrigen(){
        return this.origen;
    }
    
    public DTUbicacion getDestino(){
        return this.destino;
    }
    
}
