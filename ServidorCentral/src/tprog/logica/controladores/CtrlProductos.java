package tprog.logica.controladores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinProveedor;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUbicacion;
import tprog.logica.interfaces.ICtrlProductos;
import tprog.logica.manejadores.ManejadorProductos;

public class CtrlProductos implements ICtrlProductos {

	protected DTMinPromocion dtP;
	protected DTMinServicio dtS;
	protected String categoriaPadre;
	private String idCategoria;
	protected String nicknameP;
	private List<String> listaServicios;
	private Set<String> listaCategorias;
	private DTUbicacion origen;
	private DTUbicacion destino;

	public CtrlProductos() {
		this.dtP = null;
		this.dtS = null;
		this.categoriaPadre = null;
		this.idCategoria = null;
		this.nicknameP = null;
		this.listaServicios = new ArrayList();
		this.listaCategorias = new HashSet();
		this.origen = null;
		this.destino = null;
	}

	@Override
	public Set<DTMinPromocion> listarPromociones() throws Exception {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.listarPromociones();
	}

	@Override
	public void seleccionarPromocion(DTMinPromocion dtP) {
		this.dtP = dtP;
	}

	@Override
	public DTPromocion infoPromocion() {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.infoPromocion(dtP);
	}

	@Override
	public DTMinPromocion infoMinPromocion() {
		return dtP;
	}

	@Override
	public void seleccionarServicio(DTMinServicio dtS) {
		this.dtS = dtS;
	}

	@Override
	public DTServicio infoServicio() {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.infoServicio(dtS);
	}

	@Override
	public DTMinServicio infoMinServicio() {
		return dtS;
	}

	@Override
	public DefaultMutableTreeNode listarCategorias() {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.listarCategorias();
	}

	@Override
	public Set<DTMinServicio> listarServiciosCategoria(String idCategoria) {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.listarServiciosCategoria(idCategoria);
	}

	@Override
	public Set<DTMinServicio> listarServicios() throws Exception {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.listarServicios();
	}

	@Override
	public void cambiarPrecio(float nuevoPrecio) {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		mp.cambiarPrecio(dtS, nuevoPrecio);
	}

	@Override
	public void cambiarDescripcion(String descripcion) {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		mp.cambiarDescripcion(dtS, descripcion);
	}

	@Override
	public Set<String> listarImagenes() {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.listarImagenes(dtS);
	}

	@Override
	public void agregarImagen(String idImagen) throws Exception {
		try {
			ManejadorProductos mp = ManejadorProductos.getInstance();
			mp.agregarImagen(dtS, idImagen);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void quitarImagen(String idImagen) throws Exception {
		try {
			ManejadorProductos mp = ManejadorProductos.getInstance();
			mp.quitarImagen(dtS, idImagen);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public DefaultMutableTreeNode listarCiudades() {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.listarCiudades();
	}

	@Override
	public void cambiarOrigen(DTUbicacion dtU) {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		mp.cambiarOrigen(dtS, dtU);
	}

	@Override
	public void cambiarDestino(DTUbicacion dtU) {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		mp.cambiarDestino(dtS, dtU);
	}

	@Override
	public Set<String> listarCategoriasServicio() {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.listarCategoriasServicio(dtS);
	}

	@Override
	public boolean agregarCategoria(String idCategoria) {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.esCategoriaSimpleAgregar(dtS, idCategoria);
	}

	@Override
	public boolean quitarCategoria(String idCategoria) {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.esCategoriaSimpleQuitar(dtS, idCategoria);
	}

	@Override
	public boolean seleccionarCategoriaPadre(String padre) {
		this.categoriaPadre = padre;
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.esCategoriaPadre(padre);
	}

	@Override
	public boolean idCategoriaDisponible(String idCategoria) {
		this.idCategoria = idCategoria;
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.idCategoriaDisponible(idCategoria);
	}

	@Override
	public void altaCategoria() {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		mp.altaCategoria(this.idCategoria, this.categoriaPadre);
	}

	@Override
	public void seleccionarProveedor(String nick) {
		this.nicknameP = nick;
	}

	@Override
	public boolean idServicioDisponible(String idServicio) {
		this.dtS = new DTMinServicio(this.nicknameP, idServicio);
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.idServicioDisponible(idServicio, this.nicknameP);
	}

	@Override
	public void seleccionarOrigen(DTUbicacion dtU) {
		this.origen = dtU;
	}

	@Override
	public void seleccionarDestino(DTUbicacion dtU) {
		this.destino = dtU;
	}

	@Override
	public boolean seleccionarCategoriaSimple(String idCategoria) {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		boolean esValida = mp.esCategoriaSimple(idCategoria);
		if (esValida) {
			this.listaCategorias.add(idCategoria);
		}
		return esValida;
	}

	@Override
	public void quitarCategoriaListada(String idCategoria) {
		if (!listaCategorias.isEmpty() && listaCategorias.contains(idCategoria)) {
			listaCategorias.remove(idCategoria);
		}
	}

	@Override
	public void altaServicio(String descripcion, float precio, Set<String> imagenes) {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		DTServicio serv = new DTServicio(this.dtS.getIdServicio(), descripcion,
				precio, imagenes, this.origen, this.destino);
		mp.altaServicio(serv, this.nicknameP, this.listaCategorias);
	}

	@Override
	public void agregarServicio(DTMinServicio dtS) {
		this.listaServicios.add(dtS.getIdServicio());
	}

	@Override
	public boolean idPromocionDisponible(String idPromocion) {
		this.dtP = new DTMinPromocion(this.nicknameP, idPromocion);
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.idPromocionDisponible(idPromocion, this.nicknameP);
	}

	@Override
	public void altaPromocion(float descuento) {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		mp.altaPromocion(this.dtP.getIdPromocion(), descuento, this.dtP.getNicknameP(), this.listaServicios);
	}

	public DTUbicacion getDestino() {
		return this.destino;
	}

	public DTUbicacion getOrigen() {
		return this.origen;
	}
}
