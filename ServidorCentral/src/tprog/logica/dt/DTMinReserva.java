/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.dt;

import java.util.Date;

public class DTMinReserva {

    private int idReserva;
    private Date fechaCreacion;

    public DTMinReserva(int idReserva, Date fechaCreacion) {
        this.idReserva = idReserva;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public String toString() {
        return "ID de reserva: " + Integer.toString(idReserva)
                + "\n" + "Fecha de creacion: "
                + Integer.toString(fechaCreacion.getDate()) + "-"
                + Integer.toString(fechaCreacion.getMonth() + 1) + "-"
                + Integer.toString(fechaCreacion.getYear()) + "\n";
    }

    @Override
    public boolean equals(Object o) {
        DTMinReserva dt = (DTMinReserva) o;
        return (this.idReserva == dt.idReserva) && this.fechaCreacion.equals(dt.fechaCreacion);
    }

}
