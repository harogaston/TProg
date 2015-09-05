/*
 * Header Test
 */
package com.tprog.logica.clases;

import java.util.Map;
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
public class PaisTest {
    
    public PaisTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdPais method, of class Pais.
     */
    @Test
    public void testGetIdPais() {
        System.out.println("getIdPais");
        Pais instance = null;
        String expResult = "";
        String result = instance.getIdPais();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCiudades method, of class Pais.
     */
    @Test
    public void testGetCiudades() {
        System.out.println("getCiudades");
        Pais instance = null;
        Map<String, Ciudad> expResult = null;
        Map<String, Ciudad> result = instance.getCiudades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdPais method, of class Pais.
     */
    @Test
    public void testSetIdPais() {
        System.out.println("setIdPais");
        String id = "";
        Pais instance = null;
        instance.setIdPais(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarCiudad method, of class Pais.
     */
    @Test
    public void testAgregarCiudad() {
        System.out.println("agregarCiudad");
        Ciudad c = null;
        Pais instance = null;
        instance.agregarCiudad(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
