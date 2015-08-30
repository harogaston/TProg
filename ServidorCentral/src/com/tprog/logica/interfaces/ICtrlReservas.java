/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.interfaces;

import java.util.Set;
import java.util.Date;

import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.EstadoReserva;

/**
 *
 * @author gaston
 */
public interface ICtrlReservas {
	public void seleccionarCliente(String nickname);
	public Set<DTMinPromocion> listarPromociones();
	public Set<DTMinServicio> listarServicios();
	public void seleccionarPromocion(DTMinPromocion dtP);
	public void seleccionarServicio(DTMinServicio dtS);
	public void ingresarLineaReserva(int cant, Date fInicial, Date fFinal);
	public Set<DTMinServicio> listarServiciosProveedor();
	public Set<DTMinPromocion> listarPromocionesProveedor();
	public DTReserva mostrarReservaTemporal();
	public void altaReserva();
	public Set<DTMinReserva> listarReservas();
	public void seleccionarReserva(int idReserva);
	public DTReserva infoReserva();
	public boolean cambiarEstadoReserva(EstadoReserva nuevoEstado);
	public void eliminarReserva();
}