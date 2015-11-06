package tprog.logica.dt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTUbicacion {

	private final String ciudad;
	private final String pais;

	public DTUbicacion(String Ciudad, String Pais) {
		this.ciudad = Ciudad;
		this.pais = Pais;
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
