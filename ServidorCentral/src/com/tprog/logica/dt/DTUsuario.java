/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

import java.util.Date;

public class DTUsuario {

	protected String nickname;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected String imagen;
	protected Date fechaNacimiento;

	public DTUsuario(String nickname, String nombre, String apellido, String empresa,
			String imagen, Date fechaNacimiento) {
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = empresa;
		this.imagen = imagen;
		this.fechaNacimiento = fechaNacimiento;
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

	public String getEmail() {
		return email;
	}

	public String getImagen() {
		return imagen;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

}
