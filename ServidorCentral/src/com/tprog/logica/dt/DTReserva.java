/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

import java.util.HashSet;
import java.util.Set;

import com.tprog.logica.dt.EstadoReserva;

/**
 *
 * @author MarG
 */

import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import com.tprog.logica.dt.EstadoReserva;
import java.util.Date;
import com.tprog.logica.clases.LineaReserva;
import com.tprog.logica.dt.DTLineaReserva;
        
public class DTReserva {
    private String idReserva;
    private Date fcreacion; // pasar a date en un futuro muy cercano
    private EstadoReserva estado;
    private float precioTotal;
    Set<DTLineaReserva> lineasReserva;  
    
    public DTReserva(String id, Date creacion, EstadoReserva estado, float p, Set<LineaReserva> linea){
        this.idReserva = id;
        this.fcreacion = creacion;
        this.estado = estado;
        this.precioTotal = p;
        this.lineasReserva = new HashSet();
        
        Iterator<LineaReserva> it = linea.iterator();
        while (it.hasNext()){
			LineaReserva l = it.next();
			DTLineaReserva temp = l.crearDTLineaReserva();
			lineasReserva.add(temp);
        }
    }
    public String getIdReserva(){
        return idReserva;
    }    
    
    public Date getFCreacion(){
        return fcreacion;
    }
    
    public EstadoReserva getEstadoReserva(){
        return estado;
    }
    
    public float getPrecioTotal(){
        return precioTotal;
    }
    public Set<DTLineaReserva> getDTLineasReserva(){
        return this.lineasReserva;
    }
    
    
}
