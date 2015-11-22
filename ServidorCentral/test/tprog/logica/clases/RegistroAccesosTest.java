package tprog.logica.clases;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegistroAccesosTest {
    
    RegistroAccesos instance = new RegistroAccesos();
    
    public RegistroAccesosTest() {
    }
    
    @Before
    public void setUp() {
    }
   
    /**
     * Test of agregarAcceso method, of class RegistroAccesos.
     */
    @Test
    public void testAgregarAcceso() {
        System.out.println("agregarAcceso");
        String ipAddress = "1234";
        String urlAddress = "www.url.com";
        String browser = "Mozilla";
        String sistemaOperativo = "Windows";
        assertTrue(instance.getAccesos().isEmpty());
        instance.agregarAcceso(ipAddress, urlAddress, browser, sistemaOperativo);
        assertFalse(instance.getAccesos().isEmpty());
        assertEquals(1, instance.getAccesos().size());
    }
    
    @Test
    public void testAgregarAccesoMasivo(){
        for(int i = 0 ; i<10000; i++){
            instance.agregarAcceso("IP: " + i , "www.url.com", "Who", "Mac");
        }
        instance.agregarAcceso("121", "www.otraURL.com", "Who", "Mac");
        assertEquals(10000, instance.getAccesos().size());
        assertEquals("121", instance.getAccesos().get(9999).getIPAddress());
    }
    
}
