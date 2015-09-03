/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

public class DTMinCliente {

	private String nickname;
	private String email;

	public DTMinCliente(String nickname, String email) {
		this.nickname = nickname;
		this.email = email;
	}

	public String getNickname() {
		return this.nickname;
	}

	public String getEmail() {
		return this.email;
	}

	@Override
	public String toString() {
		return "Nickname: " + nickname
				+ "\n" + "Email: " + email + "\n";
	}

	@Override
	public boolean equals(Object o){
		DTMinCliente dt = (DTMinCliente) o;
		return (this.email == dt.email) && (this.nickname == dt.nickname);
	}
}
