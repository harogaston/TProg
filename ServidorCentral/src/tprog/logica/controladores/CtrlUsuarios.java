/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.controladores;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTMinCliente;
import tprog.logica.dt.DTMinProveedor;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUsuario;
import tprog.logica.interfaces.ICtrlUsuarios;
import tprog.logica.manejadores.ManejadorProductos;
import tprog.logica.manejadores.ManejadorReservas;
import tprog.logica.manejadores.ManejadorUsuarios;

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
	private Image imagen;

	public CtrlUsuarios() {
		this.dtU = null;
		this.email = null;
		this.empresa = null;
		this.esProveedor = false;
		this.idReserva = -1;
		this.idServicio = null;
		this.nicknameP = null;
		this.nicknameU = null;
		this.web = null;
		this.imagen = null;
	}

	@Override
	public Set<DTMinCliente> listarClientes() throws Exception {
		try {
			ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
			return mu.listarClientes();
		} catch (Exception e) {
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
		} catch (Exception e) {
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
	public void altaUsuario() throws Exception{
		ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
		DTUsuario nuevoDT;
		if (esProveedor) {
			nuevoDT = new DTProveedor(dtU, this.empresa, this.web);

		} else {
			nuevoDT = new DTCliente(dtU);
		}
		mu.altaUsuario(nuevoDT, esProveedor, imagen);
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

	@Override
	public void seleccionarImagen(Image imagen) {
		this.imagen = imagen;
	}

}
