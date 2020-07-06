package mycompany.frameworks;

import mycompany.pageobject.AdminPage;
import mycompany.pageobject.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestCase extends BaseTestCase  {

    @Test
    public void loginTestCase() {
        String webPage = "https://www.instrumaster.com/wp-admin";
        driver.get(webPage);
        log.info("Opened web page: " + webPage);

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);

        loginPage.login(log, System.getProperty("user.name"), System.getProperty("user.password"));

        boolean condition = adminPage.getDisplayName().contains("Привіт, "+ System.getProperty("user.name"));
        Assert.assertTrue(condition, "Expected display name not displayed on the page");
        log.info("Found expected display name: "+System.getProperty("user.name"));
    }
}

