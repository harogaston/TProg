/*
 * Header Test
 */
package tprog.logica.clases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gianc_000
 */
public class ItemPromocionTest {
    
    ItemPromocion instance;
    
    public ItemPromocionTest() {
    }
    
    @Before
    public void setUp() {
        Servicio s = null;
        instance = new ItemPromocion(s);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addServicio method, of class ItemPromocion.
     */
    @Test
    public void testAddServicio() {
        System.out.println("addServicio");
        assertEquals(1, instance.cantidad);
        instance.addServicio();
        assertEquals(2, instance.cantidad);
    }

    /**
     * Test of getServicio method, of class ItemPromocion.
     */
    @Test
    public void testGetServicio() {
        System.out.println("getServicio");
        assertEquals(null, instance.getServicio());
    }

    /**
     * Test of getCantidad method, of class ItemPromocion.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        assertEquals(1, instance.getCantidad());
    }
    
}
