package tprog.logica.dt;

public class DTUbicacion {

	private final String ciudad;
	private final String pais;

	public DTUbicacion(String ciudad, String pais) {
		this.ciudad = ciudad;
		this.pais = pais;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public String getPais() {
		return this.pais;
	}

	@Override
	public String toString() {
		return "Ciudad: " + ciudad + ", Pais: " + pais;
	}

}
