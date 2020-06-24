package mycompany.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public static List<String> parseCSVToList(String file) throws IOException {

        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get(file)));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return Arrays.asList(text.split("\\s*,\\s*"));
    }
}
