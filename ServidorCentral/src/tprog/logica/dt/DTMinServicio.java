package tprog.logica.dt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTMinServicio {

	private final String nicknameP;
	private final String idServicio;

	public DTMinServicio(String NicknameP, String IdServicio) {
		this.nicknameP = NicknameP;
		this.idServicio = IdServicio;
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
		return new HashCodeBuilder(17, 31).// two randomly chosen prime numbers
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
		DTMinServicio dtMinS = (DTMinServicio) obj;

		//magia especialmente negra para determinar igualdad de dos objetos de este tipo
		return new EqualsBuilder().
				// if deriving: appendSuper(super.equals(obj)).
				append(idServicio, dtMinS.getIdServicio()).
				append(nicknameP, dtMinS.getNicknameP()).
				isEquals();

	}

}
