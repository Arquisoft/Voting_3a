package es.uniovi.asw.Voters.typesTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;

import es.uniovi.asw.Voters.types.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class EncrypterTest {

	@Test
	public void testEncryptDecrypt() throws Exception {
		String texto="Hola mundo hacker";
		String textoEncriptado = Encrypter.encrypt(texto);
		String solucion = Encrypter.decrypt(textoEncriptado);
		assertTrue(solucion.equals(texto));
	}

}
