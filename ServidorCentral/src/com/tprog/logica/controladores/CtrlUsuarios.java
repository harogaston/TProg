/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.controladores;

import com.tprog.logica.dt.DTCliente;
import com.tprog.logica.dt.DTMinCliente;
import com.tprog.logica.dt.DTMinProveedor;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTProveedor;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.DTServicio;
import com.tprog.logica.dt.DTUsuario;
import com.tprog.logica.interfaces.ICtrlUsuarios;
import com.tprog.logica.manejadores.ManejadorProductos;
import com.tprog.logica.manejadores.ManejadorReservas;
import com.tprog.logica.manejadores.ManejadorUsuarios;
import java.util.Set;

public class CtrlUsuarios implements ICtrlUsuarios {

	private String nicknameU;
	private String nicknameP;
	private String email;
	private DTUsuario dtU;
	private boolean esProveedor;
	private String empresa;
	private String web;
	private int idReserva;
	private String idServicio;

	public CtrlUsuarios(){
		this.dtU = null;
		this.email = null;
		this.empresa = null;
		this.esProveedor = false;
		this.idReserva = -1;
		this.idServicio = null;
		this.nicknameP = null;
		this.nicknameU = null;
		this.web = null;
	}
	
	@Override
	public Set<DTMinCliente> listarClientes() throws Exception{
            try{
                ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
                return mu.listarClientes();
            } 
            catch(Exception e){
                throw e;
            }
	}

	@Override
	public void seleccionarCliente(String nickname) {
            this.nicknameU = nickname;
	}

	@Override
	public DTCliente infoCliente() throws Exception {
            try { 
                ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
                return mu.infoCliente(this.nicknameU);
            }
            catch(Exception e){
                throw e;
            }
	}

	@Override
	public void seleccionarReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	@Override
	public DTReserva infoReserva() {
		ManejadorReservas mu = ManejadorReservas.getInstance();
		return mu.infoReserva(this.idReserva);
	}
	@Override
	public boolean verificarNickname(String nickname) {
		this.nicknameU = nickname;
		ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
		return mu.verificarNickname(this.nicknameU);
	}

	@Override
	public boolean verificarEmail(String email) {
		this.email = email;
		ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
		return mu.verificarEmail(this.email);
	}

	@Override
	public void ingresarDatosUsuario(DTUsuario dtU, boolean esProveedor) {
		this.dtU = dtU;
		this.esProveedor = esProveedor;
	}

	@Override
	public void ingresarDatosProveedor(String empresa, String web) {
		this.empresa = empresa;
		this.web = web;
	}

	@Override
	public void altaUsuario() {
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        if (esProveedor) {
            DTProveedor nuevoDT = new DTProveedor(dtU, this.empresa, this.web);
            mu.altaProveedor(nuevoDT);

        } else {
            DTCliente nuevoDT = new DTCliente(dtU);
            mu.altaCliente(nuevoDT);
        }
    }

    @Override
    public Set<DTMinProveedor> listarProveedores() {
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        return mu.listarProveedores();
    }

    @Override
    public void seleccionarProveedor(String nickname) {
        this.nicknameP = nickname;
    }

    @Override
    public DTProveedor infoProveedor() throws Exception {
        try {
            ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
            return mu.infoProveedor(this.nicknameP);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Set<DTMinServicio> listarServiciosProveedor() {
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        return mu.listarServiciosProveedor(this.nicknameP);
    }

    @Override
    public void seleccionarServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public DTServicio infoServicio() {
        ManejadorProductos mp = ManejadorProductos.getInstance();
        DTMinServicio nuevoDT = new DTMinServicio(this.nicknameP, this.idServicio);
        return mp.infoServicio(nuevoDT);
    }

}
