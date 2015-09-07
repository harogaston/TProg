/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.interfaces;

import com.tprog.logica.dt.DTCliente;
import com.tprog.logica.dt.DTMinCliente;
import com.tprog.logica.dt.DTMinProveedor;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTProveedor;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.DTServicio;
import com.tprog.logica.dt.DTUsuario;
import java.util.Set;

public interface ICtrlUsuarios {

    public Set<DTMinCliente> listarClientes() throws Exception;

    public void seleccionarCliente(String nickname);

    public DTCliente infoCliente() throws Exception;

    public void seleccionarReserva(int idReserva);

    public DTReserva infoReserva();

    public boolean verificarNickname(String nickname);

    public boolean verificarEmail(String email);

    public void ingresarDatosUsuario(DTUsuario dtU, boolean esProveedor);

    public void ingresarDatosProveedor(String empresa, String web);

    public void altaUsuario();

    public Set<DTMinProveedor> listarProveedores();

    public void seleccionarProveedor(String nickname);

    public DTProveedor infoProveedor() throws Exception;

    public Set<DTMinServicio> listarServiciosProveedor();

    public void seleccionarServicio(String idServicio);

    public DTServicio infoServicio();
}
