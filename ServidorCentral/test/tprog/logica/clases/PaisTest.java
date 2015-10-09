/*
 * Header Test
 */
package tprog.logica.clases;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PaisTest {
    
    Pais instance;
    String idPais;
    Map<String, Ciudad> ciudades;

    public PaisTest() {
    }
    
    @Before
    public void setUp() {
        instance = new Pais("QGuay");
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
    }

    /**
     * Test of getCiudades method, of class Pais.
     */
    @Test
    public void testGetCiudades() {
        System.out.println("getCiudades");
        Map<String, Ciudad> cities = instance.getCiudades();
        assertTrue(cities.isEmpty());
    }

    /**
     * Test of setIdPais method, of class Pais.
     */
    @Test
    public void testSetIdPais() {
        System.out.println("TEST: setIdPais");
        String idPais = "Uruguay";
        
        instance.setIdPais(idPais);
        assertEquals(idPais, instance.getIdPais());
        
    }

    /**
     * Test of agregarCiudad method, of class Pais.
     */
    @Test
    public void testAgregarCiudad() {
        System.out.println("agregarCiudad");
        instance.agregarCiudad(new Ciudad("Montevideo"));
        assertTrue(!instance.getCiudades().isEmpty());
        assertTrue(instance.getCiudades().containsKey("Montevideo"));
        String pais = instance.getIdPais();
        String paisCiudad = instance.getCiudades().get("Montevideo").getPais().getIdPais();
        assertEquals(pais, paisCiudad);
        
    }
    
}
