package mycompany.pageobject;

import mycompany.service.Methods;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Methods {

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

    @FindBy(xpath = "//p[@class='message']")
    private WebElement logoutMessage;

    public void login(Logger log, String email, String password){
        userNameTextField.sendKeys(email);
        log.info("Inputted user email: " +email);
        passwordTextField.sendKeys(password);
        log.info("Inputted user password: " +password);
        submitButton.click();
        log.info("Clicked on the submit button.");
    }

    public String getLogoutMessage (){
        return logoutMessage.getText();
    }


}
