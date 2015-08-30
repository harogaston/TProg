/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.clases;

/**
 *
 * @author MarG
 */
import java.util.Date;
public class LineaReserva {
    private int Cantidad;
    private Date FechaInicio;
    private Date FechaFin;
    private float Precio;
    private Servicio servicio;
    private Promocion promocion;
            
            
    public LineaReserva(int c,Date fi, Date ff, Servicio s, Promocion p, float pre){
        this.Cantidad = c;
        this.FechaInicio = fi;
        this.FechaFin = ff;
        this.servicio = s;
        this.promocion = p;
        this.Precio = pre;
    }
    
    public int getCantidad(){
        return this.Cantidad;
    }
    
    public Date getFechaInicio(){
        return this.FechaInicio;
    }
    
    public Date getFechaFin(){
        return this.FechaFin;
    }
    
    public Servicio getServicio(){
        return this.servicio;
    }
    
    public Promocion getPromocion(){
        return this.promocion;
    }
    
    public float getPrecio(){
        return this.Precio;
    }
    
    public void setCantidad(int c){
        this.Cantidad = c;
    }
    
    public void setFechaInicio(Date finicio){
        this.FechaInicio = finicio;
    }
    
    public void setFechaFin(Date ffin){
        this.FechaFin = ffin;
    }
    
    public void setServicio(Servicio s){
        this.servicio = s;
    }
    
    public void setPromocion(Promocion p){
        this.promocion = p;
    }
    
}

