package com.robb.personalblog.Controllers;

import com.robb.personalblog.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/article")
        public String article() {
            return "article";
        }


    @RequestMapping("/article/{title}")
    public String articleSelect(@PathVariable String title, Model model) throws IOException {
        String article = articleService.getByTitle(title.replace(" ", ""));
        model.addAttribute("article",article);

        return "article";
    }
}
