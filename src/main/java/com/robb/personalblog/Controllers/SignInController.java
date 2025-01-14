package com.robb.personalblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {

    @RequestMapping("/signin")
    public String getSignIn() {
        return "signin";
    }
}
