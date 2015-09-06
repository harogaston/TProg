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
        if (r != null) {
            return r.crearDTReserva();
        } else {
            return null;
        }
    }

    public boolean cambiarEstadoReserva(int idReserva, EstadoReserva nuevoEstado) {
        Reserva r = reservas.get(idReserva);
        return r.cambiarEstadoReserva(nuevoEstado);
    }

    public boolean eliminarReserva(int idReserva) {
        Reserva r = reservas.get(idReserva);
        EstadoReserva estado = r.getEstado();
        if (estado == EstadoReserva.Registrada || estado == EstadoReserva.Cancelada) {
            r.getCliente().quitarReserva(idReserva);
            reservas.remove(idReserva);
            return true;
        }
        return false;
    }

    public void agregarReserva(Cliente cliente, DTReserva dtR, String nicknameP) throws Exception {
        if (dtR != null) {
            Reserva nuevaReserva = new Reserva(cliente, dtR, nicknameP);
            reservas.put(nuevaReserva.getIdReserva(), nuevaReserva);
            cliente.agregarReserva(nuevaReserva);
        } else {
            System.out.println("El DTReserva que se paso hacia agregarReserva era nulo");
        }

    }

    public EstadoReserva getEstadoReserva(int idReserva) {
        Reserva r = reservas.get(idReserva);
        return r.getEstado();
    }

    public Map<Integer, Reserva> getReservas() {
        return reservas;
    }
}
