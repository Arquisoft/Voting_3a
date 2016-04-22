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
import es.uniovi.asw.types.ChangePass;

/**
 * @author Amir H Tofigh Halati
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class ChangePassTest {
	private String login="loglog"; 
	private String pass="paspas";
	private String passNew="masmas";

	/**
	 * Test method for {@link es.uniovi.asw.types.ChangePass#ChangePass()}.
	 */
	@Test
	public void testChangePass() {
		ChangePass cp = new ChangePass();
		assertNull(cp.getLogin());
		assertNull(cp.getNewPassword());
		assertNull(cp.getOldPassword());
		cp = new ChangePass(login,pass,passNew);
		assertTrue(login.equals(cp.getLogin()));
		assertTrue(pass.equals(cp.getOldPassword()));
		assertTrue(passNew.equals(cp.getNewPassword()));
	}

	/**
	 * Test method for {@link es.uniovi.asw.types.ChangePass#ChangePass(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testChangePassStringStringString() {
		ChangePass cp  = new ChangePass(login,pass,passNew);
		assertTrue(login.equals(cp.getLogin()));
		assertTrue(pass.equals(cp.getOldPassword()));
		assertTrue(passNew.equals(cp.getNewPassword()));
	}

}
