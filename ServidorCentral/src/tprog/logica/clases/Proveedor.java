package tprog.logica.clases;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinProveedor;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;

public class Proveedor extends Usuario {

	private String empresa;
	private String webEmpresa;

	Map<String, Promocion> promociones;
	Map<String, Servicio> servicios;

	public Proveedor(DTProveedor dtP) {
		super(dtP.getNickname(), dtP.getPassword(), dtP.getNombre(), dtP.getApellido(), dtP.getEmail(), dtP.getImagen(), dtP.getFechaNacimiento());
		this.empresa = dtP.getEmpresa();
		this.webEmpresa = dtP.getWebEmpresa();
		this.promociones = new HashMap();
		this.servicios = new HashMap();
	}

	public DTMinProveedor crearDTMin() {
		DTMinProveedor nuevoDT = new DTMinProveedor(this.nickname, this.email, this.empresa);
		return nuevoDT;
	}

	public DTProveedor crearDT() {
		DTProveedor nuevoDT = new DTProveedor(this.nickname, this.password, this.nombre, this.apellido,
				this.email, this.imagen, this.fechaNacimiento, this.empresa, this.webEmpresa);
		return nuevoDT;
	}

	public Set<DTMinServicio> listarServicios() {
		Set<DTMinServicio> nuevoSet = new HashSet();
		for (Servicio serv : servicios.values()) {
			DTMinServicio temp = serv.crearDTMin();
			nuevoSet.add(temp);
		}
		return nuevoSet;
	}

	public Set<DTMinPromocion> listarPromociones() {
		Set<DTMinPromocion> nuevoSet = new HashSet();
		for (Promocion promo : promociones.values()) {
			DTMinPromocion temp = promo.crearDTMin();
			nuevoSet.add(temp);
		}
		return nuevoSet;
	}

	public void addServicio(Servicio service) {
		servicios.put(service.getIdServicio(), service);
	}

	public void addPromocion(Promocion promo) {
		promociones.put(promo.getIdPromocion(), promo);
	}

	public void setEmpresa(String Empresa) {
		this.empresa = Empresa;
	}

	public void setWebEmpresa(String WebEmpresa) {
		this.webEmpresa = WebEmpresa;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public String getWebEmpresa() {
		return this.webEmpresa;
	}

	public Map<String, Servicio> getServicios() {
		return this.servicios;
	}

	public Map<String, Promocion> getPromociones() {
		return this.promociones;
	}
}
