package es.uniovi.asw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        InputTest.class, 
        LoadUsersTest.class, 
        ValidationTest.class })
public class AllTests {

}
