/*
 * Header Test
 */
package com.tprog.logica.clases;

import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinProveedor;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTProveedor;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class ProveedorTest {

	Date fechaN;
	Proveedor instance;
	
	public ProveedorTest() {
	}

	@Before
	public void setUp() {
		fechaN = new Date();
		instance = new Proveedor("nick", "nombre", "ap", "email", "imagen", fechaN, "empresa", "webEmpresa");
	}

	@Test
	public void testCrearDTMin() {
		System.out.println("crearDTMin");
		DTMinProveedor expResult = new DTMinProveedor("nick", "email", "empresa");
                DTMinProveedor result = instance.crearDTMin();
		assertEquals(expResult, result);
	}

	@Test
	public void testCrearDT() {
		System.out.println("crearDT");
		DTProveedor expResult = new DTProveedor("nick", "nombre", "ap", "email", "imagen", fechaN, "empresa", "webEmpresa");
                instance = new Proveedor(expResult);
		DTProveedor result = instance.crearDT();
		assertEquals(expResult, result);
	}

	@Test
	public void testListarServicios() {
		System.out.println("listarServicios");
		Set<DTMinServicio> expResult = new HashSet<>();
		Set<DTMinServicio> result = instance.listarServicios();
		assertEquals(expResult, result);
	}

	@Test
	public void testListarPromociones() {
		System.out.println("listarPromociones");
		Set<DTMinPromocion> expResult = new HashSet<>();
		Set<DTMinPromocion> result = instance.listarPromociones();
		assertEquals(expResult, result);
	}

	@Test
	public void testAddServicio() {
		System.out.println("addServicio");
		Servicio s = new Servicio("id", "desc", 123.5F, null, null, null, instance);
		instance.addServicio(s);
                assertTrue(instance.getServicios().containsKey("id"));
	}

	@Test
	public void testAddPromocion() {
		System.out.println("addPromocion");
		Promocion p = new Promocion("promo",10,null);
		instance.addPromocion(p);
                assertTrue(instance.getPromociones().containsKey("promo"));
	}

	@Test
	public void testSetEmpresa() {
		System.out.println("setEmpresa");
		String empresa = "nuevaEmpresa";
		instance.setEmpresa(empresa);
                assertEquals(empresa,instance.getEmpresa());
	}

	@Test
	public void testSetWebEmpresa() {
		System.out.println("setWebEmpresa");
		String webEmpresa = "nuevaWeb";
		instance.setWebEmpresa(webEmpresa);
                assertEquals(webEmpresa,instance.getWebEmpresa());
	}

	@Test
	public void testGetEmpresa() {
		System.out.println("getEmpresa");
		String expResult = "empresa";
		String result = instance.getEmpresa();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetWebEmpresa() {
		System.out.println("getWebEmpresa");
		String expResult = "webEmpresa";
		String result = instance.getWebEmpresa();
		assertEquals(expResult, result);
	}

}
