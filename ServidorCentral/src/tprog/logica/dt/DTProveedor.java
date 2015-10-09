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
		super(dtU.getNickname(), dtU.getPassword(), dtU.getNombre(), dtU.getApellido(), dtU.getEmail(), dtU.getImagen(), dtU.getFechaNacimiento());
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
		return this.getApellido().equals(dtP.getApellido())
				&& this.getEmail().equals(dtP.getEmail())
				&& this.getEmpresa().equals(dtP.getEmpresa())
				&& this.getFechaNacimiento().equals(dtP.getFechaNacimiento())
				&& this.getImagen().equals(dtP.getImagen())
				&& this.getNickname().equals(dtP.getNickname())
				&& this.getPassword().equals(dtP.getPassword())
				&& this.getNombre().equals(dtP.getNombre())
				&& this.getWebEmpresa().equals(dtP.getWebEmpresa());
	}
}
