/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica;

/**
 *
 * @author gaston
 */
public class Pais {
    private String idPais;
    
    public Pais(String id){
        this.idPais = id;
    }
    
    public String getIdPais(){
        return this.idPais;
    }
    
    public void setIdPais(String id){
        this.idPais = id;
    }
}
