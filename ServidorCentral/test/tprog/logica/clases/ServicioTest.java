/*
 * Header Test
 */
package tprog.logica.clases;

import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUbicacion;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MarG
 */
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
        instance = new Servicio("idServicio", "descripcion", 50, imagenes,null,null,null);
        Date fecha = new Date();
        origen = new Ciudad("Montevideo");
        Pais pais = new Pais("Uruguay");
        origen.setPais(pais);
        instance.setOrigen(origen);
        proveedor = new Proveedor("nick","pass","nom","ap","email",
			"imagen",fecha,"empresa","webEmpresa");
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
        
        DTServicio expResult = new DTServicio("idServicio","descripcion", 50,null,origen.crearDT(),null);
        DTServicio result = instance.crearDT();
        boolean prim = (expResult.toString().equals(result.toString()));
        destino = new Ciudad("Colonia");
        Pais pais = new Pais("Brasil");
        destino.setPais(pais);
        instance.setDestino(destino);
        DTServicio expResult2 = new DTServicio("idServicio","descripcion", 50,null,origen.crearDT(),destino.crearDT());
        DTServicio result2 = instance.crearDT();
        boolean prim2 = (expResult2.toString().equals(result2.toString()));
        assertEquals(prim,prim2);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of crearDTMin method, of class Servicio.
     */
    @Test
    public void testCrearDTMin() {
        System.out.println("crearDTMin");
        
        DTMinServicio expResult = new DTMinServicio("nick","idServicio");
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
        Categoria c = new Simple("idCategoria");
        boolean random = instance.agregarCategoria(c);
        Set<String> result = instance.listarCategorias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of agregarCategoria method, of class Servicio.
     */
    @Test
    public void testAgregarCategoria() {
        System.out.println("agregarCategoria");
        Categoria c = new Simple("idCategoria");
        boolean expResult = true;
        boolean result = instance.agregarCategoria(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of quitarCategoria method, of class Servicio.
     */
    @Test
    public void testQuitarCategoria() {
        System.out.println("quitarCategoria");
        Categoria c = new Simple("idCategoria");
        boolean entro = instance.agregarCategoria(c); 
        Categoria categoria_a_quitar = c;
        
        boolean expResult = true;
        boolean result = instance.quitarCategoria(categoria_a_quitar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
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
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setIdServicio method, of class Servicio.
     */
    @Test
    public void testSetIdServicio() {
        System.out.println("setIdServicio");
        String id = "";
        instance.setIdServicio(id);
        assertEquals(id, instance.getIdServicio());
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
        float precio = 20;
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
        Set<String> imagenes = new HashSet();
        instance.setImagenes(imagenes);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(imagenes,instance.getImagenes());
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
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setOrigen method, of class Servicio.
     */
    @Test
    public void testSetOrigen() {
        System.out.println("setOrigen");
        Ciudad origen = null;
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
        Ciudad destino = null;
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
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setProveedor method, of class Servicio.
     */
    @Test
    public void testSetProveedor() {
        System.out.println("setProveedor");
        Proveedor proveedor = null;
        
        instance.setProveedor(proveedor);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
