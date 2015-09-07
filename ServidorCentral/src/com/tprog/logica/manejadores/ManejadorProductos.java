/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.manejadores;

import com.tprog.logica.clases.Categoria;
import com.tprog.logica.clases.Ciudad;
import com.tprog.logica.clases.Compuesta;
import com.tprog.logica.clases.Pais;
import com.tprog.logica.clases.Promocion;
import com.tprog.logica.clases.Proveedor;
import com.tprog.logica.clases.Servicio;
import com.tprog.logica.clases.Simple;
import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTPromocion;
import com.tprog.logica.dt.DTServicio;
import com.tprog.logica.dt.DTUbicacion;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;

public class ManejadorProductos {

	private static ManejadorProductos instace = null;

	protected Map<String, Categoria> categorias;
	protected Categoria root;
	protected Map<String, Pais> ubicaciones;
	protected Map<String, Map<String, Servicio>> servicios;
	protected Map<String, Map<String, Promocion>> promociones;

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

	public Set<DTMinPromocion> listarPromociones() {
		Set<DTMinPromocion> result = new HashSet();
		if (!promociones.isEmpty()) {
			for (Map<String, Promocion> mapaPromocion : promociones.values()) {
				if (!mapaPromocion.isEmpty()) {
					for (Promocion p : mapaPromocion.values()) {
						result.add(p.crearDTMin());
					}
				}
			}
		}
		return result;
	}

	public DTPromocion infoPromocion(DTMinPromocion dtP) {
            DTPromocion result = null;
            if (!promociones.isEmpty() && promociones.containsKey(dtP.getNicknameP())) {
                if (!promociones.get(dtP.getNicknameP()).isEmpty()
                        && promociones.get(dtP.getNicknameP()).containsKey(dtP.getIdPromocion())) {
                    Promocion p = promociones.get(dtP.getNicknameP()).get(dtP.getIdPromocion());
                    result = p.crearDT();
                }
            }
            return result;
	}

	public DTServicio infoServicio(DTMinServicio dtS) {
		DTServicio result = null;
		if (!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())) {
			if (!servicios.get(dtS.getNicknameP()).isEmpty()
					&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
				Servicio s = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
				result = s.crearDT();
			}
		}
		return result;
	}

	public DefaultMutableTreeNode listarCategorias() {
		return root.listarCategorias();
	}

	public Set<DTMinServicio> listarServiciosCategoria(String cat) {
		Set<DTMinServicio> result;
		if (!categorias.isEmpty() && categorias.containsKey(cat)) {
			Categoria c = categorias.get(cat);
			result = c.listarServicios();
		} else {
			result = new HashSet();
		}
		return result;
	}

	public Set<DTMinServicio> listarServicios() {
		Set<DTMinServicio> result = new HashSet();
		if (!this.servicios.isEmpty()) {
			for (Map<String, Servicio> mapaServicio : this.servicios.values()) {
				if (!mapaServicio.isEmpty()) {
					for (Servicio s : mapaServicio.values()) {
						result.add(s.crearDTMin());
					}
				}
			}
		}
		return result;
	}

	public void cambiarPrecio(DTMinServicio dtS,
			float nuevoPrecio) {
		if (!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
				&& !servicios.get(dtS.getNicknameP()).isEmpty()
				&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
			Servicio s = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
			s.setPrecio(nuevoPrecio);
		}
	}

	public void cambiarDescripcion(DTMinServicio dtS, String descripcion) {
		if (!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
				&& !servicios.get(dtS.getNicknameP()).isEmpty()
				&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
			Servicio s = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
			s.setDescripcion(descripcion);
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
            if (!servicios.isEmpty()){
                if (servicios.containsKey(dtS.getNicknameP()) 
                        && !servicios.get(dtS.getNicknameP()).isEmpty() 
                        && servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())){
                            Servicio s = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
                            s.agregarImagen(img);
                } else {
                    throw new Exception ("El Servicio seleccionado no es válido.");
                }  
            }else{
                throw new Exception("No existen Servicios registrados en el Sistema.");
            }    
	}

	public void quitarImagen(DTMinServicio dtS, String img)  throws Exception{
            if (!servicios.isEmpty()){
                if (servicios.containsKey(dtS.getNicknameP()) 
                        && !servicios.get(dtS.getNicknameP()).isEmpty() 
                        && servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())){
                            Servicio s = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
                            s.quitarImagen(img);
                } else {
                    throw new Exception ("El Servicio seleccionado no es válido.");
                }        
            }else{
                throw new Exception("No existen Servicios registrados en el Sistema.");
            }
        }

	public DefaultMutableTreeNode listarCiudades() {
            DefaultMutableTreeNode result = new DefaultMutableTreeNode();
            if (!ubicaciones.isEmpty()) {
                for (Pais p : ubicaciones.values()) {
                    DefaultMutableTreeNode pais = new DefaultMutableTreeNode(p.getIdPais());
                    result.add(pais);
                    if (!p.getCiudades().isEmpty()) {
                        for (Ciudad c : p.getCiudades().values()) {
                            pais.add(new DefaultMutableTreeNode(c.getIdCiudad(), false));
                        }
                    }
                }
            }
            return result;
	}

//	public boolean agregarCategoria(String idCategoria) {
//           /* boolean result = false;
//            if (!categorias.isEmpty() && categorias.containsKey(idCategoria)){
//                Categoria cat = categorias.get(idCategoria);
//                
//            }*/
//            return true;
//	}
//
//	public boolean quitarCategoria(String idCategoria) {
//		return true;
//	}
	public void cambiarOrigen(DTMinServicio dtS, DTUbicacion dtU) {
		if (!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
				&& !servicios.get(dtS.getNicknameP()).isEmpty()
				&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
			Servicio s = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
			Pais p = ubicaciones.get(dtU.getPais());
			Ciudad c = p.getCiudades().get(dtU.getCiudad());
			s.setOrigen(c);
		}
	}

	public void cambiarDestino(DTMinServicio dtS, DTUbicacion dtU) {
		if (!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
				&& !servicios.get(dtS.getNicknameP()).isEmpty()
				&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
			Servicio s = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
			Pais p = ubicaciones.get(dtU.getPais());
			Ciudad c = p.getCiudades().get(dtU.getCiudad());
			s.setDestino(c);
		}
	}

	public Set<String> listarCategoriasServicio(DTMinServicio dtS) {
		Set<String> result = new HashSet();
		if (!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
				&& !servicios.get(dtS.getNicknameP()).isEmpty()
				&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
			Servicio s = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
			result = s.listarCategorias();
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
			Categoria c = categorias.get(cat);
			result = c.esCategoriaSimple();
			if (result && !servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
					&& !servicios.get(dtS.getNicknameP()).isEmpty()
					&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
				result = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio()).agregarCategoria(c);
			}
		}
		return result;
	}

	public boolean esCategoriaSimpleQuitar(DTMinServicio dtS, String cat) {
		boolean result = false;
		if (!categorias.isEmpty() && categorias.containsKey(cat)) {
			Categoria c = categorias.get(cat);
			result = c.esCategoriaSimple();
			if (result && !servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())
					&& !servicios.get(dtS.getNicknameP()).isEmpty()
					&& servicios.get(dtS.getNicknameP()).containsKey(dtS.getIdServicio())) {
				result = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio()).quitarCategoria(c);
			}
		}
		return result;
	}

	public boolean idCategoriaDisponible(String idCategoria) {
		return (categorias.isEmpty() || !categorias.containsKey(idCategoria));
	}

	public void altaCategoria(String idCategoria, String idPadre) {
		Categoria c = new Simple(idCategoria);
		categorias.put(idCategoria, c);
		if (idPadre == null) {
			idPadre = "Categorias";
		}
		if (!categorias.isEmpty() && categorias.containsKey(idPadre)) {
			Categoria padre = categorias.get(idPadre);
			if (!padre.esCategoriaSimple()) {
				Compuesta padreC = (Compuesta) padre;
				padreC.add(c);
			} else {
				categorias.remove(idPadre);
				Compuesta nuevoPadre = new Compuesta(idPadre);
				nuevoPadre.add(c);
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
			Categoria c = categorias.get(cat);
			result = c.esCategoriaSimple();
		}
		return result;
	}

	public void altaServicio(DTServicio dtS, String nicknameP, Set<String> listaCategorias) {
		ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
		Proveedor prov = mu.getProveedor(nicknameP);
		Pais paisOrigen = ubicaciones.get(dtS.getOrigen().getPais());
		Ciudad ciudadOrigen = paisOrigen.getCiudades().get(dtS.getOrigen().getCiudad());
		Servicio s;
		if (dtS.getDestino() != null) {
			Pais paisDestino = ubicaciones.get(dtS.getDestino().getPais());
			Ciudad ciudadDestino = paisDestino.getCiudades().get(dtS.getDestino().getCiudad());
			s = new Servicio(dtS.getIdServicio(), dtS.getDescripcion(), dtS.getPrecio(), dtS.getImagenes(), ciudadOrigen, ciudadDestino, prov);
		} else {
			s = new Servicio(dtS.getIdServicio(), dtS.getDescripcion(), dtS.getPrecio(), dtS.getImagenes(), ciudadOrigen, null, prov);
		}
		if (!this.servicios.containsKey(nicknameP)) {
			servicios.put(nicknameP, new HashMap<String, Servicio>());
		}
		this.servicios.get(nicknameP).put(dtS.getIdServicio(), s);
		prov.addServicio(s);
		for (String idCategoria : listaCategorias) {
			if (!categorias.isEmpty() && categorias.containsKey(idCategoria)) {
				boolean success = s.agregarCategoria(categorias.get(idCategoria));
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
                Set<String> servicios) {
            ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
            Proveedor proveedor = mu.getProveedor(nicknameProv);
            Promocion promo = new Promocion(idPromocion, descuento, proveedor);
            if(!promociones.containsKey(nicknameProv)){
                promociones.put(nicknameProv, new HashMap());
            }
            this.promociones.get(nicknameProv).put(idPromocion, promo);
            Iterator<String> it = servicios.iterator();
            proveedor.addPromocion(promo);
            while (it.hasNext()) {
                String l = (String) it.next();
                Servicio temp = this.servicios.get(nicknameProv).get(l);
                promo.addServicio(temp);
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
            if (dtMinP != null && !promociones.isEmpty() && 
                    promociones.containsKey(dtMinP.getNicknameP()) &&
                    !promociones.get(dtMinP.getNicknameP()).isEmpty() &&
                    promociones.get(dtMinP.getNicknameP()).containsKey(dtMinP.getIdPromocion())) {
                    return promociones.get(dtMinP.getNicknameP()).get(dtMinP.getIdPromocion());
            } else {
                return null;
            } 
	}

	public void agregarPais(Pais p) {
		this.ubicaciones.put(p.getIdPais(), p);
	}

}
