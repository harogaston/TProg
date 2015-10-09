package tprog.logica.dt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class DTPromocionTest {

	Map<String, Integer> servicios;
	HashMap<DTMinServicio, Integer> set;
	Date fecha;

	public DTPromocionTest() {
	}

	@Before
	public void setUp() {
		set = new HashMap<>();
		set.put(new DTMinServicio("Fulano0", "Ser"), 1);
		set.put(new DTMinServicio("Fulano1", "Ser"), 2);
		set.put(new DTMinServicio("Fulano2", "Ser"), 1);

		servicios = new HashMap<>();
	}

	@Test
	public void testGetIdPromocion() {
		System.out.println("getIdPromocion");
		DTPromocion instance = new DTPromocion("id", null, 0.25F, 550.0F, set);
		String expResult = "id";
		String result = instance.getIdPromocion();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetDescuento() {
		System.out.println("getDescuento");
		DTPromocion instance = new DTPromocion("id", null, 0.25F, 550.0F, set);
		float expResult = 0.25F;
		float result = instance.getDescuento();
		assertEquals(expResult, result, 0.001);
	}

	@Test
	public void testGetTotal() {
		System.out.println("getTotal");
		DTPromocion instance = new DTPromocion("id", null, 0.25F, 550.0F, set);
		float expResult = 550.0F;
		float result = instance.getTotal();
		assertEquals(expResult, result, 0.001);
	}

	@Test
	public void testGetServicios() {
		System.out.println("getServicios");
		DTPromocion instance = new DTPromocion("id", null, 0.25F, 550.0F, set);
		Map<DTMinServicio, Integer> expResult = set;
		Map<DTMinServicio, Integer>  result = instance.getServicios();
		assertEquals(expResult.size(), result.size());
	}
}
