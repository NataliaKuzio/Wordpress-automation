package mycompany.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.logging.Logger;

public class Methods {

    public static void moveToElement(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
