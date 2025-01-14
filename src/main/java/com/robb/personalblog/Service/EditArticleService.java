package com.robb.personalblog.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import domain.Article;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
public class EditArticleService {

    public void editArticle(String title, String date, String content) {
        String file = "src/main/resources/articles/" + title.replace(" ", "").toLowerCase() + ".json";
        Article article = new Article(title, date, content);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(new File(file), article);
            System.out.println("Article has been edited successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
