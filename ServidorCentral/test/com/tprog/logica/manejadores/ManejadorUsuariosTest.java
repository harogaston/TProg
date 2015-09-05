/*
 * Header Test
 */
package com.tprog.logica.manejadores;

import com.tprog.logica.clases.Ciudad;
import com.tprog.logica.clases.Cliente;
import com.tprog.logica.clases.Pais;
import com.tprog.logica.clases.Proveedor;
import com.tprog.logica.clases.Servicio;
import com.tprog.logica.dt.DTCliente;
import com.tprog.logica.dt.DTMinCliente;
import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinProveedor;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTProveedor;
import com.tprog.logica.dt.DTServicio;
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
public class ManejadorUsuariosTest {
    
    ManejadorUsuarios instance;
    Date fecha;
    DTProveedor dtP;
    Proveedor proveedor;
    DTCliente dtC;
    DTMinCliente dtmin;
    Cliente cliente;
    
    public ManejadorUsuariosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = ManejadorUsuarios.getInstance();
        Date fecha = new Date();
        proveedor = new Proveedor("nick", "nom", "ap", "email", "imagen", fecha,"empresa", "webEmpresa");
        dtP = new DTProveedor("nick", "nom", "ap", "email", "imagen", fecha,"empresa", "webEmpresa");
        instance.altaProveedor(dtP);
        cliente = new Cliente("nickname","nombre", "apellido","email2","imagen",  fecha);
        dtC = new DTCliente("nickname","nombre", "apellido","email2","imagen",  fecha, null);
        instance.altaCliente(dtC);
        dtmin = new DTMinCliente("nickname","email2");
        /*Ciudad origen = new Ciudad("Montevideo");
        Pais paisOrigen = new Pais("Uruguay");
        origen.setPais(paisOrigen);
        paisOrigen.agregarCiudad(origen);
        Ciudad destino = new Ciudad("brasilia");
        Pais pais2 = new Pais("Brasil");
        destino.setPais(pais2);
        pais2.agregarCiudad(destino);
        Set<String> set = new HashSet();
        set.add("hola");
        set.add("bola");
        Servicio servicio = new Servicio("idServicio","descripcion",50, set,origen,destino,proveedor);
        DTServicio dts = new DTServicio("idServicio", "descripcion", 50,set, origen.crearDT(),destino.crearDT());
        ManejadorProductos mp = ManejadorProductos.getInstance();
        mp.altaServicio(dts, "nick", set);*/
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class ManejadorUsuarios.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ManejadorUsuarios expResult = instance;
        ManejadorUsuarios result = ManejadorUsuarios.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of listarProveedores method, of class ManejadorUsuarios.
     */
    @Test
    public void testListarProveedores() {
        System.out.println("listarProveedores");
        DTMinProveedor dtmin = new DTMinProveedor("nick","email","empresa");
        Set<DTMinProveedor> expResult = new HashSet();
        expResult.add(dtmin);
        Set<DTMinProveedor> result = instance.listarProveedores();
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of listarServiciosProveedor method, of class ManejadorUsuarios.
     */
    @Test
    public void testListarServiciosProveedor() {
        System.out.println("listarServiciosProveedor");
        Set<DTMinServicio> expResult = new HashSet();
        //DTMinServicio dtmin = new DTMinServicio("nick","idServicio");
        //expResult.add(dtmin);
        Set<DTMinServicio> result = instance.listarServiciosProveedor("nick");
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of listarPromocionesProveedor method, of class ManejadorUsuarios.
     */
    @Test
    public void testListarPromocionesProveedor() {
        System.out.println("listarPromocionesProveedor");
        
        
        Set<DTMinPromocion> expResult = new HashSet();
        Set<DTMinPromocion> result = instance.listarPromocionesProveedor("nick");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of listarClientes method, of class ManejadorUsuarios.
     */
    @Test
    public void testListarClientes() throws Exception {
        System.out.println("listarClientes");
        Set<DTMinCliente> expResult = new HashSet();
        expResult.add(dtmin);
        Set<DTMinCliente> result = instance.listarClientes();
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of infoCliente method, of class ManejadorUsuarios.
     */
    @Test
    public void testInfoCliente() throws Exception {
        System.out.println("infoCliente");
        DTCliente expResult = dtC;
        DTCliente result = instance.infoCliente("nickname");
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of infoProveedor method, of class ManejadorUsuarios.
     */
    @Test
    public void testInfoProveedor() throws Exception {
        System.out.println("infoProveedor");
        DTProveedor expResult = dtP;
        DTProveedor result = instance.infoProveedor("nick");
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of verificarNickname method, of class ManejadorUsuarios.
     */
    @Test
    public void testVerificarNickname() {
        System.out.println("verificarNickname");
        boolean expResult = false;
        boolean result = instance.verificarNickname("nicko");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of verificarEmail method, of class ManejadorUsuarios.
     */
    @Test
    public void testVerificarEmail() {
        System.out.println("verificarEmail");
        boolean expResult = false;
        boolean result = instance.verificarEmail("emailo");
        boolean result2 = instance.verificarEmail("email2");
        boolean result3 = instance.verificarEmail("email");
        assertEquals(expResult, result);
        assertEquals(true,result2);
        assertEquals(true,result3);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of altaCliente method, of class ManejadorUsuarios.
     */
    @Test
    public void testAltaCliente() {
        System.out.println("altaCliente");
        
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.getClientes().containsKey("nickname"));
    }

    /**
     * Test of altaProveedor method, of class ManejadorUsuarios.
     */
    @Test
    public void testAltaProveedor() {
        System.out.println("altaProveedor");
        
        //ya di de alta dtP
        
        assertTrue(instance.getProveedores().containsKey("nick"));
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCliente method, of class ManejadorUsuarios.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        Cliente expResult = cliente;
        Cliente result = instance.getCliente("nickname");
        assertEquals(expResult.getNickname(), result.getNickname());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getProveedor method, of class ManejadorUsuarios.
     */
    @Test
    public void testGetProveedor() {
        System.out.println("getProveedor");
        
        Proveedor expResult = proveedor;
        Proveedor result = instance.getProveedor("nick");
        assertEquals(expResult.getNickname(), result.getNickname());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
