package com.example.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogInController {
    /*@GetMapping("/register")
    public String display() {
        return "register";
    }*/
    @GetMapping("/register")
    public String getData(HttpServletRequest req, Model model) {
        String name=req.getParameter("name");
        String pass=req.getParameter("pass");
        System.out.println(name + " " + pass);
        return("register");
    }

}
