/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.dt;

import java.util.Date;

public class DTProveedor extends DTUsuario {

	private final String empresa;
	private final String webEmpresa;

	public DTProveedor(String nickname, String password, String nombre, String apellido, String email,
			String imagen, Date fechaN, String empresa, String webEmpresa) {
		super(nickname, password, nombre, apellido, email, imagen, fechaN);
		this.empresa = empresa;
		this.webEmpresa = webEmpresa;
	}

	public DTProveedor(DTUsuario dtU, String empresa, String webEmpresa) {
		super(dtU.nickname, dtU.password, dtU.nombre, dtU.apellido, dtU.email, dtU.imagen, dtU.fechaNacimiento);
		this.empresa = empresa;
		this.webEmpresa = webEmpresa;
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
	public boolean equals(Object o) {
		DTProveedor dt = (DTProveedor) o;
		return this.apellido.equals(dt.apellido)
				&& this.email.equals(dt.email)
				&& this.empresa.equals(dt.empresa)
				&& this.fechaNacimiento.equals(dt.fechaNacimiento)
				&& this.imagen.equals(dt.imagen)
				&& this.nickname.equals(dt.nickname)
                && this.password.equals(dt.password)
				&& this.nombre.equals(dt.nombre)
				&& this.webEmpresa.equals(dt.webEmpresa);
	}
}
