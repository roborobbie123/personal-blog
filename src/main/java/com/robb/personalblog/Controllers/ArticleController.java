package com.robb.personalblog.Controllers;

import com.robb.personalblog.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        List<String> list = new ArrayList<>();
        list = articleService.parseJson(article);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));




        model.addAttribute("title", list.get(0));
        model.addAttribute("content", list.get(1));
        model.addAttribute("date", list.get(2));

        return "article";
    }
}
