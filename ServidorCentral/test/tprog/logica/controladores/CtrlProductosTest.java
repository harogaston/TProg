package tprog.logica.controladores;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import tprog.logica.clases.Ciudad;
import tprog.logica.clases.Pais;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUbicacion;
import tprog.logica.manejadores.ManejadorProductos;
import tprog.logica.manejadores.ManejadorUsuarios;

public class CtrlProductosTest {

	CtrlProductos instance;

	public CtrlProductosTest() {
	}

	@Before
	public void setUp() {
		instance = new CtrlProductos();
                DTProveedor dtP = new DTProveedor("adippet", "pass", "Armando", "Dippet", "tam@outlook.com",
					"/imagenes/proveedores/adippet.jpg",
					new Date(1967, 2 - 1, 12), "Tam", "http://www.tam.com.br/");
                ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
		mu.altaProveedor(dtP);
                ManejadorProductos mp = ManejadorProductos.getInstance();
			mp.altaCategoria("Vuelos", null);
			mp.altaCategoria("Empresas", "Vuelos");
			mp.altaCategoria("Iberia", "Empresas");
			mp.altaCategoria("American Airlines", "Empresas");
			mp.altaCategoria("Air France", "Empresas");
			mp.altaCategoria("TAM", "Empresas");
			mp.altaCategoria("Tipo vuelo", "Vuelos");
			mp.altaCategoria("LowCost", "Tipo vuelo");
			mp.altaCategoria("Standard", "Tipo vuelo");
			mp.altaCategoria("First Class", "Tipo vuelo");
			mp.altaCategoria("Alojamientos", null);
			mp.altaCategoria("Tipo alojamiento", "Alojamientos");
			mp.altaCategoria("Hotel", "Tipo alojamiento");
			mp.altaCategoria("Hostal", "Tipo alojamiento");
			mp.altaCategoria("Apartamento", "Tipo alojamiento");
			mp.altaCategoria("Casa", "Tipo alojamiento");
			mp.altaCategoria("Ubicación", "Alojamientos");
			mp.altaCategoria("Playa", "Ubicación");
			mp.altaCategoria("Rural", "Ubicación");
			mp.altaCategoria("Montaña", "Ubicación");
			mp.altaCategoria("Habitaciones", "Alojamientos");
			mp.altaCategoria("1 ambiente", "Habitaciones");
			mp.altaCategoria("1 dormitorio", "Habitaciones");
			mp.altaCategoria("2 dormitorios", "Habitaciones");
			mp.altaCategoria("Automóviles", null);
			mp.altaCategoria("Tarifa", "Automóviles");
			mp.altaCategoria("Mini", "Tarifa");
			mp.altaCategoria("Económico", "Tarifa");
			mp.altaCategoria("Común", "Tarifa");
			mp.altaCategoria("Full", "Tarifa");
			mp.altaCategoria("Tipo vehículo", "Automóviles");
			mp.altaCategoria("Auto", "Tipo vehículo");
			mp.altaCategoria("Camioneta", "Tipo vehículo");
			mp.altaCategoria("Camión", "Tipo vehículo");
			mp.altaCategoria("Moto", "Tipo vehículo");
			mp.altaCategoria("Marca", "Automóviles");
			mp.altaCategoria("Chevrolet", "Marca");
			mp.altaCategoria("Peugeot", "Marca");
			mp.altaCategoria("Daihatsu", "Marca");
			mp.altaCategoria("Fiat", "Marca");
			mp.altaCategoria("Ford", "Marca");
			mp.altaCategoria("Cruceros", null);
			mp.altaCategoria("Mediterráneo", "Cruceros");
			mp.altaCategoria("Mar Negro", "Cruceros");
			mp.altaCategoria("Caribe", "Cruceros");
			mp.altaCategoria("Nilo", "Cruceros");
			mp.altaCategoria("Alaska", "Cruceros");
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
		assertEquals(dtP.getNicknameP(), instance.getDtP().getNicknameP());
		assertEquals(dtP.getIdPromocion(), instance.getDtP().getIdPromocion());
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
		assertEquals(dtS.getNicknameP(), instance.getDtS().getNicknameP());
		assertEquals(dtS.getIdServicio(), instance.getDtS().getIdServicio());
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
	@Test
	public void testCambiarPrecio() {
                System.out.println("cambiarPrecio");
                
                Set<String> cats = new HashSet();
                cats.add("Económico");
		cats.add("Auto");
                Pais p = new Pais("Uruguay");
                ManejadorProductos mp = ManejadorProductos.getInstace();
                Ciudad ciudad = new Ciudad("Montevideo");
		p.agregarCiudad(ciudad);
		mp.agregarPais(p);
                DTUbicacion dtU = new DTUbicacion("Montevideo","Uruguay");
                instance.seleccionarOrigen(dtU);
                instance.seleccionarDestino(dtU);
                DTMinServicio dts = new DTMinServicio("adippet", "TAM");
                instance.seleccionarServicio(dts);
                instance.seleccionarProveedor("adippet");
                instance.altaServicio("bueno", 150, cats);
                float nuevoPrecio = 0.0F;
                instance.cambiarPrecio(nuevoPrecio);
                assertEquals(nuevoPrecio, instance.infoServicio().getPrecio(),0.0F);
	// TODO review the generated test code and remove the default call to fail.
	}

	 /**
	 * Test of cambiarDescripcion method, of class CtrlProductos.
	 */
	@Test
	public void testCambiarDescripcion() {
                System.out.println("cambiarDescripcion");
                Set<String> cats = new HashSet();
                cats.add("Económico");
		cats.add("Auto");
                Pais p = new Pais("Uruguay");
                ManejadorProductos mp = ManejadorProductos.getInstace();
                Ciudad ciudad = new Ciudad("Montevideo");
		p.agregarCiudad(ciudad);
		mp.agregarPais(p);
                DTUbicacion dtU = new DTUbicacion("Montevideo","Uruguay");
                instance.seleccionarOrigen(dtU);
                instance.seleccionarDestino(dtU);
                DTMinServicio dts = new DTMinServicio("adippet", "TAM");
                instance.seleccionarServicio(dts);
                instance.seleccionarProveedor("adippet");
                instance.altaServicio("bueno", 150, cats);
                String descripcion = "";
                instance.cambiarDescripcion(descripcion);
                assertEquals(descripcion, instance.infoServicio().getDescripcion());
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
	@Test
	public void testCambiarOrigen() {
                System.out.println("cambiarOrigen");
                Set<String> cats = new HashSet();
                cats.add("Económico");
		cats.add("Auto");
                Pais p = new Pais("Uruguay");
                ManejadorProductos mp = ManejadorProductos.getInstace();
                Ciudad ciudad = new Ciudad("Montevideo");
		p.agregarCiudad(ciudad);
                p.agregarCiudad(new Ciudad("Maldonado"));
		mp.agregarPais(p);
                DTUbicacion dtU = new DTUbicacion("Montevideo","Uruguay");
                instance.seleccionarOrigen(dtU);
                instance.seleccionarDestino(dtU);
                DTMinServicio dts = new DTMinServicio("adippet", "TAM");
                instance.seleccionarServicio(dts);
                instance.seleccionarProveedor("adippet");
                instance.altaServicio("bueno", 150, cats);
                DTUbicacion cambio = new DTUbicacion("Maldonado","Uruguay");
                instance.cambiarOrigen(cambio);
                assertEquals(cambio.toString(), instance.getOrigen().toString());
	
	}

	 /**
	 * Test of cambiarDestino method, of class CtrlProductos.
	 */
	@Test
	public void testCambiarDestino() {
                System.out.println("cambiarDestino");
                Set<String> cats = new HashSet();
                cats.add("Económico");
		cats.add("Auto");
                Pais p = new Pais("Uruguay");
                ManejadorProductos mp = ManejadorProductos.getInstace();
                Ciudad ciudad = new Ciudad("Montevideo");
		p.agregarCiudad(ciudad);
                p.agregarCiudad(new Ciudad("Maldonado"));
		mp.agregarPais(p);
                DTUbicacion dtU = new DTUbicacion("Montevideo","Uruguay");
                instance.seleccionarOrigen(dtU);
                instance.seleccionarDestino(dtU);
                DTMinServicio dts = new DTMinServicio("adippet", "TAM");
                instance.seleccionarServicio(dts);
                instance.seleccionarProveedor("adippet");
                instance.altaServicio("bueno", 150, cats);
                DTUbicacion cambio = new DTUbicacion("Maldonado","Uruguay");
                instance.cambiarDestino(dtU);
                assertEquals(cambio.toString(), instance.getDestino().toString());
	 // TODO review the generated test code and remove the default call to fail.
	 
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
		assertEquals("Categorias", instance.getCategoriaPadre());
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
		assertEquals(nick, instance.getNicknameP());
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
