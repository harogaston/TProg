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
import com.tprog.logica.dt.DTLineaReserva;
import com.tprog.logica.clases.Servicio;
import com.tprog.logica.clases.Promocion;

public class LineaReserva {
    private int Cantidad;
    private Date FechaInicio;
    private Date FechaFin;
    private float Precio;
    private String servicio;
    private String promocion;
            
            
    public LineaReserva(int c,Date fi, Date ff, String s, String p, float pre){
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
    
    public String getServicio(){
        return this.servicio;
    }
    
    public String getPromocion(){
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
    
    public void setServicio(String s){
        this.servicio = s;
    }
    
    public void setPromocion(String p){
        this.promocion = p;
    }
    
    public DTLineaReserva crearDTLineaReserva(){
        DTLineaReserva dt = new DTLineaReserva(this.Cantidad, this.FechaInicio,this.FechaFin,this.servicio,this.promocion,this.Precio );
        return dt;
     }
    
}

