/*
 * Header Test
 */
package tprog.logica.dt;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gaston
 */
public class DTMinClienteTest {
	
	public DTMinClienteTest() {
	}

	@Test
	public void testGetNickname() {
		System.out.println("getNickname");
		DTMinCliente instance = new DTMinCliente("nick", "nick@email.com");
		String expResult = "nick";
		String result = instance.getNickname();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetEmail() {
		System.out.println("getEmail");
		DTMinCliente instance = new DTMinCliente("nick", "nick@email.com");
		String expResult = "nick@email.com";
		String result = instance.getEmail();
		assertEquals(expResult, result);
	}

	@Test
	public void testToString() {
		System.out.println("toString");
		DTMinCliente instance = new DTMinCliente("nick", "nick@email.com");
		String expResult = "Nickname: " + "nick"
				+ "\n" + "Email: " + "nick@email.com" + "\n";
		String result = instance.toString();
		assertEquals(expResult, result);
	}
	
}
