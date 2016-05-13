package es.uniovi.asw.voters.dbmanagertests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;
import es.uniovi.asw.dbmanagement.Persistence;
import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.dbmanagement.impl.DBManagementImpl;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.voters.types.ChangePass;
import es.uniovi.asw.voters.types.Encrypter;
import es.uniovi.asw.voters.types.UserPass;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class DBManagementImplTest {

	@Autowired
	VoterRepository voterRepository = Persistence.voter;

	DBManagementImpl dbTest = new DBManagementImpl(voterRepository);

	@Test
	public void shouldWireRepositoryLocal() {
		assertNotNull(voterRepository);
	}

	@Test
	public void testDBManagementImpl() {
		DBManagementImpl db = new DBManagementImpl();
		assertNull(db.getVoterRepository());
	}

	@Test
	public void testDBManagementImplVoterRepository() {
		DBManagementImpl db = new DBManagementImpl(voterRepository);
		assertNotNull(db.getVoterRepository());
		assertTrue(Persistence.voter.getClass().equals((voterRepository).getClass()));
	}

	@Test
	public void testGetVoterString() {
		Voter voter1 = new Voter("User10", "user10@mail.com", "user10", "1111111X");
		dbTest.save(voter1);
		Voter voter2 = dbTest.getVoter("user10@mail.com");
		String pass = voter2.getPassword();
		assertEquals(voter2.toString(),
				"Voter [nombre=User10, email=user10@mail.com, nif=1111111X, password=" + pass + "]");
	}

	@Test
	public void testGetVoterUserPass() throws Exception {
		Voter voter1 = new Voter("User10", "user10@mail.com", Encrypter.encrypt("user10"), "1111111X");
		dbTest.save(voter1);
		UserPass up = new UserPass("user10@mail.com", "user10");
		Voter voter2 = dbTest.getVoter(up);
		assertTrue(voter1.equals(voter2));
	}

	// @Test
	public void testChangePassword() {
		Voter voter1 = new Voter("User10", "user10@mail.com", "user10", "1111111X");
		dbTest.save(voter1);
		dbTest.changePassword(new ChangePass("user10@mail.com", "user10", "user11"));
		dbTest.getVoter("user10@mail.com");
	}

	@Test
	public void testGetVoterRepository() {
		DBManagementImpl db = new DBManagementImpl(voterRepository);
		assertNotNull(db);
	}

	@After
	public void finalizar() {
		voterRepository = null;
	}

}
