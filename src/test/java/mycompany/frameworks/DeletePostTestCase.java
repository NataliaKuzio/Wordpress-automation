package mycompany.frameworks;

import mycompany.pageobject.NewPostPage;
import mycompany.pageobject.ReviewNewPostPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePostTestCase extends EditPostTestCase {

    @Test (dependsOnMethods = "editPostTestCase")

    public void deletePostTestCase (){

        ReviewNewPostPage reviewNewPostPage = PageFactory.initElements(driver, ReviewNewPostPage.class);
        NewPostPage newPostPage = PageFactory.initElements(driver, NewPostPage.class);

        reviewNewPostPage.goToEditPostPage();
        newPostPage.deletePost();

        boolean conditionDelete = driver.findElement(By.xpath("//div[@id='message']")).getText().contains("1 запис переміщений до кошика.");
        Assert.assertTrue(conditionDelete, "Expected message not displayed on the page");
    }
}
