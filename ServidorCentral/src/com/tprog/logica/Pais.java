/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica;
import java.util.*;

        
/**
 *
 * @author gaston
 */
public class Pais {
    private String idPais;
    private Map<String, Ciudad> ciudades;
    
    public Pais(String id){
        this.idPais = id;
        this.ciudades = new HashMap();
    }
    
    public String getIdPais(){
        return this.idPais;
    }
    
    public void setIdPais(String id){
        this.idPais = id;
    }
}
