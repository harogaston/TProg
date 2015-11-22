package tprog.logica.clases;

import java.util.Date;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;

public class ItemRankingTest {
    
    ItemRanking instance;
    
    @Before
    public void setUp(){
        Proveedor prov = new Proveedor (new DTProveedor("prov1", "pass", "Juan",
                "Pérez", "juanpe@gmail.com", "imagen", new Date(), "empresa", "empresa.com"));
        Servicio serv = new Servicio("idServicio1", "", 109, new HashSet(), 
                new Ciudad("Montevideo"), null, prov);
        for (int i = 0; i < 23; i++){
            serv.agregarAcceso();
        }
        instance = new ItemRanking(serv);
    }

    /**
     * Test of getServicio method, of class ItemRanking.
     */
    @Test
    public void testGetServicio() {
        System.out.println("getServicio");
        String expProv = "prov1";
        String expServ = "idServicio1";
        DTMinServicio result = instance.getServicio();
        assertEquals(expProv, result.getNicknameP());
        assertEquals(expServ, result.getIdServicio());
    }

    /**
     * Test of getCantAccesos method, of class ItemRanking.
     */
    @Test
    public void testGetCantAccesos() {
        System.out.println("getCantAccesos");
        int expResult = 23;
        int result = instance.getCantAccesos();
        assertEquals(expResult, result);
    }
    
}
