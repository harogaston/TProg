package tprog.logica.manejadores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import tprog.logica.clases.Categoria;
import tprog.logica.clases.Ciudad;
import tprog.logica.clases.Compuesta;
import tprog.logica.clases.Pais;
import tprog.logica.clases.Promocion;
import tprog.logica.clases.Proveedor;
import tprog.logica.clases.Servicio;
import tprog.logica.clases.Simple;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUbicacion;

public class ManejadorProductos {

	private static ManejadorProductos instace = null;

	private Map<String, Categoria> categorias;
	private Categoria root;
	private Map<String, Pais> ubicaciones;
	private Map<String, Map<String, Servicio>> servicios;
	private Map<String, Map<String, Promocion>> promociones;

	private ManejadorProductos() {
		categorias = new HashMap();
		servicios = new HashMap();
		promociones = new HashMap();
		ubicaciones = new HashMap();
		root = new Simple("Categorias");
		categorias.put(root.getIdCategoria(), root);
	}

	public static ManejadorProductos getInstance() {
		if (instace == null) {
			instace = new ManejadorProductos();
		}
		return instace;
	}

	public Set<DTMinPromocion> listarPromociones() throws Exception {
		Set<DTMinPromocion> result = new HashSet();
		if (!promociones.isEmpty()) {
			for (Map<String, Promocion> mapaPromocion : promociones.values()) {
				if (!mapaPromocion.isEmpty()) {
					for (Promocion p : mapaPromocion.values()) {
						result.add(p.crearDTMin());
					}
				}
			}
			return result;
		} else {
			throw new Exception("No hay Promociones en el Sistema.");
		}
	}

	public DTPromocion infoPromocion(DTMinPromocion dtP) {
		DTPromocion result = null;
		if ((!promociones.isEmpty() && promociones.containsKey(dtP.getNicknameP())) 
                        && ((!promociones.get(dtP.getNicknameP()).isEmpty()
					&& promociones.get(dtP.getNicknameP()).containsKey(dtP.getIdPromocion())))) {
				Promocion promo = promociones.get(dtP.getNicknameP()).get(dtP.getIdPromocion());
				result = promo.crearDT();
			}
		
		return result;
	}

	public DTServicio infoServicio(DTMinServicio dtS) {
		DTServicio result = null;
		if ((!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())) 
			&& ((!servicios.get(dtS.getNicknameP()).isEmpty()
					&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())))) {
				Servicio service = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
				result = service.crearDT();
			}
		
		return result;
	}

	public DefaultMutableTreeNode listarCategorias() {
		return root.listarCategorias();
	}

	public Set<DTMinServicio> listarServiciosCategoria(String cat) {
		Set<DTMinServicio> result;
		if (!categorias.isEmpty() && categorias.containsKey(cat)) {
			Categoria categoria = categorias.get(cat);
			result = categoria.listarServicios();
		} else {
			result = new HashSet();
		}
		return result;
	}

	public Set<DTMinServicio> listarServicios() throws Exception {
		Set<DTMinServicio> result = new HashSet();
		if (!this.servicios.isEmpty()) {
			for (Map<String, Servicio> mapaServicio : this.servicios.values()) {
				if (!mapaServicio.isEmpty()) {
					for (Servicio s : mapaServicio.values()) {
						result.add(s.crearDTMin());
					}
				}
			}
			return result;
		} else {
			throw new Exception("No hay Servicios en el Sistema.");
		}

	}

	public void cambiarPrecio(DTMinServicio dtS,
			float nuevoPrecio) {
		if (!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
				&& !servicios.get(dtS.getNicknameP()).isEmpty()
				&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
			Servicio service = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
			service.setPrecio(nuevoPrecio);
		}
	}

	public void cambiarDescripcion(DTMinServicio dtS, String descripcion) {
		if (!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
				&& !servicios.get(dtS.getNicknameP()).isEmpty()
				&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
			Servicio service = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
			service.setDescripcion(descripcion);
		}
	}

	public Set<String> listarImagenes(DTMinServicio dtS) {
		Set<String> result = new HashSet();
		if (!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
				&& !servicios.get(dtS.getNicknameP()).isEmpty()
				&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
			result = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio()).listarImagenes();
		}
		return result;
	}

	public void agregarImagen(DTMinServicio dtS, String img) throws Exception {
		if (!servicios.isEmpty()) {
			if (servicios.containsKey(dtS.getNicknameP())
					&& !servicios.get(dtS.getNicknameP()).isEmpty()
					&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
				Servicio service = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
				service.agregarImagen(img);
			} else {
				throw new Exception("El Servicio seleccionado no es válido.");
			}
		} else {
			throw new Exception("No existen Servicios registrados en el Sistema.");
		}
	}

	public void quitarImagen(DTMinServicio dtS, String img) throws Exception {
		if (!servicios.isEmpty()) {
			if (servicios.containsKey(dtS.getNicknameP())
					&& !servicios.get(dtS.getNicknameP()).isEmpty()
					&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
				Servicio service = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
				service.quitarImagen(img);
			} else {
				throw new Exception("El Servicio seleccionado no es válido.");
			}
		} else {
			throw new Exception("No existen Servicios registrados en el Sistema.");
		}
	}

	public DefaultMutableTreeNode listarCiudades() {
		DefaultMutableTreeNode result = new DefaultMutableTreeNode();
		if (!ubicaciones.isEmpty()) {
			for (Pais iterP : ubicaciones.values()) {
				DefaultMutableTreeNode pais = new DefaultMutableTreeNode(iterP.getIdPais());
				result.add(pais);
				if (!iterP.getCiudades().isEmpty()) {
					for (Ciudad ciudad : iterP.getCiudades().values()) {
						pais.add(new DefaultMutableTreeNode(ciudad.getIdCiudad(), false));
					}
				}
			}
		}
		return result;
	}

	public void cambiarOrigen(DTMinServicio dtS, DTUbicacion dtU) {
		if (!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
				&& !servicios.get(dtS.getNicknameP()).isEmpty()
				&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
			Servicio service = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
			Pais pais = ubicaciones.get(dtU.getPais());
			Ciudad ciudad = pais.getCiudades().get(dtU.getCiudad());
			service.setOrigen(ciudad);
		}
	}

	public void cambiarDestino(DTMinServicio dtS, DTUbicacion dtU) {
		if (!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
				&& !servicios.get(dtS.getNicknameP()).isEmpty()
				&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
			Servicio service = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
			Pais pais = ubicaciones.get(dtU.getPais());
			Ciudad ciudad = pais.getCiudades().get(dtU.getCiudad());
			service.setDestino(ciudad);
		}
	}

	public Set<String> listarCategoriasServicio(DTMinServicio dtS) {
		Set<String> result = new HashSet();
		if (!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
				&& !servicios.get(dtS.getNicknameP()).isEmpty()
				&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
			Servicio service = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
			result = service.listarCategorias();
		}
		return result;
	}

	public boolean esCategoriaPadre(String idCategoria) {
		boolean result = false;
		if (!categorias.isEmpty() && categorias.containsKey(idCategoria)) {
			Categoria padre = categorias.get(idCategoria);
			result = padre.esCategoriaPadre();
		}
		return result;
	}

	public boolean esCategoriaSimpleAgregar(DTMinServicio dtS, String cat) {
		boolean result = false;
		if (!categorias.isEmpty() && categorias.containsKey(cat)) {
			Categoria categoria = categorias.get(cat);
			result = categoria.esCategoriaSimple();
			if (result && !servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
					&& !servicios.get(dtS.getNicknameP()).isEmpty()
					&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
				result = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio()).agregarCategoria(categoria);
			}
		}
		return result;
	}

	public boolean esCategoriaSimpleQuitar(DTMinServicio dtS, String cat) {
		boolean result = false;
		if (!categorias.isEmpty() && categorias.containsKey(cat)) {
			Categoria categoria = categorias.get(cat);
			result = categoria.esCategoriaSimple();
			if (result && !servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
					&& !servicios.get(dtS.getNicknameP()).isEmpty()
					&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
				result = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio()).quitarCategoria(categoria);
			}
		}
		return result;
	}

	public boolean idCategoriaDisponible(String idCategoria) {
		return (categorias.isEmpty() || !categorias.containsKey(idCategoria));
	}

	public void altaCategoria(String idCategoria, String idPadre) {
		Categoria cat = new Simple(idCategoria);
		categorias.put(idCategoria, cat);
		if (idPadre == null) {
			idPadre = "Categorias";
		}
		if (!categorias.isEmpty() && categorias.containsKey(idPadre)) {
			Categoria padre = categorias.get(idPadre);
			if (!padre.esCategoriaSimple()) {
				Compuesta padreC = (Compuesta) padre;
				padreC.add(cat);
			} else {
				categorias.remove(idPadre);
				Compuesta nuevoPadre = new Compuesta(idPadre);
				nuevoPadre.add(cat);
				categorias.put(idPadre, nuevoPadre);
				if (idPadre.equals("Categorias")) {
					root = nuevoPadre;
				} else {
					Compuesta abuelo = padre.getPadre();
					abuelo.add(nuevoPadre);
					abuelo.remove(padre);
				}
			}
		}
	}

	public boolean idServicioDisponible(String idServicio, String nicknameP) {
		boolean result = true;
		if (!servicios.isEmpty() && servicios.containsKey(nicknameP)
				&& !servicios.get(nicknameP).isEmpty()
				&& servicios.get(nicknameP).containsKey(idServicio)) {
			result = false;
		}
		return result;
	}

	public boolean esCategoriaSimple(String cat) {
		boolean result = false;
		if (!categorias.isEmpty() && categorias.containsKey(cat)) {
			Categoria categoria = categorias.get(cat);
			result = categoria.esCategoriaSimple();
		}
		return result;
	}

	public void altaServicio(DTServicio dtS, String nicknameP, Set<String> listaCategorias) {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		Proveedor prov = manejadorU.getProveedor(nicknameP);
		Pais paisOrigen = ubicaciones.get(dtS.getOrigen().getPais());
		Ciudad ciudadOrigen = paisOrigen.getCiudades().get(dtS.getOrigen().getCiudad());
		Servicio servicio;
		if (dtS.getDestino() != null) {
			Pais paisDestino = ubicaciones.get(dtS.getDestino().getPais());
			Ciudad ciudadDestino = paisDestino.getCiudades().get(dtS.getDestino().getCiudad());
			servicio = new Servicio(dtS.getIdServicio(), dtS.getDescripcion(), dtS.getPrecio(), dtS.getImagenes(), ciudadOrigen, ciudadDestino, prov);
		} else {
			servicio = new Servicio(dtS.getIdServicio(), dtS.getDescripcion(), dtS.getPrecio(), dtS.getImagenes(), ciudadOrigen, null, prov);
		}
		if (!this.servicios.containsKey(nicknameP)) {
			servicios.put(nicknameP, new HashMap<String, Servicio>());
		}
		this.servicios.get(nicknameP).put(dtS.getIdServicio(), servicio);
		prov.addServicio(servicio);
		for (String idCategoria : listaCategorias) {
			if (!categorias.isEmpty() && categorias.containsKey(idCategoria)) {
				servicio.agregarCategoria(categorias.get(idCategoria));
			}
		}
	}

	public boolean idPromocionDisponible(String idPromocion, String nicknameProv) {
		boolean result = true;
		if (!promociones.isEmpty() && promociones.containsKey(nicknameProv)
				&& !promociones.get(nicknameProv).isEmpty()
				&& promociones.get(nicknameProv).containsKey(idPromocion)) {
			result = false;
		}
		return result;
	}

	public void altaPromocion(String idPromocion, float descuento, String nicknameProv,
			List<String> Servicios) {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		Proveedor proveedor = manejadorU.getProveedor(nicknameProv);
		Promocion promo = new Promocion(idPromocion, descuento, proveedor);
		if (!promociones.containsKey(nicknameProv)) {
			promociones.put(nicknameProv, new HashMap());
		}
		this.promociones.get(nicknameProv).put(idPromocion, promo);
		Iterator<String> iterador = Servicios.iterator();
		proveedor.addPromocion(promo);
		while (iterador.hasNext()) {
			String siguiente = (String) iterador.next();
			Servicio temp = this.servicios.get(nicknameProv).get(siguiente);
			promo.agregarServicio(temp);
		}
	}

	public float getPrecioPromocion(DTMinPromocion dtP) {
		Promocion promo = this.promociones.get(dtP.getNicknameP()).get(dtP.getIdPromocion());
		return promo.getTotal();
	}

	public float getPrecioServicio(DTMinServicio dtS) {
		Servicio ser = this.servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
		return ser.getPrecio();
	}

	public Servicio getServicio(DTMinServicio dtMinS) {
		if (dtMinS != null) {
			Map<String, Servicio> aux = servicios.get(dtMinS.getNicknameP());
			if (aux != null) {
				return aux.get(dtMinS.getIdServicio());
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	public Promocion getPromocion(DTMinPromocion dtMinP) {
		if (dtMinP != null && !promociones.isEmpty()
				&& promociones.containsKey(dtMinP.getNicknameP())
				&& !promociones.get(dtMinP.getNicknameP()).isEmpty()
				&& promociones.get(dtMinP.getNicknameP()).containsKey(dtMinP.getIdPromocion())) {
			return promociones.get(dtMinP.getNicknameP()).get(dtMinP.getIdPromocion());
		} else {
			return null;
		}
	}

	public void agregarPais(Pais pais) {
		this.ubicaciones.put(pais.getIdPais(), pais);
	}

    public Map<String, Categoria> getCategorias() {
        return categorias;
    }

    public Map<String, Pais> getUbicaciones() {
        return ubicaciones;
    }

    public Map<String, Map<String, Servicio>> getServicios() {
        return servicios;
    }

    public Map<String, Map<String, Promocion>> getPromociones() {
        return promociones;
    }

    public static ManejadorProductos getInstace() {
        return instace;
    }

    public Categoria getRoot() {
        return root;
    }

    public void setCategorias(Map<String, Categoria> categorias) {
        this.categorias = categorias;
    }

    public void setRoot(Categoria root) {
        this.root = root;
    }

    public void setServicios(Map<String, Map<String, Servicio>> servicios) {
        this.servicios = servicios;
    }

    public void setPromociones(Map<String, Map<String, Promocion>> promociones) {
        this.promociones = promociones;
    }

    public void setUbicaciones(Map<String, Pais> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
        
}
