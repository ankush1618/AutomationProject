package test;

import org.testng.annotations.Test;
import main.java.pageEvents.HomePage;

public class SampleAmazonTest_PageFactory extends BaseTest{
    HomePage hp;

    @Test(priority=1)
    public void navigateToHomePage(){
        hp=new HomePage(getDriver());
        hp.clickOnSignInButton();
    }

    @Test(priority=2)
    public void navigateToLogin(){
        hp=new HomePage(getDriver());
        hp.clickOnSignInButton();
    }

}
