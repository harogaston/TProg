/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.clases;
import java.util.*;
        
/**
 *
 * @author gaston
 */
public abstract class Categoria {
    private String idCategoria;
    
    public Categoria(String id){
        this.idCategoria = id;
    }
    
    public abstract boolean esCategoriaSimple();
	
	public String getIdCategoria(){
		return this.idCategoria;
	}

}
