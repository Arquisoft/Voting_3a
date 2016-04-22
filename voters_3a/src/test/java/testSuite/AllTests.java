package testSuite;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import dbManagerTests.*;
import exceptionsTest.*;
import modelsTests.*;
import typesTests.*;
import voterAccess.*;


@RunWith(Suite.class)
@SuiteClasses({ ChangePassTest.class,
				EncrypterTest.class, 
				UserInfoTest.class, 
				UserPassTest.class,
				DBManagementVirtualTest.class,				
				ExceptionTests.class,
				VoterTest.class,
				MainControllerTest.class,
				DBManagementImplTest.class,
				})
public class AllTests {}
