package mycompany.service;

import mycompany.model.PostData;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    @DataProvider(name = "postData")
    public static Object[][] postData() throws IOException {

        return new Object[][]{{new PostData()}};
    }
}
