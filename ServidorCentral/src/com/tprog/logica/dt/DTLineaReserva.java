/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

import java.util.Date;

public class DTLineaReserva {

    private int cantidad;
    private Date fechaInicio;
    private Date fechaFin;
    private String servicio;
    private String promocion;
    private float precio;

    public DTLineaReserva(int cantidad, Date fechaInicio, Date fechaFin, String servicio, String promocion, float precio) {
        this.cantidad = cantidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.servicio = servicio;
        this.promocion = promocion;
        this.precio = precio;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public String getServicio() {
        return this.servicio;
    }

    public String getPromocion() {
        return this.promocion;
    }

    public float getPrecio() {
        return this.precio;
    }

    @Override
    public String toString() {
        if (promocion == null) {
            return "Cantidad: " + Integer.toString(cantidad)
                    + "\n" + "Fecha de inicio: "
                    + Integer.toString(fechaInicio.getDate()) + "-"
                    + Integer.toString(fechaInicio.getMonth() + 1) + "-"
                    + Integer.toString(fechaInicio.getYear())
                    + "\n" + "Fecha de fin: "
                    + Integer.toString(fechaFin.getDate()) + "-"
                    + Integer.toString(fechaFin.getMonth() + 1) + "-"
                    + Integer.toString(fechaFin.getYear())
                    + "\n" + "Servicio: " + servicio
                    + "\n" + "Precio: " + Float.toString(precio) + "\n";
        } else {
            return "Cantidad: " + Integer.toString(cantidad)
                    + "\n" + "Fecha de inicio: "
                    + Integer.toString(fechaInicio.getDate()) + "-"
                    + Integer.toString(fechaInicio.getMonth() +1 ) + "-"
                    + Integer.toString(fechaInicio.getYear())
                    + "\n" + "Fecha de fin: "
                    + Integer.toString(fechaFin.getDate()) + "-"
                    + Integer.toString(fechaFin.getMonth() + 1) + "-"
                    + Integer.toString(fechaFin.getYear())
                    + "\n" + "Promocion: " + promocion
                    + "\n" + "Precio: " + Float.toString(precio) + "\n";
        }
    }
}
