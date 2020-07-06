package mycompany.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublishedPostPage {

    private final WebDriver driver;

    public PublishedPostPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='post-edit-link']")
    private WebElement editPostLink;

    @FindBy(xpath = "//h1[@class='entry-title']")
    private WebElement titleText;

    @FindBy(xpath = "//div[@class='entry-content']/p")
    private WebElement contentText;

    @FindBy(xpath = "//div[@class='entry-content']/p")
    private WebElement editedContentText;


    public void goToEditPostPage(){
        editPostLink.click();
    }

    public String getTitleText(){
        return titleText.getText();
    }

    public String getContentText(){
        return contentText.getText();
    }

    public String getEditedContentText(){
        return editedContentText.getText();
    }
}
