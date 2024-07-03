package test;

import main.java.pageEvents.HomePageEvents;
import main.java.pageEvents.LoginPageEvents;
import org.testng.annotations.Test;

public class SampleAmazonTest extends BaseTest{


    @Test(invocationCount = 1)
    public void emailEntering(){
        //sends driver instance to the Event classes
        HomePageEvents hp=new HomePageEvents(getDriver());
        hp.clickOnSignInButton();
        LoginPageEvents lp=new LoginPageEvents(getDriver());
        lp.verifyLoginPageOpened();
        lp.enterEmailId();
    }

}
