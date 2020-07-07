package mycompany.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPostPage {

    private final WebDriver driver;

    public NewPostPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='post_title']")
    private WebElement postTitleTextField;

    @FindBy(xpath = "//iframe[@id='content_ifr']")
    private WebElement iFrameContent;

    @FindBy(xpath = "//body[@id='tinymce']")
    private WebElement contentTextField;

    @FindBy(xpath = "//input[@id='publish']")
    private WebElement publishButton;

    @FindBy(xpath = "//div[@id='mceu_1']")
    private WebElement boldTextType;

    @FindBy(xpath = "//div[@id='mceu_2']")
    private WebElement italicsTextType;

    @FindBy(xpath = "//div[@id='mceu_6']")
    private WebElement onTheLeftTextType;

    @FindBy(xpath = "//div[@id='mceu_7']")
    private WebElement inTheMiddleTextType;

    @FindBy(xpath = "//div[@id='mceu_5']")
    private WebElement quoteTextType;

    @FindBy (xpath = "//div[@id='message']/p/a")
    private WebElement viewNewPostLink;

    @FindBy (xpath = "//div[@id='delete-action']")
    private WebElement deleteButton;

    public void createNewPost(Logger log, String title, String content){
        postTitleTextField.sendKeys(title);
        log.info("Input title: "+title+".");
        driver.switchTo().frame(iFrameContent);
        contentTextField.sendKeys(content);
        log.info("Input content: "+content+".");
        driver.switchTo().defaultContent();
        inTheMiddleTextType.click();
        log.info("Text placed in the middle.");
        quoteTextType.click();
        log.info("Text changed to quote.");
        italicsTextType.click();
        log.info("Text changed to italics.");

    }

    public void clickPublishButton(){
        publishButton.click();
    }

    public void goToNewPost(){
         viewNewPostLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(viewNewPostLink));
}

    public void editPost(Logger log, String editedContent) {
        driver.switchTo().frame(iFrameContent);
        Actions actions = new Actions(driver);
        contentTextField.sendKeys(editedContent);
        log.info("Added new content.");
        actions.keyDown(contentTextField, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        driver.switchTo().defaultContent();

        boldTextType.click();
        log.info("Text changed to bold.");
        italicsTextType.click();
        log.info("Text changed to italics.");
        onTheLeftTextType.click();
        log.info("Text placed on the left.");
    }

    public void deletePost(){deleteButton.click();}
}
