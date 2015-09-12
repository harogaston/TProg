/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.interfaces;

import java.awt.Image;
import java.util.Set;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTMinCliente;
import tprog.logica.dt.DTMinProveedor;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUsuario;

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

	public void altaUsuario() throws Exception;

	public Set<DTMinProveedor> listarProveedores();

	public void seleccionarProveedor(String nickname);

	public DTProveedor infoProveedor() throws Exception;

	public Set<DTMinServicio> listarServiciosProveedor();

	public void seleccionarServicio(String idServicio);

	public DTServicio infoServicio();

	public void seleccionarImagen(Image imagen);
}
