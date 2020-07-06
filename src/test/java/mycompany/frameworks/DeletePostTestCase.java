package mycompany.frameworks;

import mycompany.pageobject.AllPostsPage;
import mycompany.pageobject.NewPostPage;
import mycompany.pageobject.PublishedPostPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePostTestCase extends EditPostTestCase {

    @Test (dependsOnMethods = "editPostTestCase")

    public void deletePostTestCase (){

        PublishedPostPage publishedPostPage = PageFactory.initElements(driver, PublishedPostPage.class);
        NewPostPage newPostPage = PageFactory.initElements(driver, NewPostPage.class);
        AllPostsPage allPostsPage=PageFactory.initElements(driver,AllPostsPage.class);

        publishedPostPage.goToEditPostPage();
        log.info("Went to the edit post page.");
        newPostPage.deletePost();
        log.info("Deleted post.");

        boolean conditionDelete = allPostsPage.getDeleteMessage().contains("1 запис переміщений до кошика.");
        Assert.assertTrue(conditionDelete, "Expected message not displayed on the page");
        log.info("Found expected message on the page: "+allPostsPage.getDeleteMessage());
    }
}
