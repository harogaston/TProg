package tprog.logica.dt;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DTMinServicio {

	private final String nicknameP;
	private final String idServicio;

	public DTMinServicio(String nicknameP, String idServicio) {
		this.nicknameP = nicknameP;
		this.idServicio = idServicio;
	}

	public String getNicknameP() {
		return this.nicknameP;
	}

	public String getIdServicio() {
		return this.idServicio;
	}

	@Override
	public String toString() {
		return "Proveedor: " + nicknameP
				+ "\n" + "ID de servicio: " + idServicio + "\n";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
				// if deriving: appendSuper(super.hashCode()).
				append(idServicio).
				append(nicknameP).
				toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		DTMinServicio dt = (DTMinServicio) obj;

		//magia especialmente negra para determinar igualdad de dos objetos de este tipo
		return new EqualsBuilder().
				// if deriving: appendSuper(super.equals(obj)).
				append(idServicio, dt.getIdServicio()).
				append(nicknameP, dt.getNicknameP()).
				isEquals();

	}

}
