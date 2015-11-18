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
                ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		manejadorU.altaProveedor(dtP);
                ManejadorProductos manejadorP = ManejadorProductos.getInstance();
			manejadorP.altaCategoria("Vuelos", null);
			manejadorP.altaCategoria("Empresas", "Vuelos");
			manejadorP.altaCategoria("Iberia", "Empresas");
			manejadorP.altaCategoria("American Airlines", "Empresas");
			manejadorP.altaCategoria("Air France", "Empresas");
			manejadorP.altaCategoria("TAM", "Empresas");
			manejadorP.altaCategoria("Tipo vuelo", "Vuelos");
			manejadorP.altaCategoria("LowCost", "Tipo vuelo");
			manejadorP.altaCategoria("Standard", "Tipo vuelo");
			manejadorP.altaCategoria("First Class", "Tipo vuelo");
			manejadorP.altaCategoria("Alojamientos", null);
			manejadorP.altaCategoria("Tipo alojamiento", "Alojamientos");
			manejadorP.altaCategoria("Hotel", "Tipo alojamiento");
			manejadorP.altaCategoria("Hostal", "Tipo alojamiento");
			manejadorP.altaCategoria("Apartamento", "Tipo alojamiento");
			manejadorP.altaCategoria("Casa", "Tipo alojamiento");
			manejadorP.altaCategoria("Ubicación", "Alojamientos");
			manejadorP.altaCategoria("Playa", "Ubicación");
			manejadorP.altaCategoria("Rural", "Ubicación");
			manejadorP.altaCategoria("Montaña", "Ubicación");
			manejadorP.altaCategoria("Habitaciones", "Alojamientos");
			manejadorP.altaCategoria("1 ambiente", "Habitaciones");
			manejadorP.altaCategoria("1 dormitorio", "Habitaciones");
			manejadorP.altaCategoria("2 dormitorios", "Habitaciones");
			manejadorP.altaCategoria("Automóviles", null);
			manejadorP.altaCategoria("Tarifa", "Automóviles");
			manejadorP.altaCategoria("Mini", "Tarifa");
			manejadorP.altaCategoria("Económico", "Tarifa");
			manejadorP.altaCategoria("Común", "Tarifa");
			manejadorP.altaCategoria("Full", "Tarifa");
			manejadorP.altaCategoria("Tipo vehículo", "Automóviles");
			manejadorP.altaCategoria("Auto", "Tipo vehículo");
			manejadorP.altaCategoria("Camioneta", "Tipo vehículo");
			manejadorP.altaCategoria("Camión", "Tipo vehículo");
			manejadorP.altaCategoria("Moto", "Tipo vehículo");
			manejadorP.altaCategoria("Marca", "Automóviles");
			manejadorP.altaCategoria("Chevrolet", "Marca");
			manejadorP.altaCategoria("Peugeot", "Marca");
			manejadorP.altaCategoria("Daihatsu", "Marca");
			manejadorP.altaCategoria("Fiat", "Marca");
			manejadorP.altaCategoria("Ford", "Marca");
			manejadorP.altaCategoria("Cruceros", null);
			manejadorP.altaCategoria("Mediterráneo", "Cruceros");
			manejadorP.altaCategoria("Mar Negro", "Cruceros");
			manejadorP.altaCategoria("Caribe", "Cruceros");
			manejadorP.altaCategoria("Nilo", "Cruceros");
			manejadorP.altaCategoria("Alaska", "Cruceros");
            Set<DTServicio> nulo = instance.listarServiciosPorTermino("sad");
            Set<DTPromocion> nulo1 = instance.listarPromocionesPorTermino("das");
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
	@Test
	 public void testListarCategorias() {
	 System.out.println("listarCategorias");
	 
	 DefaultMutableTreeNode expResult = null;
	 DefaultMutableTreeNode result = instance.listarCategorias();
	 assertEquals(expResult, result);
	 // TODO review the generated test code and remove the default call to fail.
	 
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
                Pais pais = new Pais("Uruguay");
                ManejadorProductos manejadorP = ManejadorProductos.getInstace();
                Ciudad ciudad = new Ciudad("Montevideo");

		pais.agregarCiudad(ciudad);
		manejadorP.agregarPais(pais);
        DTUbicacion dtU = new DTUbicacion("Montevideo", "Uruguay");
        instance.seleccionarOrigen(dtU);
        instance.seleccionarDestino(dtU);
        DTMinServicio dts = new DTMinServicio("adippet", "TAM");
        instance.seleccionarServicio(dts);
        instance.seleccionarProveedor("adippet");
        instance.altaServicio("bueno", 150, cats);
        float nuevoPrecio = 0.0F;
        instance.cambiarPrecio(nuevoPrecio);
        assertEquals(nuevoPrecio, instance.infoServicio().getPrecio(), 0.0F);
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
        Pais pais = new Pais("Uruguay");
        ManejadorProductos manejadorP = ManejadorProductos.getInstace();
        Ciudad ciudad = new Ciudad("Montevideo");
		pais.agregarCiudad(ciudad);
		manejadorP.agregarPais(pais);
        DTUbicacion dtU = new DTUbicacion("Montevideo", "Uruguay");
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
	@Test
	 public void testAgregarImagen() throws Exception {
	 System.out.println("agregarImagen");
	 String idImagen = "";
	 
	 instance.agregarImagen(idImagen);
	 // TODO review the generated test code and remove the default call to fail.
	 
	 }

	 /**
	 * Test of quitarImagen method, of class CtrlProductos.
	 */
	@Test
	 public void testQuitarImagen() throws Exception {
	 System.out.println("quitarImagen");
	 String idImagen = "";
	 
	 instance.quitarImagen(idImagen);
	 // TODO review the generated test code and remove the default call to fail.
	 
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
        Pais pais = new Pais("Uruguay");
        ManejadorProductos manejadorP = ManejadorProductos.getInstace();
        Ciudad ciudad = new Ciudad("Montevideo");
		pais.agregarCiudad(ciudad);
        pais.agregarCiudad(new Ciudad("Maldonado"));
		manejadorP.agregarPais(pais);
        DTUbicacion dtU = new DTUbicacion("Montevideo", "Uruguay");
        instance.seleccionarOrigen(dtU);
        instance.seleccionarDestino(dtU);
        DTMinServicio dts = new DTMinServicio("adippet", "TAM");
        instance.seleccionarServicio(dts);
        instance.seleccionarProveedor("adippet");
        instance.altaServicio("bueno", 150, cats);
        DTUbicacion cambio = new DTUbicacion("Maldonado", "Uruguay");
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
        Pais pais = new Pais("Uruguay");
        ManejadorProductos manejadorP = ManejadorProductos.getInstace();
        Ciudad ciudad = new Ciudad("Montevideo");
		pais.agregarCiudad(ciudad);
        pais.agregarCiudad(new Ciudad("Maldonado"));
		manejadorP.agregarPais(pais);
        DTUbicacion dtU = new DTUbicacion("Montevideo", "Uruguay");
        instance.seleccionarOrigen(dtU);
        instance.seleccionarDestino(dtU);
        DTMinServicio dts = new DTMinServicio("adippet", "TAM");
        instance.seleccionarServicio(dts);
        instance.seleccionarProveedor("adippet");
        instance.altaServicio("bueno", 150, cats);
        DTUbicacion cambio = new DTUbicacion("Maldonado", "Uruguay");
        instance.cambiarDestino(dtU);
        assertEquals(cambio.toString(), instance.getDestino().toString());
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
	@Test
	 public void testAgregarCategoria() {
	 System.out.println("agregarCategoria");
	 String idCategoria = "";
	 
	 boolean expResult = false;
	 boolean result = instance.agregarCategoria(idCategoria);
	 assertEquals(expResult, result);
	 // TODO review the generated test code and remove the default call to fail.
	 
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
	@Test
	 public void testAltaCategoria() {
	 System.out.println("altaCategoria");
	 
	 instance.altaCategoria();
	 // TODO review the generated test code and remove the default call to fail.
	 
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
	@Test
	 public void testQuitarCategoriaListada() {
	 System.out.println("quitarCategoriaListada");
	 String idCategoria = "";
	 
	 instance.quitarCategoriaListada(idCategoria);
	 // TODO review the generated test code and remove the default call to fail.
	 
	 }

	 /**
	 * Test of altaServicio method, of class CtrlProductos.
	 */
	@Test
	 public void testAltaServicio() {
	 System.out.println("altaServicio");
	 String descripcion = "";
	 float precio = 0.0F;
	 Set<String> imagenes = null;
	 
	 instance.altaServicio(descripcion, precio, imagenes);
	 // TODO review the generated test code and remove the default call to fail.
	 
	 }

	/**
	 * Test of agregarServicio method, of class CtrlProductos.
	 */
	@Test
	 public void testAgregarServicio() {
	 System.out.println("agregarServicio");
	 DTMinServicio dtS = null;
	 
	 instance.agregarServicio(dtS);
	 // TODO review the generated test code and remove the default call to fail.
	 
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
	@Test
	 public void testAltaPromocion() {
	 System.out.println("altaPromocion");
	 float descuento = 0.0F;
	 
	 instance.altaPromocion(descuento);
	 // TODO review the generated test code and remove the default call to fail.
	 
	 }
	 
}
