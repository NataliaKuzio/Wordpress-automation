package mycompany.frameworks;

import mycompany.model.PostData;
import mycompany.pageobject.NewPostPage;
import mycompany.pageobject.ReviewNewPostPage;
import mycompany.service.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditPostTestCase extends CreateNewPostTestCase {

    @Test (dataProvider = "postData",dataProviderClass = DataProviders.class, dependsOnMethods = "createNewPostTestCase")

    public void editPostTestCase (PostData postData) throws InterruptedException {

        ReviewNewPostPage reviewNewPostPage = PageFactory.initElements(driver, ReviewNewPostPage.class);
        NewPostPage newPostPage = PageFactory.initElements(driver, NewPostPage.class);

        reviewNewPostPage.goToEditPostPage();
        newPostPage.editPost(" " + postData.getEditedContent());
        newPostPage.clickPublishButton();
        newPostPage.goToNewPost();

        boolean conditionEditedContent = driver.findElement(By.xpath("//div[@class='entry-content']/p")).getText().contains(postData.getContent()+" "+postData.getEditedContent());
        Assert.assertTrue(conditionEditedContent, "Edited content not displayed on the page");
        Thread.sleep(2000);
    }
}
