package tprog.logica.controladores;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTMinCliente;
import tprog.logica.dt.DTMinProveedor;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.DTUsuario;

public class CtrlUsuariosTest {

	CtrlUsuarios ctrlUsuarios;

	public CtrlUsuariosTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		ctrlUsuarios = new CtrlUsuarios();
		ctrlUsuarios.verificarNickname("jorge1");
		ctrlUsuarios.verificarEmail("jorge1@gmail.com");
		ctrlUsuarios.ingresarDatosUsuario(new DTUsuario("jorge1", "pass", "N1", "A1", "jorge1@gmail.com", null, new Date(1992, 11, 10)), false);
		ctrlUsuarios.altaUsuario();
		ctrlUsuarios.seleccionarCliente("jorge1");
		/*try {
			DTCliente dtJorge1 = ctrlUsuarios.infoCliente();
		} catch (Exception ex) {
			Logger.getLogger(CtrlUsuariosTest.class.getName()).log(Level.SEVERE, null, ex);
		}*/
		ctrlUsuarios.verificarNickname("jorge2");
		ctrlUsuarios.verificarEmail("jorge2@gmail.com");
		ctrlUsuarios.ingresarDatosUsuario(new DTUsuario("jorge2", "pass", "N1", "A1", "jorge2@gmail.com", null, new Date(1992, 11, 10)), true);
		ctrlUsuarios.ingresarDatosProveedor(null, null);
		ctrlUsuarios.altaUsuario();
		ctrlUsuarios.verificarNickname("jorge3");
		ctrlUsuarios.verificarEmail("jorge3@gmail.com");
		ctrlUsuarios.ingresarDatosUsuario(new DTUsuario("jorge3", "pass", "N1", "A1", "jorge3@gmail.com", null, new Date(1992, 11, 10)), false);
		ctrlUsuarios.altaUsuario();
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of listarClientes method, of class CtrlUsuarios.
	 */
	@Test
	public void testListarClientes() throws Exception {
		try {
			System.out.println("listarClientes");
			Set<DTMinCliente> expResult = new HashSet();
			expResult.add(new DTMinCliente("jorge1", "jorge1@gmail.com"));
			expResult.add(new DTMinCliente("jorge3", "jorge3@gmail.com"));
			Set<DTMinCliente> result = ctrlUsuarios.listarClientes();
			boolean foundAll = true;
			for (DTMinCliente dtResult : result) {
				boolean found = false;
				for (DTMinCliente dtExpResult : expResult) {
					if (dtExpResult.getNickname().equals(dtResult.getNickname())
							&& dtExpResult.getEmail().equals(dtResult.getEmail())) {
						found = true;
					}
				}
				foundAll = foundAll && found;
			}
			assertTrue(foundAll);
			assertEquals(result.size(), expResult.size());
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Test of seleccionarCliente method, of class CtrlUsuarios.
	 */
	@Test
	public void testSeleccionarCliente() {
		System.out.println("seleccionarCliente");
		for (int i = 0; i < 5; i++) {
			ctrlUsuarios.seleccionarCliente("jorge" + Integer.toString(i));
		}
	}

	/**
	 * Test of infoCliente method, of class CtrlUsuarios.
	 */
	@Test
	public void testInfoCliente() throws Exception {
		System.out.println("infoCliente");
		ctrlUsuarios.seleccionarCliente("jorge1");
		try {
			Assert.assertEquals(ctrlUsuarios.infoCliente().toString(), (new DTCliente("jorge1", "pass", "N1", "A1", "jorge1@gmail.com", null, new Date(1992, 11, 10), new HashSet<>())).toString());
		} catch (Exception ex) {
			Logger.getLogger(CtrlUsuariosTest.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Test of seleccionarReserva method, of class CtrlUsuarios.
	 */
	@Test
	public void testSeleccionarReserva() {
		System.out.println("seleccionarReserva");
		for (int i = 0; i < 5; i++) {
			ctrlUsuarios.seleccionarReserva(i);
		}
	}

	/**
	 * Test of infoReserva method, of class CtrlUsuarios.
	 */
	@Test
	public void testInfoReserva() {
		System.out.println("infoReserva");
		ctrlUsuarios.seleccionarReserva(1);
		DTReserva result = ctrlUsuarios.infoReserva();
		assertEquals(result, null);
	}

	/**
	 * Test of verificarNickname method, of class CtrlUsuarios.
	 */
	@Test
	public void testVerificarNickname() {
		System.out.println("verificarNickname");
		boolean expResult = true;
		boolean result = ctrlUsuarios.verificarNickname("jorge1");
		assertEquals(expResult, result);
	}

	/**
	 * Test of verificarEmail method, of class CtrlUsuarios.
	 */
	@Test
	public void testVerificarEmail() {
		System.out.println("verificarEmail");
		boolean expResult = true;
		boolean result = ctrlUsuarios.verificarEmail("jorge1@gmail.com");
		assertEquals(expResult, result);
	}

	/**
	 * Test of ingresarDatosUsuario method, of class CtrlUsuarios.
	 */
	@Test
	public void testIngresarDatosUsuario() {
		System.out.println("ingresarDatosUsuario");
		ctrlUsuarios.ingresarDatosUsuario(null, true);
		ctrlUsuarios.ingresarDatosUsuario(null, false);
	}

	/**
	 * Test of ingresarDatosProveedor method, of class CtrlUsuarios.
	 */
	@Test
	public void testIngresarDatosProveedor() {
		System.out.println("ingresarDatosProveedor");
		ctrlUsuarios.ingresarDatosProveedor("", "");
	}

	/**
	 * Test of altaUsuario method, of class CtrlUsuarios.
	 */
	@Test
	public void testAltaUsuario() {
		System.out.println("altaUsuario");
		//pruebo caso de cliente
		ctrlUsuarios.verificarNickname("jorge4");
		ctrlUsuarios.verificarEmail("jorge4@gmail.com");
		DTUsuario dtusuario1 = new DTUsuario("jorge4", "pass", "N1", "A1", "jorge4@gmail.com", null, new Date(1992, 11, 10));
		ctrlUsuarios.ingresarDatosUsuario(dtusuario1, false);
		ctrlUsuarios.altaUsuario();
		ctrlUsuarios.seleccionarCliente("jorge1");
//        try {
//            DTCliente dtJorge1 = ctrlUsuarios.infoCliente();
//        } catch (Exception ex) {
//            Logger.getLogger(CtrlUsuariosTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
		//pruebo caso de proveedor
		ctrlUsuarios.verificarNickname("jorge5");
		ctrlUsuarios.verificarEmail("jorge5@gmail.com");
		DTUsuario dtUsuario2 = new DTUsuario("jorge5", "pass", "N1", "A1", "jorge5@gmail.com", "null", new Date(1992, 11, 10));
		ctrlUsuarios.ingresarDatosUsuario(dtUsuario2, true);
		ctrlUsuarios.ingresarDatosProveedor("null", "null");
		ctrlUsuarios.altaUsuario();
		//testeo a ver si aparecen
		ctrlUsuarios.seleccionarCliente("jorge4");
		try {
			Assert.assertEquals(ctrlUsuarios.infoCliente(), (new DTCliente("jorge4", "pass", "N1", "N2", "jorge4@gmail.com",
					null, new Date(1992, 11, 10), new HashSet<>())));
		} catch (Exception ex) {
			Logger.getLogger(CtrlUsuariosTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		ctrlUsuarios.seleccionarProveedor("jorge5");
		try {
			Assert.assertEquals(ctrlUsuarios.infoProveedor(), (new DTProveedor("jorge5", "pass", "N1", "A1", "jorge5@gmail.com", "null", new Date(1992, 11, 10), "null", "null")));
		} catch (Exception ex) {
			Logger.getLogger(CtrlUsuariosTest.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Test of listarProveedores method, of class CtrlUsuarios.
	 */
	@Test
	public void testListarProveedores() throws Exception {
		System.out.println("listarProveedores");
		Set<DTMinProveedor> expResult = new HashSet<>();
		expResult.add(new DTMinProveedor("jorge2", "jorge2@gmail.com", null));
		Set<DTMinProveedor> result = ctrlUsuarios.listarProveedores();
		boolean foundAll = true;
		for (DTMinProveedor dtResult : result) {
			boolean found = false;
			for (DTMinProveedor dtExpResult : expResult) {
				if (dtExpResult.getNickname().equals(dtResult.getNickname())
						&& dtExpResult.getEmail().equals(dtResult.getEmail())) {
					found = true;
				}
			}
			foundAll = foundAll && found;
		}
		assertTrue(result.size() == expResult.size() && foundAll);
	}

	/**
	 * Test of seleccionarProveedor method, of class CtrlUsuarios.
	 */
	@Test
	public void testSeleccionarProveedor() {
		System.out.println("seleccionarProveedor");
		for (int i = 0; i < 5; i++) {
			ctrlUsuarios.seleccionarProveedor("jorge" + Integer.toString(i));
		}
	}

	/**
	 * Test of infoProveedor method, of class CtrlUsuarios.
	 */
	@Test
	public void testInfoProveedor() throws Exception {
		System.out.println("infoProveedor");
//DTUsuario("jorge2", "N1", "A1", "jorge2@gmail.com", null, new Date(1992, 11, 10))
		ctrlUsuarios.seleccionarProveedor("jorge2");
		DTProveedor result = ctrlUsuarios.infoProveedor();
		assertEquals((new DTProveedor("jorge2", "pass", "N1", "A1", "jorge2@gmail.com", null, new Date(1992, 11, 10), null, null)).toString(), result.toString());
	}

	/**
	 * Test of listarServiciosProveedor method, of class CtrlUsuarios.
	 */
	@Test
	public void testListarServiciosProveedor() {
		System.out.println("listarServiciosProveedor");
		ctrlUsuarios.seleccionarProveedor("jorge2");
		Assert.assertEquals(ctrlUsuarios.listarServiciosProveedor().toString(), (new HashSet()).toString());
	}

	/**
	 * Test of seleccionarServicio method, of class CtrlUsuarios.
	 */
	@Test
	public void testSeleccionarServicio() {
		System.out.println("seleccionarServicio");
		for (int i = 0; i < 5; i++) {
			ctrlUsuarios.seleccionarServicio("servicio" + Integer.toString(i));
		}
	}

	/**
	 * Test of infoServicio method, of class CtrlUsuarios.
	 */
	@Test
	public void testInfoServicio() {
		System.out.println("infoServicio");
		assertEquals(null, ctrlUsuarios.infoServicio());
	}

        @Test
	public void testIdCorrecta() {
		System.out.println("idCorrect");
                assertTrue(ctrlUsuarios.idCorrecta("jorge1"));
	}

        @Test
	public void testPwCorrecta() {
		System.out.println("infoServicio");
                assertTrue(ctrlUsuarios.pwCorrecta("jorge1", "pass"));
	}

        @Test
	public void testObtenerIdCliente() {
		System.out.println("infoServicio");
		assertEquals("jorge1", ctrlUsuarios.obtenerIdCliente("jorge1@gmail.com", "pass"));
	}

}
