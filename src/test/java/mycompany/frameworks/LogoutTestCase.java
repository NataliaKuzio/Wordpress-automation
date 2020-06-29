package mycompany.frameworks;

import mycompany.pageobject.AdminPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTestCase extends LoginTestCase{

    @Test
    public void logoutTestCase () {

        AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);

        adminPage.moveMouseToMainMenu();
        adminPage.logout();

        boolean condition = driver.findElement(By.xpath("//p[@class='message']")).getText().contains("Ви вийшли з системи.");
        Assert.assertTrue(condition, "Expected username not displayed on the page");
    }
}
