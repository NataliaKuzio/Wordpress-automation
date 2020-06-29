package mycompany.pageobject;

import org.openqa.selenium.By;
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
    private WebElement postTitleField;

    @FindBy(xpath = "//iframe[@id='content_ifr']")
    private WebElement iFrameContent;

    @FindBy(xpath = "//body[@id='tinymce']")
    private WebElement contentField;

    @FindBy(xpath = "//input[@id='publish']")
    private WebElement publishButton;

    @FindBy(xpath = "//div[@id='mceu_1']")
    private WebElement boldType;

    @FindBy(xpath = "//div[@id='mceu_2']")
    private WebElement italicsType;

    @FindBy(xpath = "//div[@id='mceu_7']")
    private WebElement inTheMiddleType;

    @FindBy (xpath = "//div[@class='updated notice notice-success is-dismissible']/p/a")
    private WebElement viewNewPostLink;

    @FindBy (xpath = "//div[@id='delete-action']")
    private WebElement deleteButton;

    public void createNewPost(String title, String content){
        postTitleField.sendKeys(title);
        driver.switchTo().frame(iFrameContent);
        contentField.sendKeys(content);
        driver.switchTo().defaultContent();
    }

    public void clickPublishButton() throws InterruptedException {
        publishButton.click();
        Thread.sleep(2000);
    }

    public void goToNewPost() {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='updated notice notice-success is-dismissible']/p/a")));
        String linkAddress= viewNewPostLink.getText();
        System.out.println(linkAddress);
        viewNewPostLink.click();
    }

    public void editPost(String editedContent) {
        driver.switchTo().frame(iFrameContent);
        Actions actions = new Actions(driver);
        contentField.sendKeys(editedContent);
        actions.keyDown(contentField, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        driver.switchTo().defaultContent();
        boldType.click();
        italicsType.click();
        inTheMiddleType.click();
    }

    public void deletePost(){deleteButton.click();}

}
