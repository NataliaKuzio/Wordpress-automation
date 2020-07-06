package mycompany.frameworks;

import mycompany.pageobject.AdminPage;
import mycompany.pageobject.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTestCase extends DeletePostTestCase{

    @Test (dependsOnMethods = "deletePostTestCase")
    public void logoutTestCase () {

        AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        adminPage.logout();
        log.info("Clicked on logout button");

        boolean condition = loginPage.getLogoutMessage().contains("Ви вийшли з системи.");
        Assert.assertTrue(condition, "Expected message not displayed on the page");
        log.info("Found expected message on the page: "+ loginPage.getLogoutMessage());
    }
}
