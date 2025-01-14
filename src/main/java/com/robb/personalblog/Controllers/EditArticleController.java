package com.robb.personalblog.Controllers;

import com.robb.personalblog.Service.ArticleService;
import com.robb.personalblog.Service.EditArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EditArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private EditArticleService editArticleService;

    @RequestMapping("/editarticle/{title}")
    public String editArticle(@PathVariable String title, Model model) throws IOException {
        String article = articleService.getByTitle(title.replace(" ", ""));

        List<String> list = articleService.parseJson(article);

        model.addAttribute("title", list.get(0));
        model.addAttribute("content", list.get(1));
        model.addAttribute("date", list.get(2));

        return "editarticle";
    }

    @PostMapping("editarticle")
    public String articlePost( @RequestParam String title, @RequestParam String date, @RequestParam String content, Model model) throws IOException {
        System.out.println(title);
        System.out.println(date);
        System.out.println(content);
        System.out.println("confirmed");
        editArticleService.editArticle(title, date, content);
        return "redirect:/dashboard";
    }
}
