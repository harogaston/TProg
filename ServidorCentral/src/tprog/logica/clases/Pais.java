package tprog.logica.clases;

import java.util.HashMap;
import java.util.Map;

public class Pais {

	private String idPais;
	private Map<String, Ciudad> ciudades;

	public Pais(String id) {
		this.idPais = id;
		this.ciudades = new HashMap();
	}

	public String getIdPais() {
		return this.idPais;
	}

	public Map<String, Ciudad> getCiudades() {
		return this.ciudades;
	}

	public void setIdPais(String id) {
		this.idPais = id;
	}

	public void agregarCiudad(Ciudad c) {
		this.ciudades.put(c.getIdCiudad(), c);
		c.setPais(this);
	}
}
