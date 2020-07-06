package mycompany.frameworks;

import mycompany.model.PostData;
import mycompany.pageobject.AdminPage;
import mycompany.pageobject.NewPostPage;
import mycompany.pageobject.PublishedPostPage;
import mycompany.service.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.Date;

public class CreateNewPostTestCase extends LoginTestCase{

    public PostData post;

    @Test (dataProvider = "postData",dataProviderClass = DataProviders.class, dependsOnMethods = "loginTestCase")
    public void createNewPostTestCase(PostData postData) throws InterruptedException {

        post = postData;

        AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);
        NewPostPage newPostPage = PageFactory.initElements(driver, NewPostPage.class);
        PublishedPostPage publishedPostPage = PageFactory.initElements(driver, PublishedPostPage.class);

        adminPage.clickOnNewPostButton();
        log.info("Opened page to create a new post.");
        newPostPage.createNewPost(log,postData.getTitle(),postData.getContent());
        newPostPage.clickPublishButton();
        log.info("Clicked on publish button.");
        newPostPage.goToNewPost();
        log.info("Opened page with new post.");

        boolean conditionTitle = publishedPostPage.getTitleText().contains(postData.getTitle());
        Assert.assertTrue(conditionTitle, "Expected title not displayed on the page");
        log.info("Found expected title on the page: " + publishedPostPage.getTitleText());

        boolean conditionContent = publishedPostPage.getContentText().contains(postData.getContent());
        Assert.assertTrue(conditionContent, "Expected content not displayed on the page");
        log.info("Found expected content on the page: "+publishedPostPage.getContentText());
    }
}
