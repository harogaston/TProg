/*
 * Header Test
 */
package com.tprog.logica.manejadores;

import com.tprog.logica.clases.Categoria;
import com.tprog.logica.clases.Ciudad;
import com.tprog.logica.clases.Pais;
import com.tprog.logica.clases.Proveedor;
import com.tprog.logica.clases.Simple;
import com.tprog.logica.dt.DTMinPromocion;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sofia
 */
public class ManejadorProductosTest{
    
    ManejadorProductos instance;
    
    public ManejadorProductosTest() {
    }
    
    @Before
    public void setUp() {
        instance = ManejadorProductos.getInstance();
        Proveedor prov = new Proveedor("Harry Dresden", "Harry", "Dresden", "noUsoEmail@protonmail.com",
			"Wizard", new Date(1984, 07, 16), "Charmed", "NotHaveWeb.com");
    }
    
    @After
    public void tearDown(){
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
        Pais p = new Pais("USA");
        Ciudad chicago = new Ciudad("Chicago");
        p.agregarCiudad(chicago);
        instance.agregarPais(p);
        assertTrue(!instance.ubicaciones.isEmpty());
        assertEquals(1, instance.ubicaciones.size());
        assertTrue(instance.ubicaciones.containsKey("USA"));
    }

    /**
     * Test of listarCiudades method, of class ManejadorProductos.
     */
    @Test
    public void testListarCiudadesVacio() {
        System.out.println("listarCiudadesVacio");
        DefaultMutableTreeNode result = instance.listarCiudades();
        assertTrue(result.isRoot());
        assertEquals(0, instance.ubicaciones.size());
        assertEquals(0, result.getChildCount());
    }
    
    /**
     * Test of listarCiudades method, of class ManejadorProductos.
     */
    @Test
    public void testListarCiudades() {
        System.out.println("listarCiudades");
        Pais p = new Pais("Uruguay");
        Ciudad chuy = new Ciudad("Chuy");
        p.agregarCiudad(chuy);
        instance.agregarPais(p);
        DefaultMutableTreeNode result = instance.listarCiudades();
        assertTrue(result.isRoot());
        assertEquals(1, result.getChildCount());
        assertEquals("Uruguay", result.getFirstChild().toString());
        assertEquals(1, result.getFirstChild().getChildCount());
        assertEquals("Chuy", result.getFirstLeaf().toString());
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
        assertTrue(result.isLeaf());
        assertEquals("Categorias", result.getRoot().toString());
    }
    
    /**
     * Test of altaCategoria method, of class ManejadorProductos.
     */
    @Test
    public void testAltaCategoriaToRoot() {
        System.out.println("altaCategoria");
        String idCategoria = "NewCategoria";
        instance.altaCategoria(idCategoria, null);
        assertEquals(2, instance.categorias.size());
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
    public void testAltaCategoria() {
        System.out.println("altaCategoria");
        String idCategoria = "NewCategoria";
        instance.altaCategoria(idCategoria, null);
        instance.altaCategoria("BabyCategoria", "NewCategoria");
        assertEquals(3, instance.categorias.size());
        assertTrue(instance.categorias.containsKey("BabyCategoria"));
        Categoria baby = instance.categorias.get("BabyCategoria");
        Categoria newC = instance.categorias.get("NewCategoria");
        assertTrue(newC.esCategoriaPadre()); 
        assertFalse(newC.esCategoriaSimple());
        assertTrue(baby.esCategoriaSimple());
        assertEquals(newC, baby.getPadre());
    }
    
    /**
     * Test of idServicioDisponible method, of class ManejadorProductos.
     */
    @Test
    public void testIdServicioDisponibleFails() {
        System.out.println("idServicioDisponible");
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
    public void testListarServicios() {
        System.out.println("listarServicios");
        assertTrue(instance.listarServicios().isEmpty());
    }
    
    /**
     * Test of listarPromociones method, of class ManejadorProductos.
     */
    @Test
    public void testListarPromociones() {
        System.out.println("listarPromociones");
        assertTrue(instance.listarPromociones().isEmpty());
    }
    
    /**
     * Test of altaServicio method, of class ManejadorProductos.
     */
    /*@Test
    public void testAltaServicio() {
        System.out.println("altaServicio");
        DTServicio dtS = null;
        String nicknameP = "";
        Set<String> listaCategorias = null;
        ManejadorProductos instance = null;
        instance.altaServicio(dtS, nicknameP, listaCategorias);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of infoPromocion method, of class ManejadorProductos.
     */
    /*@Test
    public void testInfoPromocion() {
        System.out.println("infoPromocion");
        
        DTMinPromocion dtP = DTMinPromocion("Mister", "Chicago Flight");
        
        ManejadorProductos instance = null;
        DTPromocion expResult = null;
        DTPromocion result = instance.infoPromocion(dtP);
        assertEquals(expResult, result);
    }*/

    /**
     * Test of infoServicio method, of class ManejadorProductos.
     */
    /*@Test
    public void testInfoServicio() {
        System.out.println("infoServicio");
        DTMinServicio dtS = null;
        ManejadorProductos instance = null;
        DTServicio expResult = null;
        DTServicio result = instance.infoServicio(dtS);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of listarServiciosCategoria method, of class ManejadorProductos.
     */
    /*@Test
    public void testListarServiciosCategoria() {
        System.out.println("listarServiciosCategoria");
        String cat = "";
        ManejadorProductos instance = null;
        Set<DTMinServicio> expResult = null;
        Set<DTMinServicio> result = instance.listarServiciosCategoria(cat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of cambiarPrecio method, of class ManejadorProductos.
     */
    /*@Test
    public void testCambiarPrecio() {
        System.out.println("cambiarPrecio");
                
        DTMinServicio dtS = new DTMinServicio("Harry Dresden", "Chicago Flight");
        float nuevoPrecio = 250;
        instance.cambiarPrecio(dtS, nuevoPrecio);
        
    }*/

    /**
     * Test of cambiarDescripcion method, of class ManejadorProductos.
     */
    /*@Test
    public void testCambiarDescripcion() {
        System.out.println("cambiarDescripcion");
        DTMinServicio dtS = null;
        String descripcion = "";
        ManejadorProductos instance = null;
        instance.cambiarDescripcion(dtS, descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of listarImagenes method, of class ManejadorProductos.
     */
    /*@Test
    public void testListarImagenes() {
        System.out.println("listarImagenes");
        DTMinServicio dtS = null;
        ManejadorProductos instance = null;
        Set<String> expResult = null;
        Set<String> result = instance.listarImagenes(dtS);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of agregarImagen method, of class ManejadorProductos.
     */
    /*@Test
    public void testAgregarImagen() throws Exception {
        System.out.println("agregarImagen");
        DTMinServicio dtS = null;
        String img = "";
        ManejadorProductos instance = null;
        instance.agregarImagen(dtS, img);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of quitarImagen method, of class ManejadorProductos.
     */
    /*@Test
    public void testQuitarImagen() throws Exception {
        System.out.println("quitarImagen");
        DTMinServicio dtS = null;
        String img = "";
        ManejadorProductos instance = null;
        instance.quitarImagen(dtS, img);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of cambiarOrigen method, of class ManejadorProductos.
     */
    /*@Test
    public void testCambiarOrigen() {
        System.out.println("cambiarOrigen");
        DTMinServicio dtS = null;
        DTUbicacion dtU = null;
        ManejadorProductos instance = null;
        instance.cambiarOrigen(dtS, dtU);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of cambiarDestino method, of class ManejadorProductos.
     */
    /*@Test
    public void testCambiarDestino() {
        System.out.println("cambiarDestino");
        DTMinServicio dtS = null;
        DTUbicacion dtU = null;
        ManejadorProductos instance = null;
        instance.cambiarDestino(dtS, dtU);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of listarCategoriasServicio method, of class ManejadorProductos.
     */
    /*@Test
    public void testListarCategoriasServicio() {
        System.out.println("listarCategoriasServicio");
        DTMinServicio dtS = null;
        ManejadorProductos instance = null;
        Set<String> expResult = null;
        Set<String> result = instance.listarCategoriasServicio(dtS);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/


    /**
     * Test of esCategoriaSimpleAgregar method, of class ManejadorProductos.
     */
    /*@Test
    public void testEsCategoriaSimpleAgregar() {
        System.out.println("esCategoriaSimpleAgregar");
        DTMinServicio dtS = null;
        String cat = "";
        ManejadorProductos instance = null;
        boolean expResult = false;
        boolean result = instance.esCategoriaSimpleAgregar(dtS, cat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of esCategoriaSimpleQuitar method, of class ManejadorProductos.
     */
    /*@Test
    public void testEsCategoriaSimpleQuitar() {
        System.out.println("esCategoriaSimpleQuitar");
        DTMinServicio dtS = null;
        String cat = "";
        ManejadorProductos instance = null;
        boolean expResult = false;
        boolean result = instance.esCategoriaSimpleQuitar(dtS, cat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of esCategoriaSimple method, of class ManejadorProductos.
     */
    /*@Test
    public void testEsCategoriaSimple() {
        System.out.println("esCategoriaSimple");
        String cat = "";
        ManejadorProductos instance = null;
        boolean expResult = false;
        boolean result = instance.esCategoriaSimple(cat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of idPromocionDisponible method, of class ManejadorProductos.
     */
    /*@Test
    public void testIdPromocionDisponible() {
        System.out.println("idPromocionDisponible");
        String idPromocion = "";
        String nicknameProv = "";
        ManejadorProductos instance = null;
        boolean expResult = false;
        boolean result = instance.idPromocionDisponible(idPromocion, nicknameProv);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of altaPromocion method, of class ManejadorProductos.
     */
    /*@Test
    public void testAltaPromocion() {
        System.out.println("altaPromocion");
        String idPromocion = "";
        float descuento = 0.0F;
        String nicknameProv = "";
        Set<String> servicios = null;
        ManejadorProductos instance = null;
        instance.altaPromocion(idPromocion, descuento, nicknameProv, servicios);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getPrecioPromocion method, of class ManejadorProductos.
     */
    /*@Test
    public void testGetPrecioPromocion() {
        System.out.println("getPrecioPromocion");
        DTMinPromocion dtP = null;
        ManejadorProductos instance = null;
        float expResult = 0.0F;
        float result = instance.getPrecioPromocion(dtP);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getPrecioServicio method, of class ManejadorProductos.
     */
    /*@Test
    public void testGetPrecioServicio() {
        System.out.println("getPrecioServicio");
        DTMinServicio dtS = null;
        ManejadorProductos instance = null;
        float expResult = 0.0F;
        float result = instance.getPrecioServicio(dtS);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getServicio method, of class ManejadorProductos.
     */
    /*@Test
    public void testGetServicio() {
        System.out.println("getServicio");
        DTMinServicio dtMinS = null;
        ManejadorProductos instance = null;
        Servicio expResult = null;
        Servicio result = instance.getServicio(dtMinS);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getPromocion method, of class ManejadorProductos.
     */
    /*@Test
    public void testGetPromocion() {
        System.out.println("getPromocion");
        DTMinPromocion dtMinP = null;
        ManejadorProductos instance = null;
        Promocion expResult = null;
        Promocion result = instance.getPromocion(dtMinP);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
