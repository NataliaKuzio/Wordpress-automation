package mycompany.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='user_login']")
    private WebElement userNameTextField;

    @FindBy(xpath = "//input[@id='user_pass']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    public void login(String email, String password){
        userNameTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        submitButton.click();
    }
}
