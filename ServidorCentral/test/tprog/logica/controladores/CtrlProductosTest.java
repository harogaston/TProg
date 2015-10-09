package tprog.logica.controladores;

import java.util.HashSet;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUbicacion;

public class CtrlProductosTest {

	CtrlProductos instance;

	public CtrlProductosTest() {
	}

	@Before
	public void setUp() {
		instance = new CtrlProductos();
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of seleccionarPromocion method, of class CtrlProductos.
	 */
	@Test
	public void testSeleccionarPromocion() {
		System.out.println("seleccionarPromocion");
		DTMinPromocion dtP = new DTMinPromocion("Rachel Morgan", "Vacations");
		instance.seleccionarPromocion(dtP);
		assertEquals(dtP.getNicknameP(), instance.dtP.getNicknameP());
		assertEquals(dtP.getIdPromocion(), instance.dtP.getIdPromocion());
	}

	/**
	 * Test of listarPromociones method, of class CtrlProductos.
	 */
	@Test
	public void testListarPromociones() throws Exception {
		System.out.println("listarPromociones");
		Set<DTMinPromocion> expResult = new HashSet();
		Set<DTMinPromocion> result = instance.listarPromociones();
		assertEquals(expResult, result);

	}

	/**
	 * Test of infoPromocion method, of class CtrlProductos.
	 */
	@Test
	public void testInfoPromocion() {
		System.out.println("infoPromocion");
		DTPromocion expResult = null;
		DTPromocion result = instance.infoPromocion();
		assertEquals(expResult, result);

	}

	/**
	 * Test of infoMinPromocion method, of class CtrlProductos.
	 */
	@Test
	public void testInfoMinPromocion() {
		System.out.println("infoMinPromocion");
		DTMinPromocion expResult = null;
		DTMinPromocion result = instance.infoMinPromocion();
		assertEquals(expResult, result);

	}

	/**
	 * Test of seleccionarServicio method, of class CtrlProductos.
	 */
	@Test
	public void testSeleccionarServicio() {
		System.out.println("seleccionarServicio");
		DTMinServicio dtS = new DTMinServicio("Rachel Morgan", "Trip to Cincy");
		instance.seleccionarServicio(dtS);
		assertEquals(dtS.getNicknameP(), instance.dtS.getNicknameP());
		assertEquals(dtS.getIdServicio(), instance.dtS.getIdServicio());
	}

	/**
	 * Test of infoServicio method, of class CtrlProductos.
	 */
	@Test
	public void testInfoServicio() {
		System.out.println("infoServicio");
		DTServicio expResult = null;
		DTServicio result = instance.infoServicio();
		assertEquals(expResult, result);

	}

	/**
	 * Test of infoMinServicio method, of class CtrlProductos.
	 */
	@Test
	public void testInfoMinServicio() {
		System.out.println("infoMinServicio");
		DTMinServicio expResult = null;
		DTMinServicio result = instance.infoMinServicio();
		assertEquals(expResult, result);

	}

	/**
	 * Test of listarCategorias method, of class CtrlProductos.
	 */
	/*@Test
	 public void testListarCategorias() {
	 System.out.println("listarCategorias");
	 CtrlProductos instance = new CtrlProductos();
	 DefaultMutableTreeNode expResult = null;
	 DefaultMutableTreeNode result = instance.listarCategorias();
	 assertEquals(expResult, result);
	 // TODO review the generated test code and remove the default call to fail.
	 fail("The test case is a prototype.");
	 }

	 /**
	 * Test of listarServiciosCategoria method, of class CtrlProductos.
	 */
	@Test
	public void testListarServiciosCategoria() {
		System.out.println("listarServiciosCategoria");
		String idCategoria = "";
		instance = new CtrlProductos();
		Set<DTMinServicio> expResult = new HashSet();
		Set<DTMinServicio> result = instance.listarServiciosCategoria(idCategoria);
		assertEquals(expResult, result);

	}

	/**
	 * Test of listarServicios method, of class CtrlProductos.
	 */
	@Test
	public void testListarServicios() throws Exception {
		System.out.println("listarServicios");
		Set<DTMinServicio> expResult = new HashSet();
		Set<DTMinServicio> result = instance.listarServicios();
		assertEquals(expResult, result);

	}

	/**
	 * Test of cambiarPrecio method, of class CtrlProductos.
	 */
	/*@Test
	 public void testCambiarPrecio() {
	 System.out.println("cambiarPrecio");
	 float nuevoPrecio = 0.0F;
	 CtrlProductos instance = new CtrlProductos();
	 instance.cambiarPrecio(nuevoPrecio);
	 // TODO review the generated test code and remove the default call to fail.
	 fail("The test case is a prototype.");
	 }

	 /**
	 * Test of cambiarDescripcion method, of class CtrlProductos.
	 */
	/*@Test
	 public void testCambiarDescripcion() {
	 System.out.println("cambiarDescripcion");
	 String descripcion = "";
	 CtrlProductos instance = new CtrlProductos();
	 instance.cambiarDescripcion(descripcion);

	 }

	 /**
	 * Test of listarImagenes method, of class CtrlProductos.
	 */
	@Test
	public void testListarImagenes() {
		System.out.println("listarImagenes");
		Set<String> expResult = new HashSet();
		Set<String> result = instance.listarImagenes();
		assertEquals(expResult, result);

	}

	/**
	 * Test of agregarImagen method, of class CtrlProductos.
	 */
	/*@Test
	 public void testAgregarImagen() throws Exception {
	 System.out.println("agregarImagen");
	 String idImagen = "";
	 CtrlProductos instance = new CtrlProductos();
	 instance.agregarImagen(idImagen);
	 // TODO review the generated test code and remove the default call to fail.
	 fail("The test case is a prototype.");
	 }

	 /**
	 * Test of quitarImagen method, of class CtrlProductos.
	 */
	/*@Test
	 public void testQuitarImagen() throws Exception {
	 System.out.println("quitarImagen");
	 String idImagen = "";
	 CtrlProductos instance = new CtrlProductos();
	 instance.quitarImagen(idImagen);
	 // TODO review the generated test code and remove the default call to fail.
	 fail("The test case is a prototype.");
	 }

	 /**
	 * Test of listarCiudades method, of class CtrlProductos.
	 */
	@Test
	public void testListarCiudades() {
		System.out.println("listarCiudades");
		instance = new CtrlProductos();
		DefaultMutableTreeNode expResult = new DefaultMutableTreeNode();
		DefaultMutableTreeNode result = instance.listarCiudades();
		assertEquals(expResult.toString(), result.toString());

	}

	/**
	 * Test of cambiarOrigen method, of class CtrlProductos.
	 */
	/*@Test
	 public void testCambiarOrigen() {
	 System.out.println("cambiarOrigen");
	 DTUbicacion dtU = null;
	 CtrlProductos instance = new CtrlProductos();
	 instance.cambiarOrigen(dtU);
	 // TODO review the generated test code and remove the default call to fail.
	 fail("The test case is a prototype.");
	 }

	 /**
	 * Test of cambiarDestino method, of class CtrlProductos.
	 */
	/*@Test
	 public void testCambiarDestino() {
	 System.out.println("cambiarDestino");
	 DTUbicacion dtU = null;
	 CtrlProductos instance = new CtrlProductos();
	 instance.cambiarDestino(dtU);
	 // TODO review the generated test code and remove the default call to fail.
	 fail("The test case is a prototype.");
	 }

	 /**
	 * Test of listarCategoriasServicio method, of class CtrlProductos.
	 */
	@Test
	public void testListarCategoriasServicio() {
		System.out.println("listarCategoriasServicio");
		Set<String> expResult = new HashSet();
		Set<String> result = instance.listarCategoriasServicio();
		assertEquals(expResult, result);

	}

	/**
	 * Test of agregarCategoria method, of class CtrlProductos.
	 */
	/*@Test
	 public void testAgregarCategoria() {
	 System.out.println("agregarCategoria");
	 String idCategoria = "";
	 CtrlProductos instance = new CtrlProductos();
	 boolean expResult = false;
	 boolean result = instance.agregarCategoria(idCategoria);
	 assertEquals(expResult, result);
	 // TODO review the generated test code and remove the default call to fail.
	 fail("The test case is a prototype.");
	 }

	 /**
	 * Test of quitarCategoria method, of class CtrlProductos.
	 */
	@Test
	public void testQuitarCategoria() {
		System.out.println("quitarCategoria");
		String idCategoria = "";
		boolean expResult = false;
		boolean result = instance.quitarCategoria(idCategoria);
		assertEquals(expResult, result);

	}

	/**
	 * Test of seleccionarCategoriaPadre method, of class CtrlProductos.
	 */
	@Test
	public void testSeleccionarCategoriaPadre() {
		System.out.println("seleccionarCategoriaPadre");
		assertFalse(instance.seleccionarCategoriaPadre("No existe"));
		assertTrue(instance.seleccionarCategoriaPadre("Categorias"));
		assertEquals("Categorias", instance.categoriaPadre);
	}

	/**
	 * Test of idCategoriaDisponible method, of class CtrlProductos.
	 */
	@Test
	public void testIdCategoriaDisponible() {
		System.out.println("idCategoriaDisponible");
		String idCategoria = "";
		boolean expResult = true;
		boolean result = instance.idCategoriaDisponible(idCategoria);
		assertEquals(expResult, result);

	}

	/**
	 * Test of altaCategoria method, of class CtrlProductos.
	 */
	/*@Test
	 public void testAltaCategoria() {
	 System.out.println("altaCategoria");
	 CtrlProductos instance = new CtrlProductos();
	 instance.altaCategoria();
	 // TODO review the generated test code and remove the default call to fail.
	 fail("The test case is a prototype.");
	 }

	/**
	 * Test of seleccionarProveedor method, of class CtrlProductos.
	 */
	@Test
	public void testSeleccionarProveedor() {
		System.out.println("seleccionarProveedor");
		String nick = "";
		instance.seleccionarProveedor(nick);
		// TODO review the generated test code and remove the default call to fail.
		assertEquals(nick, instance.nicknameP);
	}

	/**
	 * Test of idServicioDisponible method, of class CtrlProductos.
	 */
	@Test
	public void testIdServicioDisponible() {
		System.out.println("idServicioDisponible");
		String idServicio = "";
		boolean expResult = true;
		boolean result = instance.idServicioDisponible(idServicio);
		assertEquals(expResult, result);

	}

	/**
	 * Test of seleccionarOrigen method, of class CtrlProductos.
	 */
	@Test
	public void testSeleccionarOrigen() {
		System.out.println("seleccionarOrigen");
		DTUbicacion dtU = new DTUbicacion("Madrid", "España");
		instance.seleccionarOrigen(dtU);
		assertEquals(dtU, instance.getOrigen());
	}

	/**
	 * Test of seleccionarDestino method, of class CtrlProductos.
	 */
	@Test
	public void testSeleccionarDestino() {
		System.out.println("seleccionarDestino");
		DTUbicacion dtU = new DTUbicacion("Madrid", "España");
		instance.seleccionarDestino(dtU);
		assertEquals(dtU, instance.getDestino());

	}

	/**
	 * Test of seleccionarCategoriaSimple method, of class CtrlProductos.
	 */
	@Test
	public void testSeleccionarCategoriaSimple() {
		System.out.println("seleccionarCategoriaSimple");
		String idCategoria = "asdf";
		boolean expResult = false;
		boolean result = instance.seleccionarCategoriaSimple(idCategoria);
		assertEquals(expResult, result);

	}

	/**
	 * Test of quitarCategoriaListada method, of class CtrlProductos.
	 */
	/*@Test
	 public void testQuitarCategoriaListada() {
	 System.out.println("quitarCategoriaListada");
	 String idCategoria = "";
	 CtrlProductos instance = new CtrlProductos();
	 instance.quitarCategoriaListada(idCategoria);
	 // TODO review the generated test code and remove the default call to fail.
	 fail("The test case is a prototype.");
	 }

	 /**
	 * Test of altaServicio method, of class CtrlProductos.
	 */
	/*@Test
	 public void testAltaServicio() {
	 System.out.println("altaServicio");
	 String descripcion = "";
	 float precio = 0.0F;
	 Set<String> imagenes = null;
	 CtrlProductos instance = new CtrlProductos();
	 instance.altaServicio(descripcion, precio, imagenes);
	 // TODO review the generated test code and remove the default call to fail.
	 fail("The test case is a prototype.");
	 }

	/**
	 * Test of agregarServicio method, of class CtrlProductos.
	 */
	/*@Test
	 public void testAgregarServicio() {
	 System.out.println("agregarServicio");
	 DTMinServicio dtS = null;
	 CtrlProductos instance = new CtrlProductos();
	 instance.agregarServicio(dtS);
	 // TODO review the generated test code and remove the default call to fail.
	 fail("The test case is a prototype.");
	 }

	 /**
	 * Test of idPromocionDisponible method, of class CtrlProductos.
	 */
	@Test
	public void testIdPromocionDisponible() {
		System.out.println("idPromocionDisponible");
		String idPromocion = "";
		boolean expResult = true;
		boolean result = instance.idPromocionDisponible(idPromocion);
		assertEquals(expResult, result);

	}

	/**
	 * Test of altaPromocion method, of class CtrlProductos.
	 */
	/*@Test
	 public void testAltaPromocion() {
	 System.out.println("altaPromocion");
	 float descuento = 0.0F;
	 CtrlProductos instance = new CtrlProductos();
	 instance.altaPromocion(descuento);
	 // TODO review the generated test code and remove the default call to fail.
	 fail("The test case is a prototype.");
	 }
	 */
}
