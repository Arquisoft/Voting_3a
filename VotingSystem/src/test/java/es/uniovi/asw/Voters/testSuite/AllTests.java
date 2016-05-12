package es.uniovi.asw.voters.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.uniovi.asw.voters.dbmanagertests.DBManagementImplTest;
//import es.uniovi.asw.voters.dbmanagertests.DBManagementVirtualTest;
import es.uniovi.asw.voters.exceptionstest.ExceptionTests;
import es.uniovi.asw.voters.modelstests.VoterTest;
import es.uniovi.asw.voters.typestests.ChangePassTest;
import es.uniovi.asw.voters.typestests.EncrypterTest;
import es.uniovi.asw.voters.typestests.UserInfoTest;
import es.uniovi.asw.voters.typestests.UserPassTest;
import es.uniovi.asw.voters.voteraccess.MainControllerTest;

@RunWith(Suite.class)
@SuiteClasses({ ChangePassTest.class, EncrypterTest.class, UserInfoTest.class, UserPassTest.class,
		 //DBManagementVirtualTest.class,
		ExceptionTests.class, VoterTest.class, MainControllerTest.class, DBManagementImplTest.class, })
public class AllTests {
}
