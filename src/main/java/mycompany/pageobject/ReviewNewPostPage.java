package mycompany.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewNewPostPage {

    private final WebDriver driver;

    public ReviewNewPostPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='post-edit-link']")
    private WebElement editPostLink;

    public void goToEditPostPage(){
        editPostLink.click();
    }
}
