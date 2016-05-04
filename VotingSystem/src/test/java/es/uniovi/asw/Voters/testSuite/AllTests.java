package es.uniovi.asw.Voters.testSuite;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.uniovi.asw.Voters.dbManagerTests.DBManagementImplTest;
//import es.uniovi.asw.Voters.dbManagerTests.DBManagementVirtualTest;
import es.uniovi.asw.Voters.exceptionsTest.ExceptionTests;
import es.uniovi.asw.Voters.modelsTests.VoterTest;
import es.uniovi.asw.Voters.typesTests.ChangePassTest;
import es.uniovi.asw.Voters.typesTests.EncrypterTest;
import es.uniovi.asw.Voters.typesTests.UserInfoTest;
import es.uniovi.asw.Voters.typesTests.UserPassTest;
import es.uniovi.asw.Voters.voterAccess.MainControllerTest;


@RunWith(Suite.class)
@SuiteClasses({ ChangePassTest.class,
				EncrypterTest.class, 
				UserInfoTest.class, 
				UserPassTest.class,
				//DBManagementVirtualTest.class,				
				ExceptionTests.class,
				VoterTest.class,
				MainControllerTest.class,
				DBManagementImplTest.class,
				})
public class AllTests {}
