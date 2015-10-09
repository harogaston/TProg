/*
 * Header Test
 */
package tprog.logica.clases;

import tprog.logica.dt.DTUbicacion;
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
        instance = new Ciudad("Madrid");
        instance.setPais(new Pais("España"));
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
    }

    /**
     * Test of setPais method, of class Ciudad.
     */
    @Test
    public void testSetPais() {
        System.out.println("setPais");
        Pais nuevo = new Pais("Mexico");
        instance.setPais(nuevo);
        assertTrue(instance.getPais() == nuevo);
    }

    /**
     * Test of crearDT method, of class Ciudad.
     */
    @Test
    public void testCrearDT() {
        System.out.println("crearDT");
        
        DTUbicacion expResult = new DTUbicacion("Madrid", "España");
        DTUbicacion result = instance.crearDT();
        assertEquals(expResult.getCiudad(), result.getCiudad());
        assertEquals(expResult.getPais(), result.getPais());
    }
    
}
