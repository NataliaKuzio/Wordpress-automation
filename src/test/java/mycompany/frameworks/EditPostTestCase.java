package mycompany.frameworks;

import mycompany.model.PostData;
import mycompany.pageobject.NewPostPage;
import mycompany.pageobject.PublishedPostPage;
import mycompany.service.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditPostTestCase extends CreateNewPostTestCase {

    @Test (dependsOnMethods = "createNewPostTestCase")

    public void editPostTestCase () {

        PublishedPostPage publishedPostPage = PageFactory.initElements(driver, PublishedPostPage.class);
        NewPostPage newPostPage = PageFactory.initElements(driver, NewPostPage.class);

        publishedPostPage.goToEditPostPage();
        log.info("Went to the edit post page.");
        newPostPage.editPost(log," " + post.getEditedContent());
        log.info("Edited post, added new content.");
        newPostPage.clickPublishButton();
        log.info("Clicked on publish button.");
        newPostPage.goToNewPost();
        log.info("Opened page with edited post.");

        String content = publishedPostPage.getEditedContentText();
        log.info("Post content: " + content);
        log.info("Compare content: " + post.getContent()+" "+post.getEditedContent());

        boolean condition = publishedPostPage.getEditedContentText().contains(post.getContent()+" "+post.getEditedContent());
        Assert.assertTrue(condition, "Edited content not displayed on the page");
        log.info("Found expected edited content on the page: "+publishedPostPage.getEditedContentText());
    }
}
