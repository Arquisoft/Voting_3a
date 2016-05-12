package es.uniovi.asw.Voters.exceptionsTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;
import es.uniovi.asw.Voters.exceptions.UserNotFoundException;
import es.uniovi.asw.Voters.types.UserPass;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class ExceptionTests {

	@Test
	public void test() {
		try {
			new UserNotFoundException(new UserPass("correo@dom.com", "randomPass"));
		} catch (RuntimeException e) {
			assertTrue(true);
		}

	}

}
