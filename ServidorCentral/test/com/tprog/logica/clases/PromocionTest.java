/*
 * Header Test
 */
package com.tprog.logica.clases;

import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTPromocion;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PromocionTest {

	Promocion instance;
	Map<String, Servicio> servicios;
	Set<DTMinServicio> set;
	Proveedor proveedor;
	Date fecha;
	float total;

	public PromocionTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		fecha = new Date();
		proveedor = new Proveedor("pepito", "pedro", "elescamoso", "lalala@fing.edu.uy",
			"/image.gg", fecha, "montecudine", "www.montecudine.com");
		Promocion prooo;
		set = new HashSet();
		Servicio servicio1 = new Servicio("ser1", "bueno", 50, null, null, null, proveedor);
		DTMinServicio ser1 = new DTMinServicio("pepito", "ser1");
		Servicio servicio2 = new Servicio("ser2", "malo", 400, null, null, null, proveedor);
		DTMinServicio ser2 = new DTMinServicio("pepito", "ser2");

		servicios = new HashMap();
		prooo = new Promocion("Promo", 50, proveedor);
		prooo.addServicio(servicio1);
		set.add(ser1);
		prooo.addServicio(servicio2);
		set.add(ser2);
		instance = prooo;
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of crearDTMin method, of class Promocion.
	 */
	@Test
	public void testCrearDTMin() {
		System.out.println("crearDTMin");

		DTMinPromocion expResult = new DTMinPromocion("pepito", "Promo");
		DTMinPromocion result = instance.crearDTMin();
		assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of crearDT method, of class Promocion.
	 */
	@Test
	public void testCrearDT() {
		System.out.println("crearDT");

		DTPromocion expResult = new DTPromocion("Promo", 20, total, set);
		DTPromocion result = instance.crearDT();

		assertEquals(result.toString(), result.toString()); ///
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of addServicio method, of class Promocion.
	 */
	@Test
	public void testAddServicio() {
		System.out.println("addServicio");

		Servicio servicio3 = new Servicio("ser3", "malote", 220, null, null, null, proveedor);
		instance.addServicio(servicio3);
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of setIdPromocion method, of class Promocion.
	 */
	@Test
	public void testSetIdPromocion() {
		System.out.println("setIdPromocion");
		String idPromocion = "";

		instance.setIdPromocion(idPromocion);
		// TODO review the generated test code and remove the default call to fail.
		assertEquals("", instance.getIdPromocion());
	}

	/**
	 * Test of setDescuento method, of class Promocion.
	 */
	@Test
	public void testSetDescuento() {
		System.out.println("setDescuento");
		float descuento = 80;

		instance.setDescuento(descuento);
		// TODO review the generated test code and remove the default call to fail.
		assertEquals(80, instance.getDescuento(), 0.0);
	}

	/**
	 * Test of setProveedor method, of class Promocion.
	 */
	@Test
	public void testSetProveedor() {
		System.out.println("setProveedor");
		Proveedor prov = new Proveedor("ElNuevo", "nuevo", "elescamoso", "lalala@fing.edu.uy",
			"/image.gg", fecha, "montecudine", "www.montecudine.com");;

		instance.setProveedor(prov);
		// TODO review the generated test code and remove the default call to fail.
		assertEquals(prov, instance.getProveedor());
	}

	/**
	 * Test of getIdPromocion method, of class Promocion.
	 */
	@Test
	public void testGetIdPromocion() {
		System.out.println("getIdPromocion");

		String expResult = "Promo";
		String result = instance.getIdPromocion();
		assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of getDescuento method, of class Promocion.
	 */
	@Test
	public void testGetDescuento() {
		System.out.println("getDescuento");

		float expResult = 50;
		float result = instance.getDescuento();
		assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of getTotal method, of class Promocion.
	 */
	@Test
	public void testGetTotal() {
		System.out.println("getTotal");

		float expResult = 225;
		float result = instance.getTotal();
		assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of getNicknameProveedor method, of class Promocion.
	 */
	@Test
	public void testGetNicknameProveedor() {
		System.out.println("getNicknameProveedor");

		String expResult = "pepito";
		String result = instance.getNicknameProveedor();
		assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

	}

}
