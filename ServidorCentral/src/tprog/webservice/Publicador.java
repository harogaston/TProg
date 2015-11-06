/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import tprog.logica.controladores.CtrlUsuarios;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlUsuarios;

/**
 *
 * @author ignacio.prandi
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Publicador {

	//private Logica logica = new Logica();
	private Endpoint endpoint = null;

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://localhost:9128/publicador", this);
	}

	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}

	@WebMethod
	public CtrlUsuarios getCtrlUsuarios() {
		return (CtrlUsuarios) Fabrica.getInstance().getICtrlUsuarios();
	}

	@WebMethod
	public int nuevoCliente(int i) {
		return i;

	}

	@WebMethod
	public String[] verServicio(String idServicio, String idProveedor) {
		return new String[]{idServicio, idProveedor};
	}

}
