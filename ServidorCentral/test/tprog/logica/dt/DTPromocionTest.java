/*
 * Header Test
 */
package tprog.logica.dt;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gaston
 */
public class DTPromocionTest {
	
	public DTPromocionTest() {
	}

	@Test
	public void testGetIdPromocion() {
		System.out.println("getIdPromocion");
		DTItemPromocion s1 = new DTItemPromocion(new DTMinServicio("Fulano0", "Ser"), 1);
		DTItemPromocion s2 = new DTItemPromocion(new DTMinServicio("Fulano1", "Ser"), 2);
		DTItemPromocion s3 = new DTItemPromocion(new DTMinServicio("Fulano2", "Ser"), 1);
		Set<DTItemPromocion> set = new HashSet();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		DTPromocion instance = new DTPromocion("id", 0.25F, 550.0F, set);
		String expResult = "id";
		String result = instance.getIdPromocion();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetDescuento() {
		System.out.println("getDescuento");
		DTItemPromocion s1 = new DTItemPromocion(new DTMinServicio("Fulano0", "Ser"), 1);
		DTItemPromocion s2 = new DTItemPromocion(new DTMinServicio("Fulano1", "Ser"), 2);
		DTItemPromocion s3 = new DTItemPromocion(new DTMinServicio("Fulano2", "Ser"), 1);
		Set<DTItemPromocion> set = new HashSet();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		DTPromocion instance = new DTPromocion("id", 0.25F, 550.0F, set);
		float expResult = 0.25F;
		float result = instance.getDescuento();
		assertEquals(expResult, result, 0.001);
	}

	@Test
	public void testGetTotal() {
		System.out.println("getTotal");
                
		DTItemPromocion s1 = new DTItemPromocion(new DTMinServicio("Fulano0", "Ser"), 1);
		DTItemPromocion s2 = new DTItemPromocion(new DTMinServicio("Fulano1", "Ser"), 2);
		DTItemPromocion s3 = new DTItemPromocion(new DTMinServicio("Fulano2", "Ser"), 1);
		Set<DTItemPromocion> set = new HashSet();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		DTPromocion instance = new DTPromocion("id", 0.25F, 550.0F, set);
		float expResult = 550.0F;
		float result = instance.getTotal();
		assertEquals(expResult, result, 0.001);
	}

	@Test
	public void testGetServicios() {
		System.out.println("getServicios");
		DTItemPromocion s1 = new DTItemPromocion(new DTMinServicio("Fulano0", "Ser"), 1);
		DTItemPromocion s2 = new DTItemPromocion(new DTMinServicio("Fulano1", "Ser"), 2);
		DTItemPromocion s3 = new DTItemPromocion(new DTMinServicio("Fulano2", "Ser"), 1);
		Set<DTItemPromocion> set = new HashSet();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		DTPromocion instance = new DTPromocion("id", 0.25F, 550.0F, set);
		Set<DTItemPromocion> expResult = set;
		Set<DTItemPromocion> result = instance.getServicios();
		assertEquals(expResult.size(), result.size());
	}

	/*@Test
	public void testToString() {
		System.out.println("toString");
		DTItemPromocion s1 = new DTItemPromocion(new DTMinServicio("Fulano0", "Ser"), 1);
		Set<DTMiniItem> set = new HashSet();
		set.add(s1);
		DTPromocion instance = new DTPromocion("id", 0.25F, 550.0F, set);
		String expResult = "ID de promocion: " + "id"
				+ "\n" + "Descuento: " + Float.toString(0.25F)
				+ "\n" + "Total: " + Float.toString(550.0F)
				+ "\n" + "Servicios: " + "\n" +
                        "Servicio: 1 Ser cantidad: 1\n";
                        
		String result = instance.toString();
		assertEquals(expResult, result);
	}*/
	
}
