/*
 * Header Test
 */
package com.tprog.logica.dt;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author gaston
 */
public class DTUbicacionTest {

    DTUbicacion instance;

    public DTUbicacionTest() {
    }

    @Before
    public void setUp() {
        instance = new DTUbicacion("ciudad", "pais");
    }

    @Test
    public void testGetCiudad() {
        System.out.println("getCiudad");
        String expResult = "ciudad";
        String result = instance.getCiudad();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPais() {
        System.out.println("getPais");
        String expResult = "pais";
        String result = instance.getPais();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Ciudad: " + "ciudad" + ", Pais: " + "pais";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
