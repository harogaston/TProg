/*
 * Header Test
 */
package com.tprog.logica.controladores;

import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.manejadores.ManejadorProductos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sofia
 */
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
    /*@Test
    public void testListarPromociones() {
        System.out.println("listarPromociones");
       
    }*/
    
    /**
     * Test of infoPromocion method, of class CtrlProductos.
     */
    /*@Test
    public void testInfoPromocion() {
        System.out.println("infoPromocion");
        CtrlProductos instance = new CtrlProductos();
        DTPromocion expResult = null;
        DTPromocion result = instance.infoPromocion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of infoMinPromocion method, of class CtrlProductos.
     */
    /*@Test
    public void testInfoMinPromocion() {
        System.out.println("infoMinPromocion");
        CtrlProductos instance = new CtrlProductos();
        DTMinPromocion expResult = null;
        DTMinPromocion result = instance.infoMinPromocion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    /*@Test
    public void testInfoServicio() {
        System.out.println("infoServicio");
        CtrlProductos instance = new CtrlProductos();
        DTServicio expResult = null;
        DTServicio result = instance.infoServicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of infoMinServicio method, of class CtrlProductos.
     */
    /*@Test
    public void testInfoMinServicio() {
        System.out.println("infoMinServicio");
        CtrlProductos instance = new CtrlProductos();
        DTMinServicio expResult = null;
        DTMinServicio result = instance.infoMinServicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    /*@Test
    public void testListarServiciosCategoria() {
        System.out.println("listarServiciosCategoria");
        String idCategoria = "";
        CtrlProductos instance = new CtrlProductos();
        Set<DTMinServicio> expResult = null;
        Set<DTMinServicio> result = instance.listarServiciosCategoria(idCategoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarServicios method, of class CtrlProductos.
     */
    /*@Test
    public void testListarServicios() {
        System.out.println("listarServicios");
        CtrlProductos instance = new CtrlProductos();
        Set<DTMinServicio> expResult = null;
        Set<DTMinServicio> result = instance.listarServicios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarImagenes method, of class CtrlProductos.
     */
    /*@Test
    public void testListarImagenes() {
        System.out.println("listarImagenes");
        CtrlProductos instance = new CtrlProductos();
        Set<String> expResult = null;
        Set<String> result = instance.listarImagenes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    /*@Test
    public void testListarCiudades() {
        System.out.println("listarCiudades");
        CtrlProductos instance = new CtrlProductos();
        DefaultMutableTreeNode expResult = null;
        DefaultMutableTreeNode result = instance.listarCiudades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    /*@Test
    public void testListarCategoriasServicio() {
        System.out.println("listarCategoriasServicio");
        CtrlProductos instance = new CtrlProductos();
        Set<String> expResult = null;
        Set<String> result = instance.listarCategoriasServicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    /*@Test
    public void testQuitarCategoria() {
        System.out.println("quitarCategoria");
        String idCategoria = "";
        CtrlProductos instance = new CtrlProductos();
        boolean expResult = false;
        boolean result = instance.quitarCategoria(idCategoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    /*@Test
    public void testIdCategoriaDisponible() {
        System.out.println("idCategoriaDisponible");
        String idCategoria = "";
        CtrlProductos instance = new CtrlProductos();
        boolean expResult = false;
        boolean result = instance.idCategoriaDisponible(idCategoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
     * Test of listarProveedores method, of class CtrlProductos.
     */
    /*@Test
    public void testListarProveedores() {
        System.out.println("listarProveedores");
        CtrlProductos instance = new CtrlProductos();
        Set<DTMinProveedor> expResult = null;
        Set<DTMinProveedor> result = instance.listarProveedores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarProveedor method, of class CtrlProductos.
     */
    /*@Test
    public void testSeleccionarProveedor() {
        System.out.println("seleccionarProveedor");
        String nick = "";
        CtrlProductos instance = new CtrlProductos();
        instance.seleccionarProveedor(nick);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of idServicioDisponible method, of class CtrlProductos.
     */
    /*@Test
    public void testIdServicioDisponible() {
        System.out.println("idServicioDisponible");
        String idServicio = "";
        CtrlProductos instance = new CtrlProductos();
        boolean expResult = false;
        boolean result = instance.idServicioDisponible(idServicio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarOrigen method, of class CtrlProductos.
     */
    /*@Test
    public void testSeleccionarOrigen() {
        System.out.println("seleccionarOrigen");
        DTUbicacion dtU = null;
        CtrlProductos instance = new CtrlProductos();
        instance.seleccionarOrigen(dtU);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarDestino method, of class CtrlProductos.
     */
    /*@Test
    public void testSeleccionarDestino() {
        System.out.println("seleccionarDestino");
        DTUbicacion dtU = null;
        CtrlProductos instance = new CtrlProductos();
        instance.seleccionarDestino(dtU);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarCategoriaSimple method, of class CtrlProductos.
     */
    /*@Test
    public void testSeleccionarCategoriaSimple() {
        System.out.println("seleccionarCategoriaSimple");
        String idCategoria = "";
        CtrlProductos instance = new CtrlProductos();
        boolean expResult = false;
        boolean result = instance.seleccionarCategoriaSimple(idCategoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
     * Test of listarServiciosProveedor method, of class CtrlProductos.
     */
    /*@Test
    public void testListarServiciosProveedor() {
        System.out.println("listarServiciosProveedor");
        CtrlProductos instance = new CtrlProductos();
        Set<DTMinServicio> expResult = null;
        Set<DTMinServicio> result = instance.listarServiciosProveedor();
        assertEquals(expResult, result);
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
    /*@Test
    public void testIdPromocionDisponible() {
        System.out.println("idPromocionDisponible");
        String idPromocion = "";
        CtrlProductos instance = new CtrlProductos();
        boolean expResult = false;
        boolean result = instance.idPromocionDisponible(idPromocion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
