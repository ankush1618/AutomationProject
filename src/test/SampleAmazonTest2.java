package test;

import main.java.pageEvents.HomePageEvents;
import main.java.pageEvents.LoginPageEvents;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SampleAmazonTest2 extends BaseTest{

  private static Logger logger=LogManager.getLogger(SampleAmazonTest2.class);
    @Test
    public void emailEntering(){
        logger.trace("This is Trace Message");
        logger.info("This is Information Message");
        logger.warn("This is Warning Message");
        logger.error("This is Error Message");
        logger.fatal("This is Fatal Message");
        HomePageEvents hp=new HomePageEvents(getDriver());
        hp.clickOnSignInButton();
        LoginPageEvents lp=new LoginPageEvents(getDriver());
        lp.verifyLoginPageOpened();
        lp.enterEmailId();
    }


}
