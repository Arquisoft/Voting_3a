package es.uniovi.asw.Voters.dbManagerTests;

import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class DBManagementVirtualTest {
/*
	//DBManagement db = new DBManagementImpl();
	DBManagement db = new DBManagementVirtualImpl();

	@Autowired
	VoterRepository voterRepository;
	
    @Test
    public void shouldWireRepositoryLocal() {
    	assertNotNull(voterRepository);
    }
    
    
    //@Test
    public void shouldWireRepository() {
    	assertNotNull(((DBManagementImpl)db)._getVoterRepository());
    }
    
    @Test
	public void getVoterByEmail() {
		Voter voter1 = new Voter("User1", "user1@mail.com", "user1", "12312321Q", 123);
		Voter voter2 = db.getVoter("user1@mail.com");
		assertTrue(voter1.equals(voter2));
	}

	//public void getVoterByUserPass() {}

	
    @Test
	public void get() {
		db.save(new Voter("User1", "user1@mail.com", "user1", "12312321Q", 123));
		Voter voter1 = new Voter("User1", "user1@mail.com", "user1", "12312321Q", 123);
		Voter voter2 = db.getVoter("user1@mail.com");
		assertTrue(voter1.equals(voter2));
	}
    
    @Test
    public void changePassword()
    {
    	db.save(new Voter("Antonio", "antonio@uniovi.com", "pass", "1234566K", 412));
    	String login= "antonio@uniovi.com";
    	String pass = "pass";
    	String nuevaPass = "newPass";
    	ChangePass cp= new ChangePass();
    	assertFalse(db.changePassword(cp));
    	cp= new ChangePass(login, pass, pass);
    	assertFalse(db.changePassword(cp));
    	cp= new ChangePass(login, pass, nuevaPass);
    	assertTrue(db.changePassword(cp));
   	
    }
    
	@Test
	public void save() {
		db.save(new Voter("User10", "user10@mail.com", "user10", "1111111X", 123));
		Voter voter1 = new Voter("User10", "user10@mail.com", "user10", "1111111X", 123);
		Voter voter2 = db.getVoter("user10@mail.com");
		assertTrue(voter1.equals(voter2));
	}
*/
}