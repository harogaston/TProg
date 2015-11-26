package tprog.logica.controladores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import tprog.logica.clases.RankingServicios;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUbicacion;
import tprog.logica.interfaces.ICtrlProductos;
import tprog.logica.manejadores.ManejadorProductos;

public class CtrlProductos implements ICtrlProductos {

	private DTMinPromocion dtP;
	private DTMinServicio dtS;
	private String categoriaPadre;
	private String idCategoria;
	private String nicknameP;
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
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.listarPromociones();
	}

	@Override
	public void seleccionarPromocion(DTMinPromocion DTP) {
		this.dtP = DTP;
	}

	@Override
	public DTPromocion infoPromocion() {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.infoPromocion(dtP);
	}

	@Override
	public DTMinPromocion infoMinPromocion() {
		return dtP;
	}

	@Override
	public void seleccionarServicio(DTMinServicio DTS) {
		this.dtS = DTS;
	}

	@Override
	public DTServicio infoServicio() {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.infoServicio(dtS);
	}

	@Override
	public DTMinServicio infoMinServicio() {
		return dtS;
	}

	@Override
	public DefaultMutableTreeNode listarCategorias() {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.listarCategorias();
	}

	@Override
	public Set<DTMinServicio> listarServiciosCategoria(String IdCategoria) {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.listarServiciosCategoria(IdCategoria);
	}

	@Override
	public Set<DTMinServicio> listarServicios() throws Exception {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.listarServicios();
	}

	@Override
	public void cambiarPrecio(float nuevoPrecio) {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		manejadorP.cambiarPrecio(dtS, nuevoPrecio);
	}

	@Override
	public void cambiarDescripcion(String descripcion) {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		manejadorP.cambiarDescripcion(dtS, descripcion);
	}

	@Override
	public Set<String> listarImagenes() {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.listarImagenes(dtS);
	}

	@Override
	public void agregarImagen(String idImagen) throws Exception {
		try {
			ManejadorProductos manejadorP = ManejadorProductos.getInstance();
			manejadorP.agregarImagen(dtS, idImagen);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void quitarImagen(String idImagen) throws Exception {
		try {
			ManejadorProductos manejadorP = ManejadorProductos.getInstance();
			manejadorP.quitarImagen(dtS, idImagen);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public DefaultMutableTreeNode listarCiudades() {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.listarCiudades();
	}

	@Override
	public void cambiarOrigen(DTUbicacion dtU) {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		manejadorP.cambiarOrigen(dtS, dtU);
	}

	@Override
	public void cambiarDestino(DTUbicacion dtU) {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		manejadorP.cambiarDestino(dtS, dtU);
	}

	@Override
	public Set<String> listarCategoriasServicio() {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.listarCategoriasServicio(dtS);
	}

	@Override
	public boolean agregarCategoria(String IdCategoria) {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.esCategoriaSimpleAgregar(dtS, IdCategoria);
	}

	@Override
	public boolean quitarCategoria(String IdCategoria) {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.esCategoriaSimpleQuitar(dtS, IdCategoria);
	}

	@Override
	public boolean seleccionarCategoriaPadre(String Padre) {
		this.categoriaPadre = Padre;
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.esCategoriaPadre(Padre);
	}

	@Override
	public boolean idCategoriaDisponible(String IdCategoria) {
		this.idCategoria = IdCategoria;
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.idCategoriaDisponible(idCategoria);
	}

	@Override
	public void altaCategoria() {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		manejadorP.altaCategoria(this.idCategoria, this.categoriaPadre);
	}

	@Override
	public void seleccionarProveedor(String nick) {
		this.nicknameP = nick;
	}

	@Override
	public boolean idServicioDisponible(String idServicio) {
		this.dtS = new DTMinServicio(this.nicknameP, idServicio);
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.idServicioDisponible(idServicio, this.nicknameP);
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
	public boolean seleccionarCategoriaSimple(String IdCategoria) {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		boolean esValida = manejadorP.esCategoriaSimple(IdCategoria);
		if (esValida) {
			this.listaCategorias.add(IdCategoria);
		}
		return esValida;
	}

	@Override
	public void quitarCategoriaListada(String IdCategoria) {
		if (!listaCategorias.isEmpty() && listaCategorias.contains(IdCategoria)) {
			listaCategorias.remove(IdCategoria);
		}
	}
    @Override
    public Set<String> getListaCategorias(){
        return this.listaCategorias;
    }
    
	@Override
	public void altaServicio(String descripcion, float precio, Set<String> imagenes) {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		DTServicio serv = new DTServicio(this.dtS.getIdServicio(), this.dtS.getNicknameP(), descripcion,
				precio, imagenes, this.origen, this.destino);
		manejadorP.altaServicio(serv, this.nicknameP, this.listaCategorias);
	}

	@Override
	public void agregarServicio(DTMinServicio DTS) {
		this.listaServicios.add(DTS.getIdServicio());
	}
    
    @Override
    public List<String> getListaServicios(){
        return this.listaServicios;
    }
    
	@Override
	public boolean idPromocionDisponible(String idPromocion) {
		this.dtP = new DTMinPromocion(this.nicknameP, idPromocion);
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.idPromocionDisponible(idPromocion, this.nicknameP);
	}

	@Override
	public void altaPromocion(float descuento) {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		manejadorP.altaPromocion(this.dtP.getIdPromocion(), descuento, this.dtP.getNicknameP(), this.listaServicios);
	}

    @Override
    public RankingServicios obtenerRankingServicios(){
        ManejadorProductos manejadorP = ManejadorProductos.getInstace();
        return manejadorP.obtenerRankingDeServicios();
    }
    
	public DTUbicacion getDestino() {
		return this.destino;
	}

	public DTUbicacion getOrigen() {
		return this.origen;
	}

    public DTMinPromocion getDtP() {
        return dtP;
    }

    public DTMinServicio getDtS() {
        return dtS;
    }

    public String getCategoriaPadre() {
        return categoriaPadre;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public String getNicknameP() {
        return nicknameP;
    }
    
    public Set<DTServicio> listarServiciosPorTermino(String termino){
        ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.listarServiciosPorTermino(termino);
    }
    
    public Set<DTPromocion> listarPromocionesPorTermino(String termino){
        ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.listarPromocionesPorTermino(termino);
    }
    @Override
    public void agregarAccesoAServicio(DTMinServicio dtMin) {
        ManejadorProductos manejadorP = ManejadorProductos.getInstace();
        manejadorP.agregarAccesoAServicio(dtMin);
    }
}
