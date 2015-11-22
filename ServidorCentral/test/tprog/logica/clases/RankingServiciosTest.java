package tprog.logica.clases;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tprog.logica.dt.DTMinServicio;

public class RankingServiciosTest {
    
    RankingServicios instance;
    
    public RankingServiciosTest() {
    }
    
    @Before
    public void setUp() {
        instance = new RankingServicios();
    }
    
    /**
     * Test of getRanking method, of class RankingServicios.
     */
    @Test
    public void testGetRanking() {
        System.out.println("getRanking");
        assertEquals(10, instance.getRanking().size());
        for (int i = 0; i<10; i++){
           assertEquals(null, instance.getRanking().get(i)); 
        }
    }

    /**
     * Test of insertarItemOrdenado method, of class RankingServicios.
     */
    @Test
    public void testInsertarItemOrdenado() {
        System.out.println("insertarItemOrdenado");
        for (int i = 0; i < 12; i++){
            DTMinServicio dataS = new DTMinServicio("Prov" + i, "Servicio" + i);
            instance.insertarItemOrdenado(new ItemRanking (dataS, i));
        }
        List<ItemRanking> listaResultado = instance.getRanking();
        assertEquals(10, listaResultado.size());
        for (int i = 0; i<10; i++){
            System.out.println("iteracion" + i);
            assertFalse(listaResultado.get(i) == null);
            assertEquals(11-i, listaResultado.get(i).getCantAccesos());
        }
        for (int i = 0; i < 10; i++) {
            assertFalse(listaResultado.get(i).getServicio().getIdServicio().equals("Servicio0"));
        }
                
    }

    
    
}
