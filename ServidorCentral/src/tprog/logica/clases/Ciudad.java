/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.clases;

import tprog.logica.dt.DTUbicacion;

public class Ciudad {

	private String idCiudad;
	private Pais pais;

	public Ciudad(String id) {
		this.idCiudad = id;
	}

	public String getIdCiudad() {
            return this.idCiudad;
	}
        
        public Pais getPais(){
            return this.pais;
        }

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public DTUbicacion crearDT() {
		DTUbicacion nuevoDT = new DTUbicacion(this.idCiudad, this.pais.getIdPais());
		return nuevoDT;
	}
}