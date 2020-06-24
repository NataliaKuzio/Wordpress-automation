package mycompany.frameworks;

import mycompany.model.PostData;
import mycompany.pageobject.AdminPage;
import mycompany.pageobject.NewPostCreatePage;
import mycompany.service.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class NewPostCreateTestCase extends LoginTestCase{

    @Test (dataProvider = "postData",dataProviderClass = DataProviders.class, dependsOnMethods = "loginTestCase")
    public void newPostCreateTestCase(PostData postData){

        AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);
        NewPostCreatePage newPostCreatePage = PageFactory.initElements(driver, NewPostCreatePage.class);

        adminPage.clickOnNewPostButton();
        newPostCreatePage.createNewPost(postData.getTitle(),postData.getContent());
        newPostCreatePage.getNewPostLink();
    }
}
