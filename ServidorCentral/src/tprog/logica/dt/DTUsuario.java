package tprog.logica.dt;

import java.util.Date;

public class DTUsuario {

	private String nickname;
	private String nombre;
	private String apellido;
	private String password;
	private String email;
	private String imagen;
	private Date fechaNacimiento;

	public DTUsuario(String Nickname, String Password, String Nombre, String Apellido, String Email,
			String Imagen, Date FechaNacimiento) {
		this.nickname = Nickname;
		this.password = Password;
		this.nombre = Nombre;
		this.apellido = Apellido;
		this.email = Email;
		this.imagen = Imagen;
		this.fechaNacimiento = FechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getImagen() {
		return imagen;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Nickname: " + nickname
				+ "\n" + "Nombre: " + nombre
				+ "\n" + "Apellido: " + apellido
				+ "\n" + "Email: " + email
				+ "\n" + "Fecha de nacimiento: "
				+ Integer.toString(fechaNacimiento.getDate()) + "-"
				+ Integer.toString(fechaNacimiento.getMonth() + 1) + "-"
				+ Integer.toString(fechaNacimiento.getYear() + 1900) + "\n";

	}
}
