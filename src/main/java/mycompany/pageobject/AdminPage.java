package mycompany.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AdminPage {
    private final WebDriver driver;
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@id='wp-admin-bar-logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//li[@id='wp-admin-bar-my-account']/a[@class='ab-item']")
    private WebElement popupList;

    public void moveMouse(){
        Actions actions = new Actions(driver);
        actions.moveToElement(popupList).perform();
    }

    public void logout () {
        logoutButton.click();
    }
}
