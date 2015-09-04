/*
 * Header Test
 */
package com.tprog.logica.controladores;

import com.tprog.logica.clases.Ciudad;
import com.tprog.logica.clases.Cliente;
import com.tprog.logica.clases.Proveedor;
import com.tprog.logica.clases.Reserva;
import com.tprog.logica.clases.Servicio;
import com.tprog.logica.dt.DTLineaReserva;
import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.EstadoReserva;
import com.tprog.logica.manejadores.ManejadorProductos;
import com.tprog.logica.manejadores.ManejadorUsuarios;
import java.util.Date;
import java.util.HashMap;
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
public class CtrlReservasTest {
    
    CtrlReservas instance;
    String nickname;
    String nicknameP;
    DTMinPromocion dtP;
    DTMinServicio dtS;
    DTReserva dtR;
    int idReserva;
    Set<DTLineaReserva> set;
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
            Proveedor prov = new Proveedor("nick","nom","ap", "email","imagen", fecha,"empresa", "webEmpresa");
            nicknameP = prov.getNickname();
            DTLineaReserva l1 = new DTLineaReserva(1, fecha, fecha, "idServicio1", "", 10);
               // DTLineaReserva l2 = new DTLineaReserva(2, fecha, fecha, "", "idPromocion2", 20);
		//DTLineaReserva l3 = new DTLineaReserva(3, fecha, fecha, "idServicio3", "", 30);
                set = new HashSet();
		set.add(l1);
		//set.add(l2);
		//set.add(l3);
                //Reserva r1 = new Reserva(fecha,EstadoReserva.Registrada,500,set,"nick");
                //DTReserva dtr1 = new DTReserva(-1,fecha,EstadoReserva.Registrada,500,set);
                Cliente jorge = new Cliente("alguien","alg","apellido", "email", "imagen", fecha);
                Servicio ser = new Servicio("idServicio","descripcion", 50, null, null, null,prov);
                ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
                ManejadorProductos mp = ManejadorProductos.getInstance();
                vacio = null;
                mu.altaCliente(jorge.crearDT());
                mu.altaProveedor(prov.crearDT());
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
        
    }

    /**
     * Test of listarPromociones method, of class CtrlReservas.
     */
    @Test
    public void testListarPromociones() {
        System.out.println("listarPromociones");
        
        Set<DTMinPromocion> expResult = null;
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
        
        Set<DTMinServicio> expResult = null;
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
        DTMinPromocion dtP = new DTMinPromocion(this.nicknameP,"promo");
        
        instance.seleccionarPromocion(dtP);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of seleccionarServicio method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarServicio() {
        System.out.println("seleccionarServicio");
        DTMinServicio dtS = new DTMinServicio(this.nicknameP,"bueno");
        
        instance.seleccionarServicio(dtS);
        // TODO review the generated test code and remove the default call to fail.
        
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
        
    }

    /**
     * Test of ingresarLineaReserva method, of class CtrlReservas.
     */
    @Test
    public void testIngresarLineaReserva() {
        System.out.println("ingresarLineaReserva");
        int cant = 0;
        Date fecha = new Date();
        this.dtS = new DTMinServicio("nick","bueno");
        instance.ingresarLineaReserva(cant, fecha, fecha);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of listarServiciosProveedor method, of class CtrlReservas.
     */
    @Test
    public void testListarServiciosProveedor() {
        System.out.println("listarServiciosProveedor");
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        ManejadorProductos mp = ManejadorProductos.getInstance();
        Cliente jorge = new Cliente("alguien","alg","apellido", "email", "imagen", fecha);
        mu.altaCliente(jorge.crearDT());
        mu.altaProveedor(prov.crearDT());
        Set<DTMinServicio> expResult = null;
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
        
        Set<DTMinPromocion> expResult = null;
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
        
        DTReserva expResult = null;
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
        this.dtS = new DTMinServicio("nick","bueno");
        instance.seleccionarServicio(dtS);
        instance.altaReserva();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of listarReservas method, of class CtrlReservas.
     */
    @Test
    public void testListarReservas() {
        System.out.println("listarReservas");
        
        Set<DTMinReserva> expResult = null;
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
        
        
        instance.seleccionarReserva(idReserva);
        // TODO review the generated test code and remove the default call to fail.
        
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
        
        boolean expResult = true;
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
        Cliente jorge = new Cliente("alguien","alg","apellido", "email", "imagen", fecha);
       
        Servicio ser = new Servicio("idServicio","descripcion", 50, null, null, null,prov);
        this.dtS = new DTMinServicio("nick","idServicio");
        instance.eliminarReserva();
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
