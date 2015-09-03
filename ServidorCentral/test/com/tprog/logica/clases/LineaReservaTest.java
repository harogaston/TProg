/*
 * Header Test
 */
package com.tprog.logica.clases;

import com.tprog.logica.dt.DTLineaReserva;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LineaReservaTest {
    
    Servicio servicio;
    Promocion promocion;
    LineaReserva instance;
    Date fecha;
    
    public LineaReservaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        fecha = new Date();
        
        promocion = null;
        servicio = new Servicio("ser","bueno",50,null,null,null,null);
        instance = new LineaReserva(2,fecha,fecha,servicio,promocion,50);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCantidad method, of class LineaReserva.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        
        int expResult = 2;
        int result = instance.getCantidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getFechaInicio method, of class LineaReserva.
     */
    @Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        
        Date expResult = fecha;
        Date result = instance.getFechaInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getFechaFin method, of class LineaReserva.
     */
    @Test
    public void testGetFechaFin() {
        System.out.println("getFechaFin");
        
        Date expResult = fecha;
        Date result = instance.getFechaFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getServicio method, of class LineaReserva.
     */
    @Test
    public void testGetServicio() {
        System.out.println("getServicio");
        
        Servicio expResult = servicio;
        Servicio result = instance.getServicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPromocion method, of class LineaReserva.
     */
    @Test
    public void testGetPromocion() {
        System.out.println("getPromocion");
        
        Promocion expResult = null;
        Promocion result = instance.getPromocion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPrecio method, of class LineaReserva.
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
     * Test of setCantidad method, of class LineaReserva.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int c = 0;
        
        instance.setCantidad(c);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(0,instance.getCantidad(),0.0);
    }

    /**
     * Test of setFechaInicio method, of class LineaReserva.
     */
    @Test
    public void testSetFechaInicio() {
        System.out.println("setFechaInicio");
        Date finicio = null;
        
        instance.setFechaInicio(finicio);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(finicio,instance.getFechaInicio());
    }

    /**
     * Test of setFechaFin method, of class LineaReserva.
     */
    @Test
    public void testSetFechaFin() {
        System.out.println("setFechaFin");
        Date ffin = null;
        
        instance.setFechaFin(ffin);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(ffin,instance.getFechaFin());
    }

    /**
     * Test of setServicio method, of class LineaReserva.
     */
    @Test
    public void testSetServicio() {
        System.out.println("setServicio");
        Servicio s = new Servicio("gordo","bueno",50,null,null,null,null);
        
        instance.setServicio(s);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(s,instance.getServicio());
    }

    /**
     * Test of setPromocion method, of class LineaReserva.
     */
    @Test
    public void testSetPromocion() {
        System.out.println("setPromocion");
        Promocion p = new Promocion("promo",50,null);
        
        instance.setPromocion(p);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(p,instance.getPromocion());
        
    }

    /**
     * Test of crearDTLineaReserva method, of class LineaReserva.
     */
    @Test
    public void testCrearDTLineaReserva() {
        System.out.println("crearDTLineaReserva");
        
        DTLineaReserva expResult = new DTLineaReserva(2,fecha,fecha,"ser","",50);
        DTLineaReserva result = instance.crearDTLineaReserva();
        
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
