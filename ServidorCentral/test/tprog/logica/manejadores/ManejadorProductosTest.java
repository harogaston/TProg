package tprog.logica.manejadores;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import tprog.logica.clases.Categoria;
import tprog.logica.clases.Ciudad;
import tprog.logica.clases.Pais;
import tprog.logica.clases.Promocion;
import tprog.logica.clases.Servicio;
import tprog.logica.clases.Simple;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUbicacion;

public class ManejadorProductosTest {

	ManejadorProductos instance;

	public ManejadorProductosTest() {
	}

	@Before
	public void setUp() {
		instance = ManejadorProductos.getInstance();
		Pais p = new Pais("USA");
		Ciudad c = new Ciudad("Chicago");
		p.agregarCiudad(c);
		instance.agregarPais(p);
		instance.altaCategoria("SubCat", null);
		DTServicio dtS = new DTServicio("Blue Beatle", "Just an old blue beatle", 50,
				new HashSet(), new DTUbicacion("Chicago", "USA"), null);
		ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
		DTProveedor dtP = new DTProveedor("Harry Dresden", "pass", "Harry", "Dresden", "noUsoEmail@protonmail.com",
				"Wizard", new Date(1984, 07, 16), "Charmed", "NotHaveWeb.com");
		mu.altaProveedor(dtP);
		Set<String> listaCategorias = new HashSet();
		listaCategorias.add("SubCat");
		instance.altaServicio(dtS, dtP.getNickname(), listaCategorias);
	}

	@After
	public void tearDown() {
		instance.categorias = new HashMap();
		instance.servicios = new HashMap();
		instance.promociones = new HashMap();
		instance.ubicaciones = new HashMap();
		instance.root = new Simple("Categorias");
		instance.categorias.put(instance.root.getIdCategoria(), instance.root);
	}

	/**
	 * Test of getInstance method, of class ManejadorProductos.
	 */
	@Test
	public void testGetInstance() {
		System.out.println("getInstance");
		ManejadorProductos result = ManejadorProductos.getInstance();
		assertEquals(instance, result);
	}

	/**
	 * Test of agregarPais method, of class ManejadorProductos.
	 */
	@Test
	public void testAgregarPais() {
		System.out.println("agregarPais");
		//Se agregó Pais "USA" en el SetUp
		assertTrue(!instance.ubicaciones.isEmpty());
		assertEquals(1, instance.ubicaciones.size());
		assertTrue(instance.ubicaciones.containsKey("USA"));
	}

	/**
	 * Test of listarCiudades method, of class ManejadorProductos.
	 */
	@Test
	public void testListarCiudades() {
		System.out.println("listarCiudades");
		//Se agregó Chicago como ciudad de USA en el SetUp
		DefaultMutableTreeNode result = instance.listarCiudades();
		assertTrue(result.isRoot());
		assertEquals(1, result.getChildCount());
		assertEquals("USA", result.getFirstChild().toString());
		assertEquals(1, result.getFirstChild().getChildCount());
		assertEquals("Chicago", result.getFirstLeaf().toString());
	}

	/**
	 * Test of idCategoriaDisponible method, of class ManejadorProductos.
	 */
	@Test
	public void testIdCategoriaDisponibleFails() {
		System.out.println("idCategoriaDisponible");
		String idCategoria = "Categorias";
		boolean expResult = false;
		boolean result = instance.idCategoriaDisponible(idCategoria);
		assertEquals(expResult, result);
	}

	@Test
	public void testIdCategoriaDisponibleSucceds() {
		System.out.println("idCategoriaDisponible");
		String idCategoria = "NewCategoria";
		boolean expResult = true;
		boolean result = instance.idCategoriaDisponible(idCategoria);
		assertEquals(expResult, result);
	}

	/**
	 * Test of esCategoriaPadre method, of class ManejadorProductos.
	 */
	@Test
	public void testEsCategoriaPadre() {
		System.out.println("esCategoriaPadre");
		String idCategoria = "Categorias";
		boolean expResult = true;
		boolean result = instance.esCategoriaPadre(idCategoria);
		assertEquals(expResult, result);
	}

	/**
	 * Test of listarCategorias method, of class ManejadorProductos.
	 */
	@Test
	public void testListarCategorias() {
		System.out.println("listarCategorias");
		DefaultMutableTreeNode result = instance.listarCategorias();
		assertTrue(result.isRoot());
		assertFalse(result.isLeaf());
		assertEquals(1, result.getChildCount());
		assertEquals("Categorias", result.getRoot().toString());
	}

	/**
	 * Test of altaCategoria method, of class ManejadorProductos.
	 */
	@Test
	public void testAltaCategoriaToRoot() {
		System.out.println("altaCategoriaToRoot");
		String idCategoria = "NewCategoria";
		instance.altaCategoria(idCategoria, null);
		assertEquals(3, instance.categorias.size());
		assertTrue(instance.categorias.containsKey("NewCategoria"));
		Categoria newC = instance.categorias.get("NewCategoria");
		Categoria root = instance.categorias.get("Categorias");
		assertTrue(root.esCategoriaPadre());
		assertFalse(root.esCategoriaSimple());
		assertTrue(newC.esCategoriaSimple());
		assertEquals(root, newC.getPadre());
	}

	/**
	 * Test of altaCategoria method, of class ManejadorProductos.
	 */
	@Test
	public void testAltaCategoria2() {
		System.out.println("altaCategoria");
		instance.altaCategoria("BabyCategoria", "SubCat");
		assertEquals(3, instance.categorias.size());
		assertTrue(instance.categorias.containsKey("BabyCategoria"));
		Categoria baby = instance.categorias.get("BabyCategoria");
		Categoria newC = instance.categorias.get("SubCat");
		assertTrue(newC.esCategoriaPadre());
		assertFalse(newC.esCategoriaSimple());
		assertTrue(baby.esCategoriaSimple());
		assertEquals(newC, baby.getPadre());
	}

	/**
	 * Test of esCategoriaSimple method, of class ManejadorProductos.
	 */
	@Test
	public void esCategoriaSimpleTrue() {
		System.out.println("esCategoriaSimpleTrue");
		assertTrue(instance.esCategoriaSimple("SubCat"));

	}

	/**
	 * Test of esCategoriaSimple method, of class ManejadorProductos.
	 */
	@Test
	public void esCategoriaSimpleFalse1() {
		System.out.println("esCategoriaSimpleFalse1");
		assertFalse(instance.esCategoriaSimple("Categorias"));
	}

	/**
	 * Test of esCategoriaSimple method, of class ManejadorProductos.
	 */
	@Test
	public void esCategoriaSimpleFalse2() {
		System.out.println("esCategoriaSimpleFalse2");
		assertFalse(instance.esCategoriaSimple("CategoriaFalsa"));
	}

	/**
	 * Test of idServicioDisponible method, of class ManejadorProductos.
	 */
	@Test
	public void testIdServicioDisponibleSinProveedor() {
		System.out.println("idServicioSinProveedor");
		String idServicio = "testServicio";
		String nicknameP = "So";
		boolean expResult = true;
		boolean result = instance.idServicioDisponible(idServicio, nicknameP);
		assertEquals(expResult, result);
	}

	/**
	 * Test of listarServicios method, of class ManejadorProductos.
	 */
	@Test
	public void testListarServicios() throws Exception {
		System.out.println("listarServicios");
		Set<DTMinServicio> result = instance.listarServicios();
		assertFalse(result.isEmpty());
		assertEquals(1, result.size());
	}

	/**
	 * Test of listarPromociones method, of class ManejadorProductos.
	 */
	@Test
	public void testListarPromociones() throws Exception {
		System.out.println("listarPromociones");
		assertTrue(instance.listarPromociones().isEmpty());
	}

	/**
	 * Test of altaServicio method, of class ManejadorProductos.
	 */
	@Test
	public void testAltaServicio() {
		System.out.println("altaServicio");
		//Se creó un Servicio en el SetUp        
		assertTrue(instance.servicios.containsKey("Harry Dresden"));
		assertTrue(instance.servicios.get("Harry Dresden").containsKey("Blue Beatle"));
		assertFalse(instance.idServicioDisponible("Blue Beatle", "Harry Dresden"));
	}

	/**
	 * Test of listarServiciosCategoria method, of class ManejadorProductos.
	 */
	@Test
	public void testListarServiciosCategoria() {
		System.out.println("listarServiciosCategoria");
		//El Servicio creado en SetUp pertenece a Categorias
		Set<DTMinServicio> result = instance.listarServiciosCategoria("Categorias");
		assertFalse(result.isEmpty());
		assertEquals(1, result.size());
		DTMinServicio dtMin = new DTMinServicio("Harry Dresden", "Blue Beatle");
		for (DTMinServicio s : result) {
			assertEquals(dtMin.toString(), s.toString());
		}
	}

	/**
	 * Test of listarServiciosCategoria method, of class ManejadorProductos.
	 */
	@Test
	public void testListarServiciosCategoriaVacio() {
		System.out.println("listarServiciosCategoria");
		//El Servicio creado en SetUp pertenece a Categorias
		instance.altaCategoria("Vacia", null);
		Set<DTMinServicio> result = instance.listarServiciosCategoria("Vacía");
		assertTrue(result.isEmpty());
	}

	/**
	 * Test of infoServicio method, of class ManejadorProductos.
	 */
	@Test
	public void testInfoServicio() {
		System.out.println("infoServicio");
		//Se compara con el Servicio dado de Alta en SetUp
		DTServicio expResult = new DTServicio("Blue Beatle", "Just an old blue beatle", 50,
				new HashSet(), new DTUbicacion("Chicago", "USA"), null);
		DTServicio result = instance.infoServicio(new DTMinServicio("Harry Dresden", "Blue Beatle"));
		assertEquals(expResult.toString(), result.toString());
	}

	@Test
	public void testInfoServicioFail1() {
		System.out.println("infoServicioFail1");
		//Se compara con el Servicio dado de Alta en SetUp
		DTServicio result = instance.infoServicio(new DTMinServicio("Harry Dresden", "Red Beatle"));
		assertEquals(null, result);
	}

	@Test
	public void testInfoServicioFail2() {
		System.out.println("infoServicioFail2");
		//Se compara con el Servicio dado de Alta en SetUp
		DTServicio result = instance.infoServicio(new DTMinServicio("Charlie Dresden", "Blue Beatle"));
		assertEquals(null, result);
	}

	/**
	 * Test of cambiarDescripcion method, of class ManejadorProductos.
	 */
	@Test
	public void testCambiarDescripcion() {
		System.out.println("cambiarDescripcion");
		//Se modifica el Servicio creado en SetUp
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		String descripcion = "Nueva Descripción";
		instance.cambiarDescripcion(dtMinS, descripcion);
		String result = instance.servicios.get("Harry Dresden").get("Blue Beatle").getDescripcion();
		assertEquals(descripcion, result);
	}

	/**
	 * Test of cambiarPrecio method, of class ManejadorProductos.
	 */
	@Test
	public void testCambiarPrecio() {
		System.out.println("cambiarPrecio");
		//Se modifica el Servicio creado en SetUp
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		Float precio = 55.5F;
		instance.cambiarPrecio(dtMinS, precio);
		Float result = instance.servicios.get("Harry Dresden").get("Blue Beatle").getPrecio();
		assertEquals(precio, result);
	}

	/**
	 * Test of listarImagenes method, of class ManejadorProductos.
	 */
	@Test
	public void testListarImagenesEmpty() {
		System.out.println("listarImagenesEmpty");
		//Se analiza el Servicio creado en SetUp con un set de imagenes vacío.
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		assertTrue(instance.listarImagenes(dtMinS).isEmpty());
	}

	/**
	 * Test of agregarImagen method, of class ManejadorProductos.
	 */
	@Test
	public void testAgregarImagen() throws Exception {
		System.out.println("agregarImagen");
		//Se modifica el Servicio creado en SetUp
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		instance.agregarImagen(dtMinS, "Beatle");
		Set<String> result = instance.servicios.get("Harry Dresden").get("Blue Beatle").getImagenes();
		assertFalse(result.isEmpty());
		assertEquals(1, result.size());
		assertTrue(result.contains("Beatle"));
	}

	/**
	 * Test of agregarImagen method, of class ManejadorProductos.
	 */
	@Test
	public void testAgregarImagenFail() throws Exception {
		System.out.println("agregarImagenFail");
		try {
			DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Red Beatle");
			instance.agregarImagen(dtMinS, "Beatle");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "El Servicio seleccionado no es válido.");
		}
	}

	/**
	 * Test of agregarImagen method, of class ManejadorProductos.
	 */
	@Test
	public void testAgregarImagenFail2() throws Exception {
		System.out.println("agregarImagenFail2");
		try {
			instance.servicios = new HashMap();
			DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Red Beatle");
			instance.agregarImagen(dtMinS, "Beatle");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "No existen Servicios registrados en el Sistema.");
		}
	}

	/**
	 * Test of quitarImagen method, of class ManejadorProductos.
	 */
	@Test
	public void testQuitarImagen() throws Exception {
		System.out.println("quitarImagen");
		//Se modifica el Servicio creado en SetUp
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		instance.agregarImagen(dtMinS, "Beatle");
		instance.quitarImagen(dtMinS, "Beatle");
		Set<String> result = instance.servicios.get("Harry Dresden").get("Blue Beatle").getImagenes();
		assertTrue(result.isEmpty());
	}

	/**
	 * Test of quitarImagen method, of class ManejadorProductos.
	 */
	@Test
	public void testQuitarImagenFail() throws Exception {
		System.out.println("quitarImagenFail");
		try {
			DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Red Beatle");
			instance.quitarImagen(dtMinS, "Beatle");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "El Servicio seleccionado no es válido.");
		}
	}

	/**
	 * Test of quitarImagen method, of class ManejadorProductos.
	 */
	@Test
	public void testquitarImagenFail2() throws Exception {
		System.out.println("quitarImagenFail2");
		try {
			instance.servicios = new HashMap();
			DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Red Beatle");
			instance.quitarImagen(dtMinS, "Beatle");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "No existen Servicios registrados en el Sistema.");
		}
	}

	/**
	 * Test of cambiarOrigen method, of class ManejadorProductos.
	 */
	@Test
	public void testCambiarOrigen() {
		System.out.println("cambiarOrigen");
		//Se modifica el Servicio creado en SetUp
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		Pais p = new Pais("The NeverNever");
		Ciudad c = new Ciudad("FairyLand");
		p.agregarCiudad(c);
		instance.agregarPais(p);

		instance.cambiarOrigen(dtMinS, new DTUbicacion("FairyLand", "The NeverNever"));
		Ciudad result = instance.servicios.get("Harry Dresden").get("Blue Beatle").getOrigen();
		assertEquals(c, result);
	}

	/**
	 * Test of cambiarDestino method, of class ManejadorProductos.
	 */
	@Test
	public void testCambiarDestino() {
		System.out.println("cambiarDestino");
		//Se modifica el Servicio creado en SetUp con Destino = null
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		Ciudad c = instance.ubicaciones.get("USA").getCiudades().get("Chicago");
		instance.cambiarDestino(dtMinS, new DTUbicacion("Chicago", "USA"));
		Ciudad result = instance.servicios.get("Harry Dresden").get("Blue Beatle").getDestino();
		assertEquals(c, result);
	}

	/**
	 * Test of listarCategoriasServicio method, of class ManejadorProductos.
	 */
	@Test
	public void testListarCategoriasServicio() {
		System.out.println("listarCategoriasServicio");
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		Set<String> result = instance.listarCategoriasServicio(dtMinS);
		assertFalse(result.isEmpty());
		assertEquals(1, result.size());
		assertTrue(result.contains("SubCat"));
	}

	/**
	 * Test of esCategoriaSimpleAgregar method, of class ManejadorProductos.
	 */
	@Test
	//Caso que intenta agregar una Categoria Compuesta.
	public void testEsCategoriaSimpleAgregarFail() {
		System.out.println("esCategoriaSimpleAgregarFails");
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		int expResult = instance.listarCategoriasServicio(dtMinS).size();
		assertFalse(instance.esCategoriaSimpleAgregar(dtMinS, "Categorias"));
		assertEquals(expResult, instance.listarCategoriasServicio(dtMinS).size());
	}

	/**
	 * Test of esCategoriaSimpleAgregar method, of class ManejadorProductos.
	 */
	@Test
	//Caso que intenta agregar una Categoria inválida.
	public void testEsCategoriaSimpleAgregarFail2() {
		System.out.println("esCategoriaSimpleAgregarFails");
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		int expResult = instance.listarCategoriasServicio(dtMinS).size();
		assertFalse(instance.esCategoriaSimpleAgregar(dtMinS, "CategoriaFalsa"));
		assertEquals(expResult, instance.listarCategoriasServicio(dtMinS).size());
	}

	/**
	 * Test of esCategoriaSimpleAgregar method, of class ManejadorProductos.
	 */
	@Test
	public void testEsCategoriaSimpleAgregar() {
		System.out.println("esCategoriaSimpleAgregar");
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		instance.altaCategoria("NuevaCategoria", null);
		assertTrue(instance.esCategoriaSimpleAgregar(dtMinS, "NuevaCategoria"));
		assertEquals(2, instance.listarCategoriasServicio(dtMinS).size());
	}

	/**
	 * Test of esCategoriaSimpleAgregar method, of class ManejadorProductos.
	 */
	//Caso de agregar una Categoria que ya está en el Set
	@Test
	public void testEsCategoriaSimpleAgregarFails3() {
		System.out.println("esCategoriaSimpleAgregar");
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		assertFalse(instance.esCategoriaSimpleAgregar(dtMinS, "SubCat"));
		assertEquals(1, instance.listarCategoriasServicio(dtMinS).size());
	}

	/**
	 * Test of esCategoriaSimpleQuitar method, of class ManejadorProductos.
	 */
	@Test
	public void testEsCategoriaSimpleQuitar() {
		System.out.println("esCategoriaSimpleQuitar");
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		instance.altaCategoria("NuevaCategoria", null);
		assertTrue(instance.esCategoriaSimpleAgregar(dtMinS, "NuevaCategoria"));
		assertTrue(instance.esCategoriaSimpleQuitar(dtMinS, "NuevaCategoria"));
		assertEquals(1, instance.listarCategoriasServicio(dtMinS).size());
		assertFalse(instance.listarCategoriasServicio(dtMinS).contains("NuevaCategoria"));
	}

	/**
	 * Test of getPrecioServicio method, of class ManejadorProductos.
	 */
	@Test
	public void testGetPrecioServicio() {
		System.out.println("getPrecioServicio");
		DTMinServicio dtMinS = new DTMinServicio("Harry Dresden", "Blue Beatle");
		float result = instance.getPrecioServicio(dtMinS);
		float expResult = 50;
		assertEquals(expResult, result, 0.1F);
	}

	/**
	 * Test of getServicio method, of class ManejadorProductos.
	 */
	@Test
	public void testGetServicioNull() {
		System.out.println("getServicioNull");
		Servicio result = instance.getServicio(null);
		assertEquals(null, result);
	}

	/**
	 * Test of getServicio method, of class ManejadorProductos.
	 */
	@Test
	public void testGetServicio() {
		System.out.println("getServicio");
		ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
		Servicio s = new Servicio("Blue Beatle", "Just an old blue beatle", 50,
				new HashSet(), instance.ubicaciones.get("USA").getCiudades().get("Chicago"),
				null, mu.getProveedor("Harry Dresden"));
		Servicio result = instance.getServicio(new DTMinServicio("Harry Dresden", "Blue Beatle"));
		assertEquals(s.toString(), result.toString());
	}

	/**
	 * Test of idPromocionDisponible method, of class ManejadorProductos.
	 */
	@Test
	public void testIdPromocionDisponible() {
		System.out.println("idPromocionDisponible");
		String idPromocion = "Oportunidad";
		assertTrue(instance.idPromocionDisponible(idPromocion, "Juan Perez"));
	}

	/**
	 * Test of idPromocionDisponible method, of class ManejadorProductos.
	 */
	@Test
	public void testIdPromocionDisponible2() {
		System.out.println("idPromocionDisponible2");
		String idPromocion = "Blue Opportunity";
		float descuento = 20;
		String nicknameProv = "Harry Dresden";
		List<String> servicios = new ArrayList();
		servicios.add("Blue Beatle");
		instance.altaPromocion(idPromocion, descuento, nicknameProv, servicios);
		assertFalse(instance.idPromocionDisponible("Blue Opportunity", "Harry Dresden"));
		assertTrue(instance.idPromocionDisponible("Blue Opportunity", "Harry Potter"));
		assertTrue(instance.idPromocionDisponible("Black Opportunity", "Harry Dresden"));
	}

	/**
	 * Test of altaPromocion method, of class ManejadorProductos.
	 */
	@Test
	public void testAltaPromocion() {
		System.out.println("altaPromocion");
		String idPromocion = "Blue Opportunity";
		float descuento = 20;
		String nicknameProv = "Harry Dresden";
		List<String> servicios = new ArrayList();
		servicios.add("Blue Beatle");
		instance.altaPromocion(idPromocion, descuento, nicknameProv, servicios);

		assertFalse(instance.promociones.isEmpty());
		assertTrue(instance.promociones.containsKey("Harry Dresden"));
		assertTrue(instance.promociones.get("Harry Dresden").containsKey("Blue Opportunity"));
		Promocion p = instance.getPromocion(new DTMinPromocion("Harry Dresden", "Blue Opportunity"));
		assertEquals("Blue Opportunity", p.getIdPromocion());
		assertEquals("Harry Dresden", p.getNicknameProveedor());
		assertEquals(20, p.getDescuento(), 0);
		assertEquals(40, p.getTotal(), 0);
		assertFalse(instance.idPromocionDisponible("Blue Opportunity", "Harry Dresden"));
	}

	/**
	 * Test of infoPromocion method, of class ManejadorProductos.
	 */
	@Test
	public void testInfoPromocionNull() {
		System.out.println("infoPromocion");
		assertEquals(null, instance.infoPromocion(null));
	}

	/**
	 * Test of infoPromocion method, of class ManejadorProductos.
	 */
	@Test
	public void testInfoPromocion() {
		System.out.println("infoPromocion");
		String idPromocion = "Blue Opportunity";
		float descuento = 20;
		String nicknameProv = "Harry Dresden";
		List<String> servicios = new ArrayList();
		servicios.add("Blue Beatle");
		instance.altaPromocion(idPromocion, descuento, nicknameProv, servicios);
		DTMinPromocion dtP = new DTMinPromocion(nicknameProv, idPromocion);
		DTMinServicio dtS = new DTMinServicio(nicknameProv, "Blue Beatle");
		HashMap<DTMinServicio, Integer> serv = new HashMap<>();
		serv.put(dtS, 1);
		DTPromocion expResult = new DTPromocion(idPromocion, 20, 40, serv);
		DTPromocion result = instance.infoPromocion(dtP);
		assertEquals(expResult.toString(), result.toString());
	}

	/**
	 * Test of getPromocion method, of class ManejadorPorductos.
	 */
	@Test
	public void testGetPromocion() {
		System.out.println("getPromocion");
		assertEquals(null, instance.getPromocion(null));
	}

	/**
	 * Test of getPrecioPromocion method, of class ManejadorProductos.
	 */
	@Test
	public void testGetPrecioPromocion() {
		String idPromocion = "Blue Opportunity";
		float descuento = 20;
		String nicknameProv = "Harry Dresden";
		List<String> servicios = new ArrayList();
		servicios.add("Blue Beatle");
		instance.altaPromocion(idPromocion, descuento, nicknameProv, servicios);
		float expResult = 40;
		float result = instance.getPrecioPromocion(new DTMinPromocion("Harry Dresden", "Blue Opportunity"));
		assertEquals(expResult, result, 0);
	}
}
