package mycompany.frameworks;

import mycompany.model.PostData;
import mycompany.pageobject.AdminPage;
import mycompany.pageobject.NewPostPage;
import mycompany.service.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewPostTestCase extends LoginTestCase{

    @Test (dataProvider = "postData",dataProviderClass = DataProviders.class, dependsOnMethods = "loginTestCase")

    public void createNewPostTestCase(PostData postData) throws InterruptedException {

        AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);
        NewPostPage newPostPage = PageFactory.initElements(driver, NewPostPage.class);

        adminPage.clickOnNewPostButton();
        newPostPage.createNewPost(postData.getTitle(),postData.getContent());
        newPostPage.clickPublishButton();
        newPostPage.goToNewPost();

        boolean conditionTitle = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText().contains(postData.getTitle());
        Assert.assertTrue(conditionTitle, "Expected title not displayed on the page");

        boolean conditionContent = driver.findElement(By.xpath("//div[@class='entry-content']/p")).getText().contains(postData.getContent());
        Assert.assertTrue(conditionContent, "Expected content not displayed on the page");

        Thread.sleep(2000);
    }
}
