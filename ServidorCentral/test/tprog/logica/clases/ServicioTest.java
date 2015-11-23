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
import tprog.logica.dt.DTServicio;

public class ServicioTest {

	Servicio instance;
	String idServicio;
	String descripcion;
	float precio;
	Set<String> imagenes;
	Ciudad origen;
	Ciudad destino;
	Set<Simple> categorias;
	Proveedor proveedor;

	public ServicioTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		imagenes = new HashSet();
		instance = new Servicio("idServicio", "descripcion", 50, imagenes, null, null, null);
		Date fecha = new Date();
		origen = new Ciudad("Montevideo");
		Pais pais = new Pais("Uruguay");
		origen.setPais(pais);
		instance.setOrigen(origen);
		DTProveedor dtP = new DTProveedor("nick", "pass", "nom", "ap", "email",
				"imagen", fecha, "empresa", "webEmpresa");
		proveedor = new Proveedor(dtP);
		instance.setProveedor(proveedor);

	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of crearDT method, of class Servicio.
	 */
	@Test
	public void testCrearDT() {
		System.out.println("crearDT");
		DTServicio expResult = new DTServicio("idServicio", "descripcion", null, 50, null, origen.crearDT(), null);
		DTServicio result = instance.crearDT();
		boolean prim = expResult.toString().equals(result.toString());
		destino = new Ciudad("Chicago");
		destino.setPais(new Pais("USA"));
		instance.setDestino(destino);
		DTServicio expResult2 = new DTServicio("idServicio", "descripcion", null, 50, null, origen.crearDT(), destino.crearDT());
		DTServicio result2 = instance.crearDT();
		boolean prim2 = expResult2.toString().equals(result2.toString());
		assertEquals(prim, prim2);
	}

	/**
	 * Test of crearDTMin method, of class Servicio.
	 */
	@Test
	public void testCrearDTMin() {
		System.out.println("crearDTMin");

		DTMinServicio expResult = new DTMinServicio("nick", "idServicio");
		DTMinServicio result = instance.crearDTMin();
		assertEquals(expResult.toString(), result.toString());
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of listarImagenes method, of class Servicio.
	 */
	@Test
	public void testListarImagenes() {
		System.out.println("listarImagenes");
		Set<String> expResult = new HashSet();
		Set<String> result = instance.listarImagenes();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of agregarImagen method, of class Servicio.
	 */
	@Test
	public void testAgregarImagen() {
		System.out.println("agregarImagen");
		String imagen = "imageeeen";
		instance.agregarImagen(imagen);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of quitarImagen method, of class Servicio.
	 */
	@Test
	public void testQuitarImagen() {
		System.out.println("quitarImagen");
		String imagen = "imageeeen";
		instance.agregarImagen(imagen);
		instance.quitarImagen(imagen);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of listarCategorias method, of class Servicio.
	 */
	@Test
	public void testListarCategorias() {
		System.out.println("listarCategorias");

		Set<String> expResult = new HashSet();
		expResult.add("idCategoria");
		Categoria categoria = new Simple("idCategoria");
		boolean random = instance.agregarCategoria(categoria);
		Set<String> result = instance.listarCategorias();
		assertEquals(expResult, result);
                assertEquals(true, random);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of agregarCategoria method, of class Servicio.
	 */
	@Test
	public void testAgregarCategoria() {
		System.out.println("agregarCategoria");
		Categoria categoria = new Simple("idCategoria");
		boolean expResult = true;
		boolean result = instance.agregarCategoria(categoria);
		assertEquals(expResult, result);
	}

	/**
	 * Test of quitarCategoria method, of class Servicio.
	 */
	@Test
	public void testQuitarCategoria() {
		System.out.println("quitarCategoria");
		Categoria categoria = new Simple("idCategoria");
		boolean entro = instance.agregarCategoria(categoria);
		Categoria categoria_a_quitar = categoria;
		boolean expResult = true;
		boolean result = instance.quitarCategoria(categoria_a_quitar);
		assertEquals(expResult, result);
        assertEquals(entro, true);
        assertEquals(false,instance.quitarCategoria(categoria_a_quitar));
    }

	/**
	 * Test of getIdServicio method, of class Servicio.
	 */
	@Test
	public void testGetIdServicio() {
		System.out.println("getIdServicio");

		String expResult = "idServicio";
		String result = instance.getIdServicio();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setIdServicio method, of class Servicio.
	 */
	@Test
	public void testSetIdServicio() {
		System.out.println("setIdServicio");
		String idS = "";
		instance.setIdServicio(idS);
		assertEquals(idS, instance.getIdServicio());
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of getDescripcion method, of class Servicio.
	 */
	@Test
	public void testGetDescripcion() {
		System.out.println("getDescripcion");
		String expResult = "descripcion";
		String result = instance.getDescripcion();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of setDescripcion method, of class Servicio.
	 */
	@Test
	public void testSetDescripcion() {
		System.out.println("setDescripcion");
		String descn = "";
		instance.setDescripcion(descn);
		// TODO review the generated test code and remove the default call to fail.
		assertEquals(descn, instance.getDescripcion());
	}

	/**
	 * Test of getPrecio method, of class Servicio.
	 */
	@Test
	public void testGetPrecio() {
		System.out.println("getPrecio");
		float expResult = 50;
		float result = instance.getPrecio();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of setPrecio method, of class Servicio.
	 */
	@Test
	public void testSetPrecio() {
		System.out.println("setPrecio");
		precio = 20;
		instance.setPrecio(precio);
		// TODO review the generated test code and remove the default call to fail.
		assertEquals(precio, instance.getPrecio(), 0.0);
	}

	/**
	 * Test of getImagenes method, of class Servicio.
	 */
	@Test
	public void testGetImagenes() {
		System.out.println("getImagenes");
		Set<String> expResult = new HashSet();
		Set<String> result = instance.getImagenes();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of setImagenes method, of class Servicio.
	 */
	@Test
	public void testSetImagenes() {
		System.out.println("setImagenes");
		imagenes = new HashSet();
		instance.setImagenes(imagenes);
		// TODO review the generated test code and remove the default call to fail.
		assertEquals(imagenes, instance.getImagenes());
	}

	/**
	 * Test of getOrigen method, of class Servicio.
	 */
	@Test
	public void testGetOrigen() {
		System.out.println("getOrigen");
		Ciudad expResult = origen;
		Ciudad result = instance.getOrigen();
		assertEquals(expResult.toString(), result.toString());
	}

	/**
	 * Test of setOrigen method, of class Servicio.
	 */
	@Test
	public void testSetOrigen() {
		System.out.println("setOrigen");
		origen = null;
		instance.setOrigen(origen);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of getDestino method, of class Servicio.
	 */
	@Test
	public void testGetDestino() {
		System.out.println("getDestino");
		Ciudad expResult = null;
		Ciudad result = instance.getDestino();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of setDestino method, of class Servicio.
	 */
	@Test
	public void testSetDestino() {
		System.out.println("setDestino");
		destino = null;
		instance.setDestino(destino);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of getProveedor method, of class Servicio.
	 */
	@Test
	public void testGetProveedor() {
		System.out.println("getProveedor");
		Proveedor expResult = proveedor;
		Proveedor result = instance.getProveedor();
		assertEquals(expResult, result);
	}
    
    /**
	 * Test of getNicknameProveedor method, of class Servicio.
	 */
	@Test
	public void testGetNicknameProveedor() {
		System.out.println("getNicknameProveedor");
		String expResult = instance.getProveedor().getNickname();
		assertEquals(expResult, instance.getNicknameProveedor());
	}

	/**
	 * Test of setProveedor method, of class Servicio.
	 */
	@Test
	public void testSetProveedor() {
		System.out.println("setProveedor");
		proveedor = null;

		instance.setProveedor(proveedor);
	}
    
    /**
	 * Tests of contieneTermino method, of class Servicio.
	 */
    @Test
	public void testContieneTermino0() {
		System.out.println("contieneTermino Positivo en IdServicio");
        assertTrue(instance.contieneTermino("serv"));
	}
    
	@Test
	public void testContieneTermino1() {
		System.out.println("contieneTermino Positivo en Descripcion");
		assertTrue(instance.contieneTermino("escrip"));
	}
    
    @Test
	public void testContieneTermino2() {
		System.out.println("contieneTermino Negativo");
		assertFalse(instance.contieneTermino("un termino que no este"));
	}
    
    @Test
	public void testContieneTermino3() {
		System.out.println("contieneTermino Positivo en Cateoria");
		instance.agregarCategoria(new Simple("Relax"));
        assertTrue(instance.contieneTermino("Relax"));
	}
    
    @Test
	public void testContieneTermino4() {
		System.out.println("contieneTermino Negativo en Cateoria");
		instance.agregarCategoria(new Simple("Relax"));
        assertFalse(instance.contieneTermino("Fiesta"));
	}

    /**
     * Test of getCantAccesos method, of class Servicio.
     */
    @Test
    public void testGetCantAccesos() {
        System.out.println("getCantAccesos");
        int expResult = 0;
        int result = instance.getCantAccesos();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of agregarAcceso method, of class Servicio.
     */
    @Test
    public void testAgregarAcceso() {
        System.out.println("agregarAcceso");
        instance.agregarAcceso();
        assertEquals(1, instance.getCantAccesos());
    }
    
    
}
