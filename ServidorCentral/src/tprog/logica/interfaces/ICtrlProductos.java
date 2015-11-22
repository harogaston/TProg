package tprog.logica.interfaces;

import java.util.ArrayList;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import tprog.logica.clases.ItemRanking;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUbicacion;

public interface ICtrlProductos {

	public DTMinServicio infoMinServicio();

	public DTMinPromocion infoMinPromocion();

	public Set<DTMinPromocion> listarPromociones() throws Exception;

	public void seleccionarPromocion(DTMinPromocion dtP);

	public DTPromocion infoPromocion();

	public void seleccionarServicio(DTMinServicio dtS);

	public DTServicio infoServicio();

	public DefaultMutableTreeNode listarCategorias();

	public Set<DTMinServicio> listarServiciosCategoria(String idCategoria);

	public Set<DTMinServicio> listarServicios() throws Exception;

	public void cambiarPrecio(float nuevoPrecio);

	public void cambiarDescripcion(String nuevaDescripcion);

	public Set<String> listarImagenes();

	public void agregarImagen(String idImagen) throws Exception;

	public void quitarImagen(String idImagen) throws Exception;

	public DefaultMutableTreeNode listarCiudades();

	public void cambiarOrigen(DTUbicacion origen);

	public void cambiarDestino(DTUbicacion destino);

	public Set<String> listarCategoriasServicio();

	public boolean agregarCategoria(String idCategoria);

	public boolean quitarCategoria(String idCategoria);

	public boolean seleccionarCategoriaPadre(String padre);

	public boolean idCategoriaDisponible(String idCategoria);

	public void altaCategoria();

	public void seleccionarProveedor(String nickname);

	public boolean idServicioDisponible(String idServicio);

	public void seleccionarOrigen(DTUbicacion origen);

	public void seleccionarDestino(DTUbicacion destino);

	public boolean seleccionarCategoriaSimple(String idCategoria);

	public void quitarCategoriaListada(String idCategoria);

	public void altaServicio(String descripcion, float precio, Set<String> imagenes);

	public void agregarServicio(DTMinServicio dtS);

	public boolean idPromocionDisponible(String idPromocion);

	public void altaPromocion(float descuento);
    
    public Set<DTServicio> listarServiciosPorTermino(String termino);
    
    public Set<DTPromocion> listarPromocionesPorTermino(String termino);

    public ArrayList<ItemRanking> obtenerRankingServicios();

    public void agregarAccesoAServicio(DTMinServicio dtMin);
}
