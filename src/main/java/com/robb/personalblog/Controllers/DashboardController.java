package com.robb.personalblog.Controllers;

import com.robb.personalblog.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    HomeService homeService;

    @RequestMapping("/dashboard")
    public String getHome(Model model) {
        String articlesDir = "src/main/resources/articles/";
        List<String> articles = new ArrayList<>();
        List<String> details = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<String> dates = new ArrayList<>();

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(articlesDir), "*.json")) {
            for (Path path : directoryStream) {
                String article = new String(Files.readAllBytes(path));
                articles.add(article);
                details = homeService.getTitleDate(article);
                titles.add(details.get(0));
                dates.add(details.get(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("titles", titles);
        model.addAttribute("dates", dates);
        return "dashboard";
    }


}
