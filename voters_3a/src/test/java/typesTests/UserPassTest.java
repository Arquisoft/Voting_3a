/**
 * 
 */
package typesTests;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;
import es.uniovi.asw.types.Encrypter;
import es.uniovi.asw.types.UserPass;

/**
 * @author Amir H Tofigh H
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class UserPassTest {
	private String login="loglog"; 
	private String pass="paspas";

	/**
	 * Test method for {@link es.uniovi.asw.types.UserPass#UserPass()}.
	 */
	@Test
	public void testUserPass() {
		UserPass up = new UserPass();
		assertNull(up.getLogin());
		assertNull(up.getPassword());

	}

	/**
	 * Test method for {@link es.uniovi.asw.types.UserPass#UserPass(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testUserPassStringString() throws Exception {
		UserPass up = new UserPass(login,pass);
		assertTrue(login.equals(up.getLogin()));
		assertTrue(pass.equals(Encrypter.decrypt(up.getPassword())));
	}

	/**
	 * Test method for {@link es.uniovi.asw.types.UserPass#toString()}.
	 * @throws Exception 
	 */
	@Test
	public void testToString() throws Exception {
		UserPass up = new UserPass(login,pass);
		assertTrue(up.toString().equals("UserPass [login=" + login + ", password=" + Encrypter.encrypt(pass) + "]"));
	}
}
