/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.dt;

public enum EstadoReserva {

	Registrada, Cancelada, Pagada, Facturada;

	@Override
	public String toString() {
		switch (this) {
			case Registrada:
				return "Registrada";
			case Cancelada:
				return "Cancelada";
			case Pagada:
				return "Pagada";
			case Facturada:
				return "Facturada";
			default:
				throw new IllegalArgumentException();
		}
	}
}
