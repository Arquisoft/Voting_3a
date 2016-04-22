/**
 * 
 */
package modelsTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;
import es.uniovi.asw.model.Voter;

/**
 * @author amir 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class VoterTest {
	
	private String nombre="pepe";
	private String email="correo@dom.com";
	private String password="pass";
	private String nif="numNif";
	private long pollingStationCode=128L; 


	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		Voter v = new Voter();
		assertTrue(v.hashCode()==31*31);
		v = new Voter(nombre, email, password, nif, pollingStationCode);
		int result= 31 + email.hashCode();
		result = 31 * result + nif.hashCode();
		assertTrue(v.hashCode()==result);
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#Voter()}.
	 */
	@Test
	public void testVoter() {
		Voter v = new Voter();
		assertNull(v.getNombre());
		assertNull(v.getNif());
		assertNull(v.getEmail());
		assertNull(v.getPassword());
		assertNull(v.getPollingStationCode());
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#Voter(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long)}.
	 */
	@Test
	public void testVoterStringStringStringStringLong() {
		Voter v = new Voter(nombre, email, password, nif, pollingStationCode);
		assertNotNull(v.getNombre());
		assertNotNull(v.getNif());
		assertNotNull(v.getEmail());
		assertNotNull(v.getPassword());
		assertNotNull(v.getPollingStationCode());
		
		assertTrue(nombre.equals(v.getNombre()));
		assertTrue(nif.equals(v.getNif()));
		assertTrue(email.equals(v.getEmail()));
		assertTrue(password.equals(v.getPassword()));
		assertTrue(pollingStationCode==v.getPollingStationCode());		
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#setEmail(java.lang.String)}.
	 */
	@Test
	public void testSetEmail() {
		Voter v = new Voter();
		assertNull(v.getNombre());
		v.setEmail(email);
		assertNotNull(v.getEmail());
		assertTrue(email.equals(v.getEmail()));
		
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetPassword() {
		Voter v = new Voter();
		assertNull(v.getPassword());
		v.setPassword(password);
		assertNotNull(v.getPassword());
		assertTrue(password.equals(v.getPassword()));
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#setPollingStationCode(long)}.
	 */
	@Test
	public void testSetPollingStationCode() {
		Voter v = new Voter();
		assertNull(v.getPollingStationCode());
		v.setPollingStationCode(pollingStationCode);
		assertNotNull(v.getPollingStationCode());
		assertTrue(pollingStationCode==(v.getPollingStationCode()));
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#setNombre(java.lang.String)}.
	 */
	@Test
	public void testSetNombre() {
		Voter v = new Voter();
		assertNull(v.getNombre());
		v.setNombre(nombre);
		assertNotNull(v.getNombre());
		assertTrue(nombre.equals(v.getNombre()));
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#setNif(java.lang.String)}.
	 */
	@Test
	public void testSetNif() {
		Voter v = new Voter();
		assertNull(v.getNif());
		v.setNif(nif);
		assertNotNull(v.getNif());
		assertTrue(nif.equals(v.getNif()));
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Voter v = new Voter(nombre, email, password, nif, pollingStationCode);
		Object o=v;
		assertTrue(v.equals(o));
		assertFalse(v.equals(null));
		Long l=1L;
		assertFalse(v.equals(l));
		Voter vDef= new Voter(nombre, null, password, nif, pollingStationCode);
		assertFalse(vDef.equals(v));
		assertFalse(v.equals(vDef));
		vDef= new Voter(nombre, "otro@email.es", password, nif, pollingStationCode);
		assertFalse(vDef.equals(v));
		assertFalse(v.equals(vDef));
		vDef= new Voter(nombre, email, password, null , pollingStationCode);
		assertFalse(vDef.equals(v));
		assertFalse(v.equals(vDef));
		vDef= new Voter(nombre, email, password, "99999" , pollingStationCode);
		assertFalse(vDef.equals(v));
		assertFalse(v.equals(vDef));
		
		assertTrue(v.equals(v));
		
	
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#toString()}.
	 */
	@Test
	public void testToString() {
		Voter v = new Voter(nombre, email, password, nif, pollingStationCode);
		assertTrue(v.toString().equals("Voter [nombre="+nombre+", email="+email+", nif="+nif+", password="+password+", pollingStationCode="+pollingStationCode+"]"));
		assertNotNull(v.toString());
	}
}
