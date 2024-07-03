package main.java.pageEvents;

import main.java.pageObjects.LoginPageElements;
import main.java.utils.ElementsFetch;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test.BaseTest;

public class LoginPageEvents {
    WebDriver driver;

    public LoginPageEvents(WebDriver driver){
        this.driver=driver;
    }

    public void verifyLoginPageOpened(){
        ElementsFetch ef=new ElementsFetch();
        BaseTest.logger.info("Verifying if the Login Text is displayed or not");
        //checking if Login Text is displayed on the Page or not
        Assert.assertTrue(ef.getWebElments(driver,"XPATH", LoginPageElements.loginText).size()>0,
                "Login Page did not Open");

    }

    public void enterEmailId(){
        ElementsFetch ef=new ElementsFetch();
        BaseTest.logger.info("Entering the email ID");
        ef.getWebElment(driver,"ID",LoginPageElements.email).sendKeys("ankush.pal@gmail.com");
        ef.getWebElment(driver,"ID",LoginPageElements.continueButton).click();
    }
}
