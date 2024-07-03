package main.java.pageEvents;

import main.java.pageObjects.HomePageElements;
import main.java.utils.ElementsFetch;
import org.openqa.selenium.WebDriver;
import test.BaseTest;

public class HomePageEvents {

    //setting the driver value into the local driver value
    //and this driver is sent in ElementFetch Class
    WebDriver driver;

    public HomePageEvents(WebDriver driver){
        this.driver=driver;
    }


    public void clickOnSignInButton(){
        ElementsFetch ele=new ElementsFetch();
        BaseTest.logger.info("Clicking on SignIn Button");
        ele.getWebElment(driver,"XPATH", HomePageElements.signInButton).click();
    }
}
