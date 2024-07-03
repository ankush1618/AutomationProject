package main.java.pageEvents;

import main.java.utils.ElementsFetch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.BaseTest;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[text()='Hello, sign in']")
    WebElement signInButton;

    public void clickOnSignInButton(){
        ElementsFetch ele=new ElementsFetch();
        BaseTest.logger.info("Login Button is Clicked");
        signInButton.click();
    }
}
