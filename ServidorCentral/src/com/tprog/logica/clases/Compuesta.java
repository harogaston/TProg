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
public class Compuesta extends Categoria{

	public Compuesta(String id) {
		super(id);
	}

	@Override
	public boolean esCategoriaSimple() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
