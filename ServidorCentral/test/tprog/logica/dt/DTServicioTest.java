/*
 * Header Test
 */
package tprog.logica.dt;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author gaston
 */
public class DTServicioTest {

	private DTServicio instance;
	private DTUbicacion origen;
	private DTUbicacion destino;
	private Set<String> imagenes;

	public DTServicioTest() {
        
	}

	@Before
	public void setUp() {
		origen = new DTUbicacion("ciudadOrigen", "paisOrigen");
		destino = new DTUbicacion("ciudadDestino", "paisDestino");
		imagenes = new HashSet();
		imagenes.add("Im1");
		imagenes.add("Im2");
		imagenes.add("Im3");
		instance = new DTServicio("id", "desc", null, 480.23F, imagenes, origen, destino);
	}
    
    @Test
	public void testDTServicio() {
		System.out.println("DTServicio");
		DTServicio expResult = new DTServicio(null,null,null,0,null,null,null);
		DTServicio result = new DTServicio();
		assertEquals(expResult, result);
	}
    
    @Test
	public void testGetNicknameProveedor() {
		System.out.println("getNicknameProveedor");
		assertEquals("desc", instance.getNicknameProveedor());
	}
    
	@Test
	public void testGetIdServicio() {
		System.out.println("getIdServicio");
		String expResult = "id";
		String result = instance.getIdServicio();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetDescripcion() {
		System.out.println("getDescripcion");
		String expResult = "desc";
		String result = instance.getDescripcion();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetPrecio() {
		System.out.println("getPrecio");
		float expResult = 480.23F;
		float result = instance.getPrecio();
		assertEquals(expResult, result, 0.001);
	}

	@Test
	public void testGetImagenes() {
		System.out.println("getImagenes");
		Set<String> expResult = imagenes;
		Set<String> result = instance.getImagenes();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetOrigen() {
		System.out.println("getOrigen");
		DTUbicacion expResult = origen;
		DTUbicacion result = instance.getOrigen();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetDestino() {
		System.out.println("getDestino");
		DTUbicacion expResult = destino;
		DTUbicacion result = instance.getDestino();
		assertEquals(expResult, result);
	}

	@Test
	public void testToString() {
		System.out.println("toString");
		String expResult = "ID de servicio: " + "id"
				+ "\n" + "Descripcion: " + "desc"
				+ "\n" + "Precio: " + Float.toString(480.23F)
				+ "\n" + "Origen: " + "Ciudad: " + "ciudadOrigen" + ", Pais: " + "paisOrigen"
				+ "\n" + "Destino: " + "Ciudad: " + "ciudadDestino" + ", Pais: " + "paisDestino"
				+ "\n";
		String result = instance.toString();
		assertEquals(expResult, result);
	}

}
