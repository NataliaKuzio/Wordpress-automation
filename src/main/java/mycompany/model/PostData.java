package mycompany.model;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import static mycompany.service.Reader.parseCSVToList;

public class PostData {

    private String title;
    private String content;
    private String editedContent;

    public String getEditedContent() { return editedContent; }
    public void setEditedContent(String editedContent) { this.editedContent = editedContent; }

    public String getTitle() { return title; }
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
        List<String> dataList = parseCSVToList(System.getProperty("user.dir")+ "/src/test/resources/postdata.txt");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        this.title = dataList.get(0) + " " + timestamp.getTime();
        this.content = dataList.get(1) + " " + timestamp.getTime();
        this.editedContent = dataList.get(2) + " " + timestamp.getTime();
    }
}
