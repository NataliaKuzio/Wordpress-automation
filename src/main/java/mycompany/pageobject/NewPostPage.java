package mycompany.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;


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

    @FindBy(xpath = "//div[@id='mceu_7']")
    private WebElement inTheMiddleTextType;

    @FindBy (xpath = "//div[@class='updated notice notice-success is-dismissible']/p/a")
    private WebElement viewNewPostLink;

    @FindBy (xpath = "//div[@id='delete-action']")
    private WebElement deleteButton;

    public void createNewPost(Logger log, String title, String content){
        postTitleTextField.sendKeys(title);
        log.info("Inputted title: "+title+".");
        driver.switchTo().frame(iFrameContent);
        contentTextField.sendKeys(content);
        log.info("Inputted content: "+content+".");
        driver.switchTo().defaultContent();
    }

    public void clickPublishButton() throws InterruptedException {
        publishButton.click();
        Thread.sleep(2000);
    }

    public void goToNewPost() {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='updated notice notice-success is-dismissible']/p/a")));
        viewNewPostLink.click();
    }

    public void editPost(String editedContent) {
        driver.switchTo().frame(iFrameContent);
        Actions actions = new Actions(driver);
        contentTextField.sendKeys(editedContent);
        actions.keyDown(contentTextField, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        driver.switchTo().defaultContent();
        boldTextType.click();
        italicsTextType.click();
        inTheMiddleTextType.click();
    }

    public void deletePost(){deleteButton.click();}

}
