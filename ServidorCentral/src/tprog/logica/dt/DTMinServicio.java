/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.dt;

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
		return "Nickname del proveedor: " + nicknameP
				+ "\n" + "ID de servicio: " + idServicio + "\n";
	}

}
