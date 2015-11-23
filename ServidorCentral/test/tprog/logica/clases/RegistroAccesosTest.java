package tprog.logica.clases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegistroAccesosTest {
    
    RegistroAccesos instance; 
    
    public RegistroAccesosTest() {
    }
    
    @Before
    public void setUp() {
        instance = RegistroAccesos.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        instance = null;
    }
    
    /**
     * Test of getInstance method, of class RegistroAccesos.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        instance.getInstance();
    }
    
    /**
     * Test of agregarAcceso method, of class RegistroAccesos.
     */
    @Test
    public void testAgregarAccesoMasivo(){
        for(int i = 0 ; i<10000; i++){
            instance.agregarAcceso("IP: " + i , "www.url.com", "Who", "Mac");
            assertEquals(i+1, instance.getAccesos().size());
        }
        instance.agregarAcceso("121", "www.otraURL.com", "Who", "Mac");
        assertEquals(10000, instance.getAccesos().size());
        assertEquals("121", instance.getAccesos().get(9999).getIPAddress());
        
    }

}
