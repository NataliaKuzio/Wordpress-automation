package mycompany.pageobject;

import mycompany.service.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Methods {

    private final WebDriver driver;

    public AdminPage(WebDriver driver) { this.driver = driver; }

    @FindBy(xpath = "//li[@id='wp-admin-bar-logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//li[@id='wp-admin-bar-my-account']/a[@class='ab-item']")
    private WebElement myAccountPopupMenu;
    
    @FindBy(xpath = "//li[@id='menu-posts']")
    private WebElement postsPopupMenu;

    @FindBy (xpath = "//a[@class='wp-first-item xh-highlight']")
    private WebElement allPostsButton;

    @FindBy (xpath = "//a[@href='post-new.php']")
    private WebElement newPostButton;

    @FindBy(xpath = "//li[@class='menupop' and @id='wp-admin-bar-my-account']/a[@class='ab-item']")
    private WebElement displayNameText;
            

    public void logout(){
        moveToElement(driver,myAccountPopupMenu);
        logoutButton.click();
    }

    public void clickOnNewPostButton(){
       moveToElement(driver,postsPopupMenu);
       newPostButton.click();
    }

    public String getDisplayName(){
        return displayNameText.getText();
    }
}
