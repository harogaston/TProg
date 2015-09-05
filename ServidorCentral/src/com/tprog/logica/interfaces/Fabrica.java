/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.interfaces;

import com.tprog.logica.controladores.CtrlProductos;
import com.tprog.logica.controladores.CtrlReservas;
import com.tprog.logica.controladores.CtrlUniversal;
import com.tprog.logica.controladores.CtrlUsuarios;

public class Fabrica {

    private static Fabrica instace = null;

    protected Fabrica() {
    }

    ;

	public static Fabrica getInstance() {
        if (instace == null) {
            instace = new Fabrica();
        }
        return instace;
    }

    public ICtrlProductos getICtrlProductos() {
        ICtrlProductos ctrl = new CtrlProductos();
        return ctrl;
    }

    public ICtrlUsuarios getICtrlUsuarios() {
        ICtrlUsuarios ctrl = new CtrlUsuarios();
        return ctrl;
    }

    public ICtrlReservas getICtrlReservas() {
        ICtrlReservas ctrl = new CtrlReservas();
        return ctrl;
    }

    public ICtrlUniversal getICtrlUniversal() {
        ICtrlUniversal ctrl = new CtrlUniversal();
        return ctrl;
    }
}
