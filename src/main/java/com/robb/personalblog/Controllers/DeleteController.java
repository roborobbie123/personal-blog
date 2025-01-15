package com.robb.personalblog.Controllers;

import com.robb.personalblog.Service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {

    @Autowired
    DeleteService deleteService;

    @RequestMapping("/deletepage/{title}")
    public String deletePage(@PathVariable("title") String title, Model model){
        model.addAttribute("title",title);
        return "deletepage";
    }

    @PostMapping("/deletepage/{title}")
        public String deletePost(@PathVariable("title") String title, Model model){
        deleteService.delete(title);
        return "redirect:/dashboard";
        }

}
