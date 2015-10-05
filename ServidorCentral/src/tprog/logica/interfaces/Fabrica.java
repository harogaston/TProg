package tprog.logica.interfaces;

import tprog.logica.controladores.CtrlProductos;
import tprog.logica.controladores.CtrlReservas;
import tprog.logica.controladores.CtrlUsuarios;

public class Fabrica {

    private static Fabrica instace = null;

    protected Fabrica() {
    }

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
}
