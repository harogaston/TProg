/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.manejadores;

import com.tprog.logica.clases.Cliente;
import com.tprog.logica.clases.Reserva;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.EstadoReserva;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ManejadorReservas {

	private Map<Integer, Reserva> reservas;
	private static ManejadorReservas instance = null;

	public static ManejadorReservas getInstance() {
		if (instance == null) {
			instance = new ManejadorReservas();
		}
		return instance;
	}

	private ManejadorReservas() {
            reservas = new HashMap();
	}

	public Set<DTMinReserva> listarReservas() {
            Set<DTMinReserva> set = new HashSet();
            if (!reservas.isEmpty()) {
                for (Reserva r : reservas.values()) {
                    DTMinReserva dtMin = r.crearDTMinReserva();
                    set.add(dtMin);
                }
            }
            return set;
	}

	public DTReserva infoReserva(int idReserva) {
		Reserva r = reservas.get(idReserva);
		return r.crearDTReserva();
	}

	public boolean cambiarEstadoReserva(int idReserva, EstadoReserva nuevoEstado) {
		Reserva r = reservas.get(idReserva);

		return r.cambiarEstadoReserva(nuevoEstado);
	}

	public void eliminarReserva(int idReserva) {
		Reserva r = reservas.get(idReserva);
		r.eliminar();
		// sacar del map
		this.reservas.remove(r);
	}

	public void agregarReserva(Cliente cliente, DTReserva dtR, String nicknameP) throws Exception {
            if (dtR == null) System.out.println("la palida");
            Reserva nuevaReserva = new Reserva(dtR, nicknameP);
            reservas.put(nuevaReserva.getIdReserva(), nuevaReserva);
            cliente.agregarReserva(nuevaReserva);
	}
}
