package mycompany.frameworks;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTestCase {
    WebDriver driver;
    Logger log;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log = Logger.getLogger("rootLogger");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
