/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

import java.util.Set;
/**
 *
 * @author sofia
 */
public class DTServicio {
    
    private final String idServicio;
    private final String descripcion;
    private final float precio;
    private final Set<String> imagenes;
    private final DTUbicacion origen;
    private final DTUbicacion destino;

	public DTServicio(String idServicio, String descripcion, float precio,
            Set<String> imgagenes, DTUbicacion origen, DTUbicacion destino) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenes = imgagenes;
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
    
    public Set<String> getImagenes(){
        return this.imagenes;
    }
    
    public DTUbicacion getOrigen(){
        return this.origen;
    }
    
    public DTUbicacion getDestino(){
        return this.destino;
    }
    
}