package dbManagerTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;
import es.uniovi.asw.dbManagement.DBManagementImpl;
import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.model.Voter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class DBManagementImplTest {
	@Autowired
	VoterRepository voterRepository;
	
	DBManagementImpl dbTest = new DBManagementImpl(voterRepository);
	
    @Test
    public void shouldWireRepositoryLocal() {
    	assertNotNull(voterRepository);
    }

	@Test
	public void testDBManagementImpl() {
		DBManagementImpl db = new DBManagementImpl();
		assertNull(db._getVoterRepository());
	}

	@Test
	public void testDBManagementImplVoterRepository() {
		DBManagementImpl db = new DBManagementImpl(voterRepository);
		assertNotNull(db._getVoterRepository());
		assertTrue(db._getVoterRepository().getClass().equals((voterRepository).getClass()));
	}

	//@Test
	public void testSave() {			
			dbTest.save(   new Voter("User10", "user10@mail.com", "user10", "1111111X", 123));
			Voter voter1 = new Voter("User10", "user10@mail.com", "user10", "1111111X", 123);
			Voter voter2 = dbTest.getVoter("user10@mail.com");
			assertTrue(voter1.equals(voter2));
	}

	//@Test
	public void testGetVoterString() {
		fail("Not yet implemented");
	}

	//@Test
	public void testGetVoterUserPass() {
		fail("Not yet implemented");
	}

	//@Test
	public void testChangePassword() {
		fail("Not yet implemented");
	}

	//@Test
	public void test_getVoterRepository() {
		fail("Not yet implemented");
	}
	
	@After
	public void finalizar()
	{
		voterRepository=null;
	}
}
