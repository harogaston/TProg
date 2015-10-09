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

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais Pais) {
		this.pais = Pais;
	}

	public DTUbicacion crearDT() {
		DTUbicacion nuevoDT = new DTUbicacion(this.idCiudad, this.pais.getIdPais());
		return nuevoDT;
	}
}
