/*
 * Header Test
 */
package com.tprog.logica.clases;

import com.tprog.logica.dt.DTUbicacion;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author MarG
 */
public class CiudadTest {

    Ciudad instance;
    String idCiudad;
    Pais pais;

    public CiudadTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        idCiudad = "Madrid";
        instance = new Ciudad("Madrid");
        Pais p = new Pais("España");
        instance.setPais(p);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getIdCiudad method, of class Ciudad.
     */
    @Test
    public void testGetIdCiudad() {
        System.out.println("getIdCiudad");

        String expResult = "Madrid";
        String result = instance.getIdCiudad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setPais method, of class Ciudad.
     */
    @Test
    public void testSetPais() {
        System.out.println("setPais");
        Pais nuevo = new Pais("Mexico");

        instance.setPais(nuevo);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of crearDT method, of class Ciudad.
     */
    @Test
    public void testCrearDT() {
        System.out.println("crearDT");

        DTUbicacion expResult = null;
        DTUbicacion result = instance.crearDT();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

}
