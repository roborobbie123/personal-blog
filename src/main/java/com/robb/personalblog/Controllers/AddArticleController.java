package com.robb.personalblog.Controllers;

import com.robb.personalblog.Service.AddArticleService;
import com.robb.personalblog.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddArticleController {

    @Autowired
    private AddArticleService addArticleService;

    @RequestMapping("/addarticle")
    public String returnAddArticle(){
        return "addarticle";
    }

    @PostMapping("/addarticle")
    public String addArticle(@RequestParam("title") String title, @RequestParam("date") String date, @RequestParam("content") String content) {
        addArticleService.addArticle(title, date, content);
        return "redirect:/dashboard";
    }
}
