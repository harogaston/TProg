/*
 * Header Test
 */
package tprog.logica.dt;

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
public class DTItemPromocionTest {
    
    public DTItemPromocionTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdServicio method, of class DTItemPromocion.
     */
    @Test
    public void testGetIdServicio() {
        System.out.println("getIdServicio");
        DTItemPromocion dtMin = new DTItemPromocion(new DTMinServicio("Fulano", "Ser"), 15);
        assertEquals("Ser", dtMin.getDTMinServicio().getIdServicio());
        assertEquals("Fulano", dtMin.getDTMinServicio().getNicknameP());
    }

    /**
     * Test of getCantidad method, of class DTItemPromocion.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        DTItemPromocion dtMin = new DTItemPromocion(new DTMinServicio("Fulano", "Ser"), 15);
        assertEquals(15, dtMin.getCantidad());
    }
    
}
