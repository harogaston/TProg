/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.clases;

/**
 *
 * @author gaston
 */
public class Simple extends Categoria{
    
    public Simple(String idCategoria){
		super(idCategoria);
    }
    
    public boolean esCategoriaSimple(){
        return true;
    }
}
