package tprog.logica.dt;

import java.util.Date;

public class DTProveedor extends DTUsuario {

	private final String empresa;
	private final String webEmpresa;

	public DTProveedor(String Nickname, String Password, String Nombre, String Apellido, String Email,
			String Imagen, Date FechaN, String Empresa, String WebEmpresa) {
		super(Nickname, Password, Nombre, Apellido, Email, Imagen, FechaN);
		this.empresa = Empresa;
		this.webEmpresa = WebEmpresa;
	}

	public DTProveedor(DTUsuario dtU, String Empresa, String WebEmpresa) {
		super(dtU.nickname, dtU.password, dtU.nombre, dtU.apellido, dtU.email, dtU.imagen, dtU.fechaNacimiento);
		this.empresa = Empresa;
		this.webEmpresa = WebEmpresa;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public String getWebEmpresa() {
		return this.webEmpresa;
	}

	@Override
	public String toString() {
		String output = super.toString();
		output = output.concat("Empresa: " + empresa + "\n");
		output = output.concat("Web Empresa: " + webEmpresa + "\n");
		return output;
	}

	@Override
	public boolean equals(Object object) {
		DTProveedor dtP = (DTProveedor) object;
		return this.apellido.equals(dtP.apellido)
				&& this.email.equals(dtP.email)
				&& this.empresa.equals(dtP.empresa)
				&& this.fechaNacimiento.equals(dtP.fechaNacimiento)
				&& this.imagen.equals(dtP.imagen)
				&& this.nickname.equals(dtP.nickname)
				&& this.password.equals(dtP.password)
				&& this.nombre.equals(dtP.nombre)
				&& this.webEmpresa.equals(dtP.webEmpresa);
	}
}
