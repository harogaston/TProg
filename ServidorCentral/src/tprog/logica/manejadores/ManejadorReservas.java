/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.manejadores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tprog.logica.clases.Cliente;
import tprog.logica.clases.Reserva;
import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.EstadoReserva;

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
                DTMinReserva dtMin = r.crearDTMin();
                set.add(dtMin);
            }
        }
        return set;
    }

    public DTReserva infoReserva(int idReserva) {
        Reserva r = reservas.get(idReserva);
        if (r != null) {
            return r.crearDT();
        } else {
            return null;
        }
    }

    public boolean cambiarEstadoReserva(int idReserva, EstadoReserva nuevoEstado) {
        Reserva r = reservas.get(idReserva);
        if (r != null) {
            return r.cambiarEstadoReserva(nuevoEstado);
        }
        return false;
    }

    public boolean eliminarReserva(int idReserva) {
        Reserva r = reservas.get(idReserva);
        if (r != null) {
            EstadoReserva estado = r.getEstado();
            if (estado == EstadoReserva.Registrada || estado == EstadoReserva.Cancelada) {
                r.getCliente().quitarReserva(idReserva);
                reservas.remove(idReserva);
                return true;
            }
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
        if (r != null) {
            return r.getEstado();
        } else {
            return null;
        }
    }

    public Map<Integer, Reserva> getReservas() {
        return reservas;
    }

}
