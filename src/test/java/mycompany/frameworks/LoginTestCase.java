package mycompany.frameworks;

import mycompany.pageobject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestCase extends BaseTestCase {

    @Test
    public void loginTestCase() {
        driver.get("https://www.instrumaster.com/wp-admin");

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(System.getProperty("user.name"), System.getProperty("user.password"));

        boolean condition = driver.findElement(By.xpath("//li[@class='menupop' and @id='wp-admin-bar-my-account']/a[@class='ab-item']")).getText().contains("Привіт, "+ System.getProperty("user.name"));
        Assert.assertTrue(condition, "Expected username not displayed on the page");

    }
}

