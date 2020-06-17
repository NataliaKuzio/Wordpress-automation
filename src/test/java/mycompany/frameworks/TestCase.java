package mycompany.frameworks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestCase {
    @Test
    public void testCase(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.instrumaster.com/wp-admin");
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("b1e83580-7c2c-11e7-a9d2-276a09ac404a");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement text1 = driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']/a[@class='ab-item']"));
        System.out.println("1:" + text1.getText());

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']/a[@class='ab-item']"))).perform();
        WebElement exit = driver.findElement(By.xpath("//li[@id='wp-admin-bar-logout']/a"));
        System.out.println("2:" + exit.getText());
        exit.click();

        WebElement text3 = driver.findElement(By.xpath("//p[@class='message']"));
        System.out.println("3:" + text3.getText());
    }
}
