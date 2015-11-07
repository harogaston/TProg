/*
 * Header Test
 */
package tprog.webservice;

import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;

/**
 *
 * @author marccio
 */
class WrapperVerPromocion {

	public Map<DTMinServicio, Integer> servicios;
	public DTPromocion promocion;
}
