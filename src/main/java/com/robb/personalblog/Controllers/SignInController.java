package com.robb.personalblog.Controllers;

import com.robb.personalblog.Service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {

    @Autowired
    SignInService signInService = new SignInService();

    @RequestMapping("/signin")
    public String getSignIn() {
        return "signin";
    }

    @PostMapping("/signin")
    public String validateSignIn(@RequestParam String username, @RequestParam String password) {
        if(signInService.signIn(username, password)) {
            return "redirect:/dashboard";
        } else {
            return "redirect:/home";
        }

    }
}
