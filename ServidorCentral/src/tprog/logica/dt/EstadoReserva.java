package tprog.logica.dt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public enum EstadoReserva {

	Registrada, Cancelada, Pagada, Facturada;

	@Override
	public String toString() {
		switch (this) {
			case Registrada:
				return "Registrada";
			case Cancelada:
				return "Cancelada";
			case Pagada:
				return "Pagada";
			case Facturada:
				return "Facturada";
			default:
				throw new IllegalArgumentException();
		}
	}
}
