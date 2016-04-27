package typesTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.types.ChangePass;
import es.uniovi.asw.types.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class UserInfoTest {
	private String name="pepe";
	private String nif="128";
	private String email="correo@dom.com";
	private Long pollingStationCode=256L;

	@Test
	public void testHashCode() {
		int hash=1;
		hash = 31 * hash + ((email == null) ? 0 : email.hashCode());
		hash = 31 * hash + ((name == null) ? 0 : name.hashCode());
		hash = 31 * hash + ((nif == null) ? 0 : nif.hashCode());
		hash = 31 * hash + ((pollingStationCode == null) ? 0 : pollingStationCode.hashCode());
		UserInfo ui = new UserInfo(name, nif, email,pollingStationCode);
		assertTrue(hash==ui.hashCode());
		ui = new UserInfo();
		assertTrue((31*31*31*31)==ui.hashCode());
	}

	@Test
	public void testUserInfo() {
		UserInfo ui = new UserInfo();
		assertNull(ui.getName());
		assertNull(ui.getEmail());
		assertNull(ui.getNif());
		assertNull(ui.getPollingStationCode());
	}

	@Test
	public void testUserInfoStringStringStringLong() {
		UserInfo ui = new UserInfo(name, nif, email,pollingStationCode);
		assertTrue(name.equals(ui.getName()));
		assertTrue(email.equals(ui.getEmail()));
		assertTrue(nif.equals(ui.getNif()));
		assertTrue(pollingStationCode.equals(ui.getPollingStationCode()));
	}

	@Test
	public void testUserInfoVoter() {
		Voter v = new Voter();
		UserInfo ui = new UserInfo(v);
		assertNull(v.getNombre());
		assertNull(v.getNif());
		assertNull(v.getEmail());		
		assertNull(v.getPollingStationCode());
		assertNull(ui.getName());
		assertNull(ui.getEmail());
		assertNull(ui.getNif());
		assertNull(ui.getPollingStationCode());

	}

	@Test
	public void testEqualsObject() {
		
		UserInfo ui = new UserInfo(name, nif, email,pollingStationCode);
		UserInfo ui2 = new UserInfo(name, nif, email,pollingStationCode);
		UserInfo uid = new UserInfo(name, nif, "diferente" ,pollingStationCode);
		UserInfo uin = new UserInfo(name, nif, null,pollingStationCode);
		UserInfo uinull = new UserInfo();
		assertFalse(ui.equals(uinull));
		assertFalse(ui.equals(new Object())); //dif obj
		Object o = ui;
		assertTrue(ui.equals(o)); //misma ref
		ChangePass cp= new ChangePass();
		assertFalse(ui.equals(cp));// diferentes class
		assertFalse(ui.equals(null));// ref null
		assertFalse(uin.equals(ui)); //mail null ref no
		assertFalse(ui.equals(uid)); //mail y ref diferente
		uin = new UserInfo(null, nif, email,pollingStationCode);
		uid = new UserInfo("diferente", nif, email ,pollingStationCode);
		assertFalse(uin.equals(ui)); // null ref no
		assertFalse(ui.equals(uid)); // dato y ref diferentes
		uin = new UserInfo(name, null, email,pollingStationCode);
		uid = new UserInfo(name, "diferente", email ,pollingStationCode);
		assertFalse(uin.equals(ui)); // null ref no
		assertFalse(ui.equals(uid)); // dato y ref diferentes
		uin = new UserInfo(name, nif, email,null);
		uid = new UserInfo(name, nif, email , pollingStationCode+1);
		assertFalse(uin.equals(ui)); // null ref no
		assertFalse(ui.equals(uid)); // dato y ref diferentes
	
		assertTrue(ui.equals(ui2)); // todo ok :D
	}

	@Test
	public void testToString() {
		UserInfo ui = new UserInfo(name, nif, email,pollingStationCode);
		assertTrue(("UserInfo [name="+name+", nif="+nif+", email="+email+", pollingStationCode="+pollingStationCode+"]").equals(ui.toString()));
		
	}
	

	@Test
	public void testUserInfoVacio() throws Exception {

		UserInfo ui = new UserInfo();
		assertTrue(ui.hashCode()==923521);
		assertTrue(ui.toString().equals("UserInfo [name=null, "
				+ "nif=null, "
				+ "email=null, "
				+ "pollingStationCode=null]"));
	}

	@Test
	public void testUserInfoCompare() throws Exception {

		UserInfo ui1 = new UserInfo();
		UserInfo ui2 = new UserInfo();
		//compara 2 null
		assertTrue(ui1.equals(ui2));
		ui2 = new UserInfo("name", "nif", "email", 123L);
		// compara un null con un bien formado
		assertFalse(ui1.equals(ui2));
		// comapra 2 bien formados
		ui1 = new UserInfo("name", "nif", "email", 123L);
		assertTrue(ui1.equals(ui2));
		//compara dif nif
		ui1 = new UserInfo("pepe", "25", "email@dom.com", 1L);
		ui2 = new UserInfo("pepe", "50", "email@dom.com", 1L);
		assertFalse(ui1.equals(ui2));
		//compara dif nombre
		ui1 = new UserInfo("pepe", "25", "email@dom.com", 1L);
		ui2 = new UserInfo("juan", "25", "email@dom.com", 1L);
		assertFalse(ui1.equals(ui2));
		//compara dif colegio electoral
		ui1 = new UserInfo("pepe", "50", "email@dom.com", 8L);
		ui2 = new UserInfo("pepe", "50", "email@dom.com", 1L);
		assertFalse(ui1.equals(ui2));
		//compara dif correo
		ui1 = new UserInfo("pepe", "50", "mail@dom.com", 1L);
		ui2 = new UserInfo("pepe", "50", "email@hotmail.com", 1L);
		assertFalse(ui1.equals(ui2));
	}


}
