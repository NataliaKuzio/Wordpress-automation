package mycompany.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllPostsPage {

    private final WebDriver driver;

    public AllPostsPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='message']")
    private WebElement deleteMessage;

    public String getDeleteMessage(){
        return deleteMessage.getText();
    }
}
