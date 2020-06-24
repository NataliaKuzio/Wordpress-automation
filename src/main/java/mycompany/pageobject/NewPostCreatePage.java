package mycompany.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPostCreatePage {

    private final WebDriver driver;
    public NewPostCreatePage (WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='post_title']")
    private WebElement postTitleField;

    @FindBy(xpath = "//iframe[@id='content_ifr']")
    private WebElement iFrameContent;

    @FindBy(xpath = "//body[@id='tinymce']")
    private WebElement contentField;

    @FindBy(xpath = "//input[@name='publish']")
    private WebElement publishButton;

    @FindBy(xpath = "//div[@id='mceu_1']")
    private WebElement boldType;

    @FindBy(xpath = "//div[@id='mceu_2']")
    private WebElement italicsType;

    @FindBy(xpath = "//div[@id='mceu_7']")
    private WebElement inTheMiddleType;

    @FindBy(xpath = "//div[@class='hide-if-no-js']")
    private WebElement linkBody;

    @FindBy(xpath = "//span[@id='sample-permalink']")
    private WebElement linkToNewPost;

    public void createNewPost (String title, String content){
        postTitleField.sendKeys(title);
        driver.switchTo().frame(iFrameContent);
        contentField.sendKeys(content);
        Actions actions = new Actions(driver);
        actions.keyDown(contentField, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        driver.switchTo().defaultContent();
        boldType.click();
        italicsType.click();
        inTheMiddleType.click();
    }

    public void getNewPostLink (){
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='sample-permalink']")));
        WebElement link = driver.findElement(By.xpath("//span[@id='sample-permalink']"));
        String linkText= link.getText();
    }

}
