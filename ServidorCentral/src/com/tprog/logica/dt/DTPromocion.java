/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;
import  java.util.*;
/**
 *
 * @author sofia
 */
public class DTPromocion {
    
    private final String idPromocion;
    private final float descuento;
    private final float total;
    private final Set<DTMinServicio> servicios;
    
    public DTPromocion(String id, float desc, float total,
            Set<DTMinServicio> serv) {
        this.idPromocion = id;
        this.descuento = desc;
        this.total = total;
        this.servicios = serv;
    }
   
    public String getIdPromocion(){
        return this.idPromocion;
    }
    
    public float getDescuento(){
        return this.descuento;
    }
    
    public float getTotal(){
        return this.total;
    }
    
}
