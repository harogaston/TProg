package tprog.logica.clases;

import java.util.HashMap;
import java.util.Map;

public class Pais {

	private String idPais;
	private Map<String, Ciudad> ciudades;

	public Pais(String idPais) {
		this.idPais = idPais;
		this.ciudades = new HashMap();
	}

	public String getIdPais() {
		return this.idPais;
	}

	public Map<String, Ciudad> getCiudades() {
		return this.ciudades;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	public void agregarCiudad(Ciudad ciudad) {
		this.ciudades.put(ciudad.getIdCiudad(), ciudad);
		ciudad.setPais(this);
	}
}
