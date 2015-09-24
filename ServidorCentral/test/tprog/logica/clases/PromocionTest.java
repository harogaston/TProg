package tprog.logica.clases;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.dt.DTProveedor;

public class PromocionTest {

	Promocion instance;
	Map<String, Integer> servicios;
	HashMap<DTMinServicio, Integer> set;
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
		DTProveedor dtP = new DTProveedor("pepito", "pass", "pedro", "elescamoso", "lalala@fing.edu.uy", "/image.gg", fecha, "montecudine", "www.montecudine.com");
		proveedor = new Proveedor(dtP);
		Promocion prooo;

		Servicio servicio1 = new Servicio("ser1", "bueno", 50, new HashSet(), null, null, proveedor);

		Servicio servicio2 = new Servicio("ser2", "malo", 400, null, null, null, proveedor);

		set = new HashMap<>();
		set.put(new DTMinServicio("pepito", "ser1"), 1);
		set.put(new DTMinServicio("pepito", "ser2"), 1);

		servicios = new HashMap<>();
		prooo = new Promocion("Promo", 20, proveedor);
		prooo.agregarServicio(servicio1);
		prooo.agregarServicio(servicio2);
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

		DTPromocion expResult = new DTPromocion("Promo", 20, 360, set);
		DTPromocion result = instance.crearDT();

		assertEquals(expResult.toString(), result.toString());

	}

	/**
	 * Test of agregarServicio method, of class Promocion.
	 */
	@Test
	public void testAddServicio() {
		System.out.println("addServicio");

		Servicio servicio3 = new Servicio("ser3", "malote", 220, null, null, null, proveedor);
		instance.agregarServicio(servicio3);
		assertTrue(instance.getServicios().containsKey("ser3"));
		Integer cant = 0;
		for (Map.Entry<String, Integer> par : instance.getServicios().entrySet()) {
			if (par.getKey().equals("ser3")) {
				cant = par.getValue();
			}
		}
		assertEquals((Integer) 1, cant);
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
		DTProveedor dtP = new DTProveedor("ElNuevo", "pass", "nuevo", "elescamoso", "lalala@fing.edu.uy",
				"/image.gg", fecha, "montecudine", "www.montecudine.com");
		Proveedor prov = new Proveedor(dtP);

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

		float expResult = 20;
		float result = instance.getDescuento();
		assertEquals(expResult, result, 0.0);
	}

	/**
	 * Test of getTotal method, of class Promocion.
	 */
	@Test
	public void testGetTotal() {
		System.out.println("getTotal");

		float expResult = 360;
		float result = instance.getTotal();
		assertEquals(expResult, result, 0.0);
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
	}

}
