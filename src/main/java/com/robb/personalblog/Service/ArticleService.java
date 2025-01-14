package com.robb.personalblog.Service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    public String getByTitle(String title) throws IOException {

        String file = "src/main/resources/articles/" + title + ".json";
        Path path = Paths.get(file);

        if(!Files.exists(path)){
            return null;
        }
        String content = new String(Files.readAllBytes(path));
        return content;
    }
}
