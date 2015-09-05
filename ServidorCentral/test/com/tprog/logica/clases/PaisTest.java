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
    
    Pais instance;
    String idPais;
    Map<String, Ciudad> ciudades;
    
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
        instance = new Pais("QGuay");
        Ciudad nueva = new Ciudad("Montevideo");
        instance.agregarCiudad(nueva);
        
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
        
        String expResult = "QGuay";
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
        
        Map<String, Ciudad> expResult = ciudades;
        Map<String, Ciudad> result = instance.getCiudades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setIdPais method, of class Pais.
     */
    @Test
    public void testSetIdPais() {
        System.out.println("setIdPais");
        String id = "gg";
        
        instance.setIdPais(id);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of agregarCiudad method, of class Pais.
     */
    @Test
    public void testAgregarCiudad() {
        System.out.println("agregarCiudad");
        Ciudad c = new Ciudad("Atlantida");
        instance.agregarCiudad(c);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
