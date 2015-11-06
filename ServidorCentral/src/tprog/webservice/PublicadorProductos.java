/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.webservice;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.ws.Endpoint;
import org.apache.commons.lang3.tuple.Triple;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUbicacion;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlProductos;

/**
 *
 * @author ignacio.prandi
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PublicadorProductos {

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
	public DTMinServicio infoMinServicio() {
		return Fabrica.getInstance().getICtrlProductos().infoMinServicio();
	}

	@WebMethod
	public DTMinPromocion infoMinPromocion() {
		return Fabrica.getInstance().getICtrlProductos().infoMinPromocion();
	}

	@WebMethod
	public DTMinPromocion[] listarPromociones() {
		try {
			return (DTMinPromocion[]) Fabrica.getInstance().getICtrlProductos().listarPromociones().toArray();
		} catch (Exception ex) {
			Logger.getLogger(PublicadorProductos.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@WebMethod
	public void seleccionarPromocion(DTMinPromocion dtP) {
		Fabrica.getInstance().getICtrlProductos().seleccionarPromocion(dtP);
	}

	@WebMethod
	public DTPromocion infoPromocion() {
		return Fabrica.getInstance().getICtrlProductos().infoPromocion();
	}

	@WebMethod
	public void seleccionarServicio(DTMinServicio dtS) {
		Fabrica.getInstance().getICtrlProductos().seleccionarServicio(dtS);
	}

	@WebMethod
	public DTServicio infoServicio() {
		return Fabrica.getInstance().getICtrlProductos().infoServicio();
	}

	@WebMethod
	public DefaultMutableTreeNode listarCategorias() {
		//cambiar a arbol de json (un string)
		return Fabrica.getInstance().getICtrlProductos().listarCategorias();
	}

	@WebMethod
	public DTMinServicio[] listarServiciosCategoria(String idCategoria) {
		return (DTMinServicio[]) Fabrica.getInstance().getICtrlProductos().listarServiciosCategoria(idCategoria).toArray();
	}

	@WebMethod
	public DTMinServicio[] listarServicios() {
		try {
			return (DTMinServicio[]) Fabrica.getInstance().getICtrlProductos().listarServicios().toArray();
		} catch (Exception ex) {
			Logger.getLogger(PublicadorProductos.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@WebMethod
	public void cambiarPrecio(float nuevoPrecio) {
		Fabrica.getInstance().getICtrlProductos().cambiarPrecio(nuevoPrecio);
	}

	@WebMethod
	public void cambiarDescripcion(String nuevaDescripcion) {
		Fabrica.getInstance().getICtrlProductos().cambiarDescripcion(nuevaDescripcion);
	}

	@WebMethod
	public String[] listarImagenes() {
		return (String[]) Fabrica.getInstance().getICtrlProductos().listarImagenes().toArray();
	}

	@WebMethod
	public void agregarImagen(String idImagen) {
		try {
			Fabrica.getInstance().getICtrlProductos().agregarImagen(idImagen);
		} catch (Exception ex) {
			Logger.getLogger(PublicadorProductos.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@WebMethod
	public void quitarImagen(String idImagen) {
		try {
			Fabrica.getInstance().getICtrlProductos().quitarImagen(idImagen);
		} catch (Exception ex) {
			Logger.getLogger(PublicadorProductos.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@WebMethod
	public DefaultMutableTreeNode listarCiudades() {
		return Fabrica.getInstance().getICtrlProductos().listarCiudades();
	}

	@WebMethod
	public void cambiarOrigen(DTUbicacion origen) {
		Fabrica.getInstance().getICtrlProductos().cambiarOrigen(origen);
	}

	@WebMethod
	public void cambiarDestino(DTUbicacion destino) {
		Fabrica.getInstance().getICtrlProductos().cambiarDestino(destino);
	}

	@WebMethod
	public String[] listarCategoriasServicio() {
		return (String[]) Fabrica.getInstance().getICtrlProductos().listarCategoriasServicio().toArray();
	}

	@WebMethod
	public boolean agregarCategoria(String idCategoria) {
		return Fabrica.getInstance().getICtrlProductos().agregarCategoria(idCategoria);
	}

	@WebMethod
	public boolean quitarCategoria(String idCategoria) {
		return Fabrica.getInstance().getICtrlProductos().quitarCategoria(idCategoria);
	}

	@WebMethod
	public boolean seleccionarCategoriaPadre(String padre) {
		return Fabrica.getInstance().getICtrlProductos().seleccionarCategoriaPadre(padre);
	}

	@WebMethod
	public boolean idCategoriaDisponible(String idCategoria) {
		return Fabrica.getInstance().getICtrlProductos().idCategoriaDisponible(idCategoria);
	}

	@WebMethod
	public void altaCategoria() {
		Fabrica.getInstance().getICtrlProductos().altaCategoria();
	}

	@WebMethod
	public void seleccionarProveedor(String nickname) {
		Fabrica.getInstance().getICtrlProductos().seleccionarProveedor(nickname);
	}

	@WebMethod
	public boolean idServicioDisponible(String idServicio) {
		return Fabrica.getInstance().getICtrlProductos().idServicioDisponible(idServicio);
	}

	@WebMethod
	public void seleccionarOrigen(DTUbicacion origen) {
		Fabrica.getInstance().getICtrlProductos().seleccionarOrigen(origen);
	}

	@WebMethod
	public void seleccionarDestino(DTUbicacion destino) {
		Fabrica.getInstance().getICtrlProductos().seleccionarDestino(destino);
	}

	@WebMethod
	public boolean seleccionarCategoriaSimple(String idCategoria) {
		return Fabrica.getInstance().getICtrlProductos().seleccionarCategoriaSimple(idCategoria);
	}

	@WebMethod
	public void quitarCategoriaListada(String idCategoria) {
		Fabrica.getInstance().getICtrlProductos().quitarCategoriaListada(idCategoria);
	}

	@WebMethod
	public void altaServicio(String descripcion, float precio, String[] imagenes) {
		Set<String> setImagenes = new HashSet<>();
		for (String imagen : imagenes) {
			setImagenes.add(imagen);
		}
		Fabrica.getInstance().getICtrlProductos().altaServicio(descripcion, precio, setImagenes);
	}

	@WebMethod
	public void agregarServicio(DTMinServicio dtS) {
		Fabrica.getInstance().getICtrlProductos().agregarServicio(dtS);
	}

	@WebMethod
	public boolean idPromocionDisponible(String idPromocion) {
		return Fabrica.getInstance().getICtrlProductos().idPromocionDisponible(idPromocion);
	}

	@WebMethod
	public void altaPromocion(float descuento) {
		Fabrica.getInstance().getICtrlProductos().altaPromocion(descuento);
	}

	@WebMethod
	public DTServicio[] listarServiciosPorTermino(String termino) {
		return (DTServicio[]) Fabrica.getInstance().getICtrlProductos().listarServiciosPorTermino(termino).toArray();
	}

	@WebMethod
	public DTPromocion[] listarPromocionesPorTermino(String termino) {
		return (DTPromocion[]) Fabrica.getInstance().getICtrlProductos().listarPromocionesPorTermino(termino).toArray();
	}
}
