package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsFetch {

   // WebDriver Idriverssss

    public WebElement getWebElment(WebDriver driver, String identifierType, String identifierValue){
        switch(identifierType) {
            case "ID":
                return driver.findElement(By.id(identifierValue));
            case "XPATH":
                return driver.findElement(By.xpath(identifierValue));
            case "TAGNAME":
                return driver.findElement(By.tagName(identifierValue));
            case "CSS":
                return driver.findElement(By.cssSelector(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getWebElments(WebDriver driver,String identifierType, String identifierValue){
        switch(identifierType) {
            case "ID":
                return driver.findElements(By.id(identifierValue));
            case "XPATH":
                return driver.findElements(By.xpath(identifierValue));
            case "TAGNAME":
                return driver.findElements(By.tagName(identifierValue));
            case "CSS":
                return driver.findElements(By.cssSelector(identifierValue));
            default:
                return null;
        }
    }
}
