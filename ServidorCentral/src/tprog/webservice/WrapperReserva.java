/*
 * Header Test
 */
package tprog.webservice;

import tprog.logica.dt.DTReserva;

/**
 *
 * @author marccio
 */
public class WrapperReserva implements Comparable<WrapperReserva> {

	public String nickCliente;
    public String emailCliente;
	public DTReserva reserva;

	@Override
	public int compareTo(WrapperReserva object) {
		if (Integer.compare(reserva.getIdReserva(), object.reserva.getIdReserva()) == 0) {
			return reserva.getFCreacion().compareTo(object.reserva.getFCreacion());
		} else {
			return Integer.compare(reserva.getIdReserva(), object.reserva.getIdReserva());
		}
	}

}
