package com.robb.personalblog.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ArticleService {

    public String getByTitle(String title) throws IOException {

        String file = "src/main/resources/articles/" + title + ".json";
        Path path = Paths.get(file);

        if (!Files.exists(path)) {
            return null;
        }
        String content = new String(Files.readAllBytes(path));
        return content;
    }

    public List<String> parseJson(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> list = new ArrayList<>();

        try {
            JsonNode node = objectMapper.readTree(json);

            String title = node.get("title").asText();
            String content = node.get("content").asText();
            String date = node.get("date").asText();

            list.add(title);
            list.add(content);
            list.add(date);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
