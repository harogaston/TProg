package tprog.logica.dt;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTCliente extends DTUsuario {

	private Set<DTMinReserva> reservas;

	public DTCliente() {
		reservas = null;
	}

	public DTCliente(String nickname, String password, String nombre, String apellido, String email,
			String imagen, Date fechaN, Set<DTMinReserva> Reservas) {
		super(nickname, password, nombre, apellido, email, imagen, fechaN);
		this.reservas = Reservas;
	}

	public DTCliente(DTUsuario dtU) {
		super(dtU.getNickname(), dtU.getPassword(), dtU.getNombre(), dtU.getApellido(), dtU.getEmail(), dtU.getImagen(), dtU.getFechaNacimiento());
		this.reservas = new HashSet<>();
	}

	public Set<DTMinReserva> getReservas() {
		return reservas;
	}

	@Override
	public String toString() {
		String output = super.toString();
		int i = 1;
		for (DTMinReserva dt : reservas) {
			output = output.concat("\n");
			output = output.concat("Reserva " + Integer.toString(i) + "\n");
			output = output.concat(dt.toString());
			i++;
		}
		return output;
	}

	@Override
	public boolean equals(Object o) {
		DTCliente dt = (DTCliente) o;
		return this.reservas.equals(dt.reservas);
	}
}
