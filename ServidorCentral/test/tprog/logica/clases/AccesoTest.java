package tprog.logica.clases;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AccesoTest {
    
    Acceso instance;
    
    public AccesoTest() {
    }
    
    @Before
    public void setUpClass() {
        instance = new Acceso("some IP Address", "www.url.com", "Chrome", 
                "No Linux");
    }
    
    /**
     * Test of getIdAcceso method, of class Acceso.
     */
    @Test
    public void testGetIdAcceso() {
        System.out.println("getIdAcceso");
        int idEsperada = instance.getIdAcceso() + 1;
        Acceso nuevoAcceso = new Acceso("some other IP Address", 
                "www.url.com/index", "Safari", "Mac");
        assertEquals(idEsperada, nuevoAcceso.getIdAcceso());
    }
    
    /**
     * Test of getIPAddress method, of class Acceso.
     */
    @Test
    public void testGetIPAddress() {
        System.out.println("getIPAddress");
        assertEquals("some IP Address", instance.getIPAddress());
    }
    
    /**
     * Test of getURLAddress method, of class Acceso.
     */
    @Test
    public void testGetURLAddress() {
        System.out.println("getURLAddress");
        assertEquals("www.url.com", instance.getURLAddress());
    }
    
    /**
     * Test of getBrowser method, of class Acceso.
     */
    @Test
    public void testGetBrowser() {
        System.out.println("getBrowser");
        assertEquals("Chrome", instance.getBrowser());
    }
    
    /**
     * Test of getSistemaOperativo method, of class Acceso.
     */
    @Test
    public void testGetSistemaOperativo() {
        System.out.println("getSistemaOperativo");
        assertEquals("No Linux", instance.getSistemaOperativo());
    }
    
    /**
     * Test of getFechaAcceso method, of class Acceso.
     */
    @Test
    public void testGetFechaAcceso() {
        System.out.println("getFechaAcceso");
        assertEquals(new Date(), instance.getFechaAcceso());
    }
    
    
}
