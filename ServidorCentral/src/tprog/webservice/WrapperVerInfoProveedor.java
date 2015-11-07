/*
 * Header Test
 */
package tprog.webservice;

import java.util.Map;
import tprog.logica.dt.DTPromocion;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTServicio;

/**
 *
 * @author marccio
 */
public class WrapperVerInfoProveedor {

	public DTProveedor proveedor;
	//map de dt con su representacion en string
	public Map<DTServicio, String> servicios;
	public Map<DTPromocion, String> promociones;
}
