/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.clases;

import java.util.HashSet;
import java.util.Set;

import com.tprog.logica.clases.LineaReserva;
import com.tprog.logica.dt.EstadoReserva;

/**
 *
 * @author Martins
 */

import com.tprog.logica.dt.EstadoReserva;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.DTMinReserva;
import java.util.HashSet;
import java.util.Set;
import com.tprog.logica.clases.LineaReserva;
import java.util.Date;
import java.util.Iterator;

public class Reserva {
    private String idReserva;
    private Date fcreacion; // pasar a date en un futuro muy cercano
    private EstadoReserva estado;
    private float precioTotal;
    Set<LineaReserva> lineasReserva;  
    
    public Reserva(String id, Date creacion, EstadoReserva estado, float p){
        this.idReserva = id;
        this.fcreacion = creacion;
        this.estado = estado;
        this.precioTotal = p;
        this.lineasReserva = new HashSet();
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
    
    public void agregarLineaReserva(LineaReserva linea){
        lineasReserva.add(linea);
        float p = linea.getPrecio();
        p = p + this.getPrecioTotal();
        setPrecioTotal(p);
    }
    
    public void setEstadoReserva(EstadoReserva est){
        this.estado = est;
    }
    
    public void setPrecioTotal(float p){
        this.precioTotal = p;
    }
    
    public DTReserva crearDTReserva(){
        DTReserva dt = new DTReserva(this.idReserva, this.fcreacion, this.estado, 
                this.precioTotal, this.lineasReserva);
        return dt;
    }
    
    public DTMinReserva crearDTMinReserva(){
        DTMinReserva dt = new DTMinReserva(this.idReserva, this.fcreacion);
        return dt;
    }
    
    public boolean cambiarEstadoReserva(EstadoReserva nuevoEstado){
        if ( ( "Registrada".equals(this.getEstadoReserva().toString()))
                    && (!"Facturada".equals(nuevoEstado.toString()))){
                setEstadoReserva(nuevoEstado);
                return true;
            }else return false;
    }
    public void eliminar(){
        this.lineasReserva.clear();
	      
    }
}
