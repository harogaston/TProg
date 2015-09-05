/*
 * Header Test
 */
package com.tprog.logica.manejadores;

import com.tprog.logica.clases.Cliente;
import com.tprog.logica.clases.Reserva;
import com.tprog.logica.dt.DTLineaReserva;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.EstadoReserva;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author MarG
 */
public class ManejadorReservasTest {

    ManejadorReservas instance;
    
    Set<DTMinReserva> minR;
    Set<DTLineaReserva> set;
    Reserva r1;
    DTReserva dtr1;
    Cliente jorge;
    int aux;

    public ManejadorReservasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        instance = ManejadorReservas.getInstance();
        Date fecha = new Date();
        DTLineaReserva l1 = new DTLineaReserva(1, fecha, fecha, "idServicio1", "", 10);
               // DTLineaReserva l2 = new DTLineaReserva(2, fecha, fecha, "", "idPromocion2", 20);
        //DTLineaReserva l3 = new DTLineaReserva(3, fecha, fecha, "idServicio3", "", 30);
        set = new HashSet();
        set.add(l1);
		//set.add(l2);
        //set.add(l3);
        // r1 = new Reserva(fecha,EstadoReserva.Registrada,500,set,"jorge");
        dtr1 = new DTReserva(-1, fecha, EstadoReserva.Registrada, 500, set);
               // Reserva r2 = new Reserva(fecha,EstadoReserva.Registrada,300,set,"pepito");
        // DTReserva dtr2 = new DTReserva(r2.getIdReserva(),fecha,EstadoReserva.Registrada,300,set);
        //  Reserva r3 = new Reserva(fecha,EstadoReserva.Registrada,100,set,"gg");
        //DTReserva dtr3 = new DTReserva(r3.getIdReserva(),fecha,EstadoReserva.Registrada,100,set);
        jorge = new Cliente("alguien", "alg", "apellido", "email", "imagen", fecha);

        instance.agregarReserva(jorge, dtr1, "jorge");
        Set<DTMinReserva> lista = instance.listarReservas();
        Iterator<DTMinReserva> it;
        DTMinReserva dt = lista.iterator().next();
        aux = dt.getIdReserva();
        dtr1 = new DTReserva(aux, fecha, EstadoReserva.Registrada, 500, set);
        minR = new HashSet();
        DTMinReserva dtmin = new DTMinReserva(aux, fecha);
        minR.add(dtmin);
                //minR.add(r2.crearDTMinReserva());
        //minR.add(r2.crearDTMinReserva());
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class ManejadorReservas.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ManejadorReservas expResult = instance;
        ManejadorReservas result = ManejadorReservas.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of listarReservas method, of class ManejadorReservas.
     */
    @Test
    public void testListarReservas() {
        System.out.println("listarReservas");

        Set<DTMinReserva> expResult = minR;
        Set<DTMinReserva> result = instance.listarReservas();
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of infoReserva method, of class ManejadorReservas.
     */
    @Test
    public void testInfoReserva() {
        System.out.println("infoReserva");

        DTReserva expResult = dtr1;
        DTReserva result = instance.infoReserva(aux);
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of cambiarEstadoReserva method, of class ManejadorReservas.
     */
    @Test
    public void testCambiarEstadoReserva() {
        System.out.println("cambiarEstadoReserva");

        EstadoReserva nuevoEstado = EstadoReserva.Pagada;

        boolean expResult = true;
        boolean result = instance.cambiarEstadoReserva(aux, nuevoEstado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of eliminarReserva method, of class ManejadorReservas.
     */
    @Test
    public void testEliminarReserva() {
        System.out.println("eliminarReserva");

        instance.eliminarReserva(aux);
        // TODO review the generated test code and remove the default call to fail.
        assertFalse(instance.getReservas().containsKey(aux));
    }

    /**
     * Test of agregarReserva method, of class ManejadorReservas.
     */
    @Test
    public void testAgregarReserva() throws Exception {
        System.out.println("agregarReserva");

        instance.agregarReserva(jorge, dtr1, "jorge");
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.getReservas().containsKey(aux+1));
    }

    
    @Test
    public void testGetEstadoReserva(){
        System.out.println("getEstadoReserva");
        EstadoReserva estado = instance.getEstadoReserva(aux);
        assertEquals(EstadoReserva.Registrada,estado);
    }

}
