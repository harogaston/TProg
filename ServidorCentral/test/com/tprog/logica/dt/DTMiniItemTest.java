/*
 * Header Test
 */
package com.tprog.logica.dt;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sofia
 */
public class DTMiniItemTest {
    
    public DTMiniItemTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdServicio method, of class DTMiniItem.
     */
    @Test
    public void testGetIdServicio() {
        System.out.println("getIdServicio");
        DTMiniItem dtMin = new DTMiniItem("Servicio", 15);
        assertEquals("Servicio", dtMin.getIdServicio());
    }

    /**
     * Test of getCantidad method, of class DTMiniItem.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        DTMiniItem dtMin = new DTMiniItem("Servicio", 15);
        assertEquals(15, dtMin.getCantidad());
    }
    
}
