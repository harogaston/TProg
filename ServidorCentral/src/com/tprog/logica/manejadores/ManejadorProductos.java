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

	private Map<String, Categoria> categorias;
	private Categoria root;
	private Map<String, Pais> ubicaciones;
	private Map<String, Map<String, Servicio>> servicios;
	private Map<String, Map<String, Promocion>> promociones;

	protected ManejadorProductos() {
		categorias = new HashMap();
		servicios = new HashMap();
		promociones = new HashMap();
		ubicaciones = new HashMap();
		root = new Simple("Categorias");
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
					&& !promociones.get(dtP.getIdPromocion()).containsKey(dtP.getIdPromocion())) {
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
					&& !servicios.get(dtS.getIdServicio()).containsKey(dtS.getIdServicio())) {
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

	public Set<String> listarImagenes(String nicknameP, String idServicio) {
		return null;
	}

	public void agregarImagen(DTMinServicio dtS, String img) {
	}

	public void quitarImagen(DTMinServicio dtS, String img) {
	}

	public Set<DTUbicacion> listarCiudades() {
		return null;
	}

	public boolean agregarCategoria(String idCategoria) {
		return true;
	}

	public boolean quitarCategoria(String idCategoria) {
		return true;
	}

	public void cambiarOrigen(DTMinServicio dtS, DTUbicacion dtU) {
	}

	public void cambiarDestino(DTMinServicio dtS, DTUbicacion dtU) {
	}

	public Set<String> listarCategoriasServicio(DTMinServicio dtS) {
		return null;
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
		return true;
	}

	public boolean esCategoriaSimpleQuitar(DTMinServicio dtS, String cat) {
		return true;
	}

	public boolean idCategoriaDisponible(String idCategoria) {
		return (!categorias.isEmpty() && !categorias.containsKey(idCategoria));
	}

	public void altaCategoria(String idCategoria, String idPadre) {
		Categoria c = new Simple(idCategoria);
		categorias.put(idCategoria, c);
		if (idPadre == "") {
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
				if (idPadre == "Categorias") {
					root = nuevoPadre;
				} else {
					Compuesta abuelo = padre.getPadre();
					abuelo.add(nuevoPadre);
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
                Pais paisOrigen = new Pais(dtS.getOrigen().getPais());
                Ciudad ciudadOrigen = new Ciudad(dtS.getOrigen().getCiudad());
                boolean tienedestino;
                Servicio s;
                tienedestino = (dtS.getDestino().getCiudad() != null);
                if ( tienedestino){
                    Pais paisDestino = new Pais(dtS.getDestino().getPais());
                    Ciudad ciudadDestino = new Ciudad(dtS.getDestino().getCiudad());
                    s = new Servicio(dtS.getIdServicio(),dtS.getDescripcion(),dtS.getPrecio(),dtS.getImagenes(),ciudadOrigen,ciudadDestino,prov);
                }else{
                    s = new Servicio(dtS.getIdServicio(),dtS.getDescripcion(),dtS.getPrecio(),dtS.getImagenes(),ciudadOrigen,null,prov);
                }
                this.servicios.get(nicknameP).put(dtS.getIdServicio(),s); //tema del orden igual q en altaPromocion
                prov.addServicio(s);
                ///
                /// falta la parte de categoria
                
                
	}

	public void agregarServicio(String idServicio) {
	}

	public boolean idPromocionDisponible(String idPromocion, String nicknameProv) {
		Promocion pro = this.promociones.get(nicknameProv).get(idPromocion);
                return (pro == null);
	}

	public void altaPromocion(String idPromocion, float descuento, String nicknameProv, Set<String> servicios){
                ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
                Proveedor proveedor = mu.getProveedor(nicknameProv);
                Promocion promo = new Promocion(idPromocion, descuento, proveedor);
                this.promociones.get(nicknameProv).put(idPromocion, promo); // tema de orden de nicknameProv y id promocion (no estoy seguro)
                Iterator<String> it = servicios.iterator();
                while (it.hasNext()){
                        String l = (String)it.next();
                        Servicio temp = this.servicios.get(nicknameProv).get(l);
                        promo.addServicio(temp);
                        proveedor.addPromocion(promo);
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
		return servicios.get(dtMinS.getNicknameP()).get(dtMinS.getIdServicio());
	}

	public Promocion getPromocion(DTMinPromocion dtMinP) {
		return promociones.get(dtMinP.getNicknameP()).get(dtMinP.getIdPromocion());
	}
        
}
