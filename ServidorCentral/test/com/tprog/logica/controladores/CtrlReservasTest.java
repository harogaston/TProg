 /* Header Test
 */
package com.tprog.logica.controladores;

import com.tprog.logica.clases.Cliente;
import com.tprog.logica.clases.Promocion;
import com.tprog.logica.clases.Proveedor;
import com.tprog.logica.clases.Servicio;
import com.tprog.logica.dt.DTLineaReserva;
import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.EstadoReserva;
import com.tprog.logica.manejadores.ManejadorProductos;
import com.tprog.logica.manejadores.ManejadorReservas;
import com.tprog.logica.manejadores.ManejadorUsuarios;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author MarG
 */
public class CtrlReservasTest {

    CtrlReservas instance;
    String nickname;
    String nicknameP;
    DTMinPromocion dtP;
    DTMinServicio dtS;
    DTReserva dtR;
    int idReserva;
    
    float precioTotal;
    Date fecha;
    Proveedor prov;
    Set<String> vacio;

    public CtrlReservasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new CtrlReservas();
        fecha = new Date();
        Proveedor prov = new Proveedor("nick", "nom", "ap", "email", "imagen", fecha, "empresa", "webEmpresa");
        nicknameP = prov.getNickname();
        DTLineaReserva l1 = new DTLineaReserva(1, fecha, fecha, "idServicio1", "", 10);
        Set<DTLineaReserva> set = new HashSet();
        set.add(l1);
		Cliente jorge = new Cliente("alguien", "alg", "apellido", "email", "imagen", fecha);
        Servicio ser = new Servicio("idServicio", "descripcion", 50, null, null, null, prov);
        Promocion promo = new Promocion("idPromocion", 20, prov);
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        ManejadorProductos mp = ManejadorProductos.getInstance();
        vacio = null;
        mu.altaProveedor(prov.crearDT());
        //mp.altaPromocion("idPromocion", 20, "nick", vacio);
        mu.altaCliente(jorge.crearDT());
        
        instance.seleccionarProveedor("nick");
        //mp.altaServicio(ser.crearDT(),"nick",vacio);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of seleccionarCliente method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarCliente() {
        System.out.println("seleccionarCliente");
        String nickname = "";
        instance.seleccionarCliente(nickname);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(nickname,instance.getNickname());

    }

    /**
     * Test of seleccionarProveedor method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarProveedor() {
        System.out.println("seleccionarProveedor");
        String nicknameP = "nick";
        instance.seleccionarProveedor(nicknameP);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(nicknameP,instance.getNicknameP());

    }

    /**
     * Test of listarPromociones method, of class CtrlReservas.
     */
    @Test
    public void testListarPromociones() {
        System.out.println("listarPromociones");

        Set<DTMinPromocion> expResult = new HashSet();
        Set<DTMinPromocion> result = instance.listarPromociones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of listarServicios method, of class CtrlReservas.
     */
    @Test
    public void testListarServicios() {
        System.out.println("listarServicios");

        Set<DTMinServicio> expResult = new HashSet();
        Set<DTMinServicio> result = instance.listarServicios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of seleccionarPromocion method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarPromocion() {
        System.out.println("seleccionarPromocion");
        DTMinPromocion dtP = new DTMinPromocion(this.nicknameP, "promo");

        instance.seleccionarPromocion(dtP);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(dtP.equals(instance.getDtP()));

    }

    /**
     * Test of seleccionarServicio method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarServicio() {
        System.out.println("seleccionarServicio");
        DTMinServicio dtS = new DTMinServicio(this.nicknameP, "bueno");

        instance.seleccionarServicio(dtS);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(dtS.equals(instance.getDtS()));

    }

    /**
     * Test of seleccionarDTReserva method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarDTReserva() {
        System.out.println("seleccionarDTReserva");
        DTReserva dtR = null;

        instance.seleccionarDTReserva(dtR);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(dtR,instance.getDtR());

    }

    /**
     * Test of ingresarLineaReserva method, of class CtrlReservas.
     */
    @Test
    public void testIngresarLineaReserva() {
        System.out.println("ingresarLineaReserva");
        this.dtS = new DTMinServicio("nick", "bueno");
        instance.seleccionarServicio(null);
        instance.ingresarLineaReserva(3, fecha, fecha);
        // TODO review the generated test code and remove the default call to fail.
        //en deuda

    }

    /**
     * Test of listarServiciosProveedor method, of class CtrlReservas.
     */
    @Test
    public void testListarServiciosProveedor() {
        System.out.println("listarServiciosProveedor");
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        ManejadorProductos mp = ManejadorProductos.getInstance();
        Cliente jorge = new Cliente("alguien", "alg", "apellido", "email", "imagen", fecha);
        mu.altaCliente(jorge.crearDT());
        
        Set<DTMinServicio> expResult = new HashSet();
        Set<DTMinServicio> result = instance.listarServiciosProveedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of listarPromocionesProveedor method, of class CtrlReservas.
     */
    @Test
    public void testListarPromocionesProveedor() {
        System.out.println("listarPromocionesProveedor");

        Set<DTMinPromocion> expResult = new HashSet();
        Set<DTMinPromocion> result = instance.listarPromocionesProveedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of mostrarReservaTemporal method, of class CtrlReservas.
     */
    @Test
    public void testMostrarReservaTemporal() {
        System.out.println("mostrarReservaTemporal");

        DTReserva expResult = new DTReserva(-1, fecha, EstadoReserva.Registrada, 0,null);
        DTReserva result = instance.mostrarReservaTemporal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of altaReserva method, of class CtrlReservas.
     */
    @Test
    public void testAltaReserva() throws Exception {
        System.out.println("altaReserva");
        this.dtS = new DTMinServicio("nick", "bueno");
        instance.seleccionarServicio(dtS);
        instance.altaReserva();
        //agrego servicio
        // TODO review the generated test code and remove the default call to fail.
        instance.seleccionarServicio(null);
        this.dtP = new DTMinPromocion("nick","idPromocion");
        instance.seleccionarPromocion(dtP);
        instance.altaReserva();
        //agrego promocion
        instance.seleccionarServicio(null);
        instance.seleccionarPromocion(null);
        instance.altaReserva();
        //espero q muera
    }

    /**
     * Test of listarReservas method, of class CtrlReservas.
     */
    @Test
    public void testListarReservas() {
        System.out.println("listarReservas");

        Set<DTMinReserva> expResult = new HashSet();
        Set<DTMinReserva> result = instance.listarReservas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of seleccionarReserva method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarReserva() {
        System.out.println("seleccionarReserva");
        
        instance.seleccionarReserva(80);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(80,instance.getIdReserva());

    }

    /**
     * Test of infoReserva method, of class CtrlReservas.
     */
    @Test
    public void testInfoReserva() {
        System.out.println("infoReserva");

        DTReserva expResult = null;
        DTReserva result = instance.infoReserva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of cambiarEstadoReserva method, of class CtrlReservas.
     */
    @Test
    public void testCambiarEstadoReserva() {
        System.out.println("cambiarEstadoReserva");
        EstadoReserva nuevoEstado = EstadoReserva.Pagada;

        boolean expResult = false;
        boolean result = instance.cambiarEstadoReserva(nuevoEstado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of eliminarReserva method, of class CtrlReservas.
     */
    @Test
    public void testEliminarReserva() {
        System.out.println("eliminarReserva");
        Cliente jorge = new Cliente("alguien", "alg", "apellido", "email", "imagen", fecha);

        Servicio ser = new Servicio("idServicio", "descripcion", 50, null, null, null, prov);
        this.dtS = new DTMinServicio("nick", "idServicio");
        instance.eliminarReserva();
        // TODO review the generated test code and remove the default call to fail.

    }
    
    @Test
    public void getEstadoReserva(){
        System.out.println("getEstadoReserva");
        instance.getEstadoReserva();
    }
    
    @Test
    public void liberarMemoriaControlador(){
        System.out.println("liberarMemoriaControlador");
        instance.liberarMemoriaControlador();
        assertEquals(instance.getNickname(),null);
        assertEquals(instance.getNicknameP(),null);
        assertEquals(instance.getDtS(),null);
        assertEquals(instance.getDtR(),null);
        assertEquals(instance.getDtS(),null);
        assertEquals(instance.getIdReserva(),-1);
        assertEquals(instance.getPrecioTotal(),0,0);
        Set<DTLineaReserva> set = new HashSet();
        assertEquals(instance.getLineasReserva(),set);
        
        
    }

}
