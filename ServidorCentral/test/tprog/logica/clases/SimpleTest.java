package tprog.logica.clases;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;

public class SimpleTest {

	Simple instance;

	public SimpleTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		instance = new Simple("idCategoria", null);
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of agregarServicio method, of class Simple.
	 */
	@Test
	public void testAgregarServicio() {
		System.out.println("agregarServicio");
		Servicio servicio = null;
		instance.agregarServicio(servicio);
		assertTrue(instance.getServicios().contains(null));
	}

	/**
	 * Test of quitarServicio method, of class Simple.
	 */
	@Test
	public void testQuitarServicio() {
		System.out.println("quitarServicio");
		Servicio servicio = null;

		instance.quitarServicio(servicio);
		// TODO review the generated test code and remove the default call to fail.
		assertFalse(instance.getServicios().contains(servicio));
	}

	/**
	 * Test of getIdCategoria method, of class Simple.
	 */
	@Test
	public void testGetIdCategoria() {
		System.out.println("getIdCategoria");
		String expResult = "idCategoria";
		String result = instance.getIdCategoria();
		assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of getServicios method, of class Simple.
	 */
	@Test
	public void testGetServicios() {
		System.out.println("getServicios");
		Set<Servicio> expResult = new HashSet();
		Set<Servicio> result = instance.getServicios();
		assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of getPadre method, of class Simple.
	 */
	@Test
	public void testGetPadre() {
		System.out.println("getPadre");
		Compuesta expResult = null;
		Compuesta result = instance.getPadre();
		assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of setPadre method, of class Simple.
	 */
	@Test
	public void testSetPadre() {
		System.out.println("setPadre");
		Compuesta padre = new Compuesta("padre");
		instance.setPadre(padre);

	}

	/**
	 * Test of listarServicios method, of class Simple.
	 */
	@Test
	public void testListarServicios() {
		System.out.println("listarServicios");
		Date fecha = new Date();
		DTProveedor dtP = new DTProveedor("nick", "pass", "nom", "ap", "email",
				"imagen", fecha, "empresa", "webEmpresa");
		Proveedor prov = new Proveedor(dtP);
		Servicio ser = new Servicio("idServicio", "descripcion", 50, null, null, null, prov);
		instance.agregarServicio(ser);
		Set<DTMinServicio> expResult = new HashSet();
		DTMinServicio nuevo = new DTMinServicio("nick", "idServicio");
		expResult.add(nuevo);
		Set<DTMinServicio> result = instance.listarServicios();
		assertEquals(expResult.toString(), result.toString());

	}

	/**
	 * Test of esCategoriaSimple method, of class Simple.
	 */
	@Test
	public void testEsCategoriaSimple() {
		System.out.println("esCategoriaSimple");
		boolean expResult = true;
		boolean result = instance.esCategoriaSimple();
		assertEquals(expResult, result);
	}

	/**
	 * Test of esCategoriaPadre method, of class Simple.
	 */
	@Test
	public void testEsCategoriaPadre() {
		System.out.println("esCategoriaPadre");
		boolean expResult = true;
		boolean result = instance.esCategoriaPadre();
		assertEquals(expResult, result);
	}

	/**
	 * Test of listarCategorias method, of class Simple.
	 */
	@Test
	public void testListarCategorias() {
		System.out.println("listarCategorias");
		assertTrue(instance.listarCategorias().isLeaf());
		assertFalse(instance.listarCategorias().getAllowsChildren());

	}

}
