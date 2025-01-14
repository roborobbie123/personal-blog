package com.robb.personalblog.Service;

import org.springframework.stereotype.Service;

@Service
public class SignInService {
    public boolean signIn(String username, String password) {
        if (username.equals("admin") && password.equals("123")) {
            return true;
        } else {return false;}
    }
}
