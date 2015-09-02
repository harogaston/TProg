/*
 * Header Test
 */
package com.tprog.logica.clases;

import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinProveedor;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTProveedor;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProveedorTest {
	
	public ProveedorTest() {
	}
	
	@Before
	public void setUp() {
	}

	@Test
	public void testCrearDTMin() {
		System.out.println("crearDTMin");
		Proveedor instance = null;
		DTMinProveedor expResult = null;
		DTMinProveedor result = instance.crearDTMin();
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testCrearDT() {
		System.out.println("crearDT");
		Proveedor instance = null;
		DTProveedor expResult = null;
		DTProveedor result = instance.crearDT();
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testListarServicios() {
		System.out.println("listarServicios");
		Proveedor instance = null;
		Set<DTMinServicio> expResult = null;
		Set<DTMinServicio> result = instance.listarServicios();
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testListarPromociones() {
		System.out.println("listarPromociones");
		Proveedor instance = null;
		Set<DTMinPromocion> expResult = null;
		Set<DTMinPromocion> result = instance.listarPromociones();
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAddServicio() {
		System.out.println("addServicio");
		Servicio s = null;
		Proveedor instance = null;
		instance.addServicio(s);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAddPromocion() {
		System.out.println("addPromocion");
		Promocion p = null;
		Proveedor instance = null;
		instance.addPromocion(p);
		fail("The test case is a prototype.");
	}

	@Test
	public void testSetEmpresa() {
		System.out.println("setEmpresa");
		String empresa = "";
		Proveedor instance = null;
		instance.setEmpresa(empresa);
		fail("The test case is a prototype.");
	}

	@Test
	public void testSetWebEmpresa() {
		System.out.println("setWebEmpresa");
		String webEmpresa = "";
		Proveedor instance = null;
		instance.setWebEmpresa(webEmpresa);
		fail("The test case is a prototype.");
	}

	@Test
	public void testGetEmpresa() {
		System.out.println("getEmpresa");
		Proveedor instance = null;
		String expResult = "";
		String result = instance.getEmpresa();
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testGetWebEmpresa() {
		System.out.println("getWebEmpresa");
		Proveedor instance = null;
		String expResult = "";
		String result = instance.getWebEmpresa();
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}
	
}
