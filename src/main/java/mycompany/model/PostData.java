package mycompany.model;

import java.io.IOException;
import java.util.List;

import static mycompany.service.Reader.parseCSVToList;

public class PostData {

    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostData() throws IOException {
        List<String> dataList = parseCSVToList(System.getProperty("user.dir")+ "/src/test/java/mycompany/resources/postdata.txt");

        this.title = dataList.get(0);
        this.content = dataList.get(1);
    }
}
