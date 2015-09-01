/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

public class DTMinProveedor {

	private final String nickname;
	private final String email;
	private final String empresa;

	public DTMinProveedor(String nickname, String email, String empresa) {
		this.nickname = nickname;
		this.email = email;
		this.empresa = empresa;
	}

	public String getNickname() {
		return this.nickname;
	}

	public String getEmail() {
		return this.email;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	@Override
	public String toString() {
		return "Nickname: " + nickname
				+ "\n" + "Email: " + email + "\n"
				+ "\n" + "Empresa: " + empresa + "\n";
	}
}
