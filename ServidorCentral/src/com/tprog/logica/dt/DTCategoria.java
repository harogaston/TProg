/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

import java.util.Set;

public class DTCategoria {

	private final String idCategoria;
	private final Set<DTCategoria> subCategorias;

	public DTCategoria(String idCategoria, Set<DTCategoria> subCategorias) {
		this.idCategoria = idCategoria;
		this.subCategorias = subCategorias;
	}

	public String getIdCategoria() {
		return this.idCategoria;
	}

	public Set<DTCategoria> getSubCategorias() {
		return this.subCategorias;
	}

	@Override
	public String toString() {
		return this.idCategoria;
	}
}
