package mycompany.frameworks;

import mycompany.model.PostData;
import mycompany.pageobject.NewPostPage;
import mycompany.pageobject.PublishedPostPage;
import mycompany.service.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditPostTestCase extends CreateNewPostTestCase {

    @Test (dataProvider = "postData",dataProviderClass = DataProviders.class, dependsOnMethods = "createNewPostTestCase")

    public void editPostTestCase (PostData postData) throws InterruptedException {

        PublishedPostPage publishedPostPage = PageFactory.initElements(driver, PublishedPostPage.class);
        NewPostPage newPostPage = PageFactory.initElements(driver, NewPostPage.class);

        publishedPostPage.goToEditPostPage();
        log.info("Went to the edit post page.");
        newPostPage.editPost(" " + postData.getEditedContent());
        log.info("Edited post, added new content.");
        newPostPage.clickPublishButton();
        log.info("Clicked on publish button.");
        newPostPage.goToNewPost();
        log.info("Opened page with edited post.");

        boolean condition = publishedPostPage.getEditedContentText().contains(postData.getContent()+" "+postData.getEditedContent());
        Assert.assertTrue(condition, "Edited content not displayed on the page");
        log.info("Found expected edited content on the page: "+publishedPostPage.getEditedContentText());

        Thread.sleep(2000);
    }
}
