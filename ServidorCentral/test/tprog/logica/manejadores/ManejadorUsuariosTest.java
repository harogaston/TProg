/*
 * Header Test
 */
package tprog.logica.manejadores;

import tprog.logica.clases.Ciudad;
import tprog.logica.clases.Cliente;
import tprog.logica.clases.Pais;
import tprog.logica.clases.Proveedor;
import tprog.logica.clases.Servicio;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTMinCliente;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinProveedor;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTServicio;
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
        proveedor = new Proveedor("nick", "pass", "nom", "ap", "email", "imagen", fecha,"empresa", "webEmpresa");
        dtP = new DTProveedor("nick", "pass", "nom", "ap", "email", "imagen", fecha,"empresa", "webEmpresa");
        instance.altaProveedor(dtP);
        cliente = new Cliente("nickname","pass", "nombre", "apellido","email2","imagen",  fecha);
        dtC = new DTCliente("nickname","pass", "nombre", "apellido","email2","imagen",  fecha, new HashSet());
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
        assertTrue(instance.verificarNickname("nicko"));
        assertFalse(instance.verificarNickname("nick"));
        
    }

    /**
     * Test of verificarEmail method, of class ManejadorUsuarios.
     */
    @Test
    public void testVerificarEmail() {
        System.out.println("verificarEmail");
        assertTrue(instance.verificarEmail("emailo"));
        assertFalse(instance.verificarEmail("email2"));
        assertFalse(instance.verificarEmail("email"));
        
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
