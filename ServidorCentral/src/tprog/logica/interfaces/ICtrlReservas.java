/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.interfaces;

import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.EstadoReserva;
import java.util.Date;
import java.util.Set;

public interface ICtrlReservas {

    public void seleccionarCliente(String nickname);

    public void seleccionarProveedor(String nicknameP);

    public void seleccionarDTReserva(DTReserva dtr);

    public Set<DTMinPromocion> listarPromociones() throws Exception;

    public Set<DTMinServicio> listarServicios() throws Exception;

    public void seleccionarPromocion(DTMinPromocion dtP);

    public void seleccionarServicio(DTMinServicio dtS);

    public void ingresarLineaReserva(int cant, Date fInicial, Date fFinal);

    public Set<DTMinServicio> listarServiciosProveedor();

    public Set<DTMinPromocion> listarPromocionesProveedor();

    public DTReserva mostrarReservaTemporal();

    public void altaReserva() throws Exception;

    public Set<DTMinReserva> listarReservas() throws Exception;

    public void seleccionarReserva(int idReserva);

    public DTReserva infoReserva();

    public boolean cambiarEstadoReserva(EstadoReserva nuevoEstado);

    public boolean eliminarReserva();

    public EstadoReserva getEstadoReserva();

    public void liberarMemoriaControlador();
}
