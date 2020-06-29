package mycompany.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AdminPage {

    private final WebDriver driver;

    public AdminPage(WebDriver driver) { this.driver = driver; }

    @FindBy(xpath = "//li[@id='wp-admin-bar-logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//li[@id='wp-admin-bar-my-account']/a[@class='ab-item']")
    private WebElement menuMain;
    
    @FindBy(xpath = "//li[@id='menu-posts']")
    private WebElement menuPost;

    @FindBy (xpath = "//a[@class='wp-first-item xh-highlight']")
    private WebElement allPostsButton;

    @FindBy (xpath = "//a[@href='post-new.php']")
    private WebElement newPostButton;
            

    public void moveMouseToMainMenu(){
        Actions actions = new Actions(driver);
        actions.moveToElement(menuMain).perform();
    }

    public void logout () {
        logoutButton.click();
    }

    public void clickOnNewPostButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(menuPost).perform();
        newPostButton.click();
    }

    public void clickOnAllPostsButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(menuPost).perform();
        allPostsButton.click();
    }

}
