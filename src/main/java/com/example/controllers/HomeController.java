package com.example.test;

import javax.inject.Inject;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Объявить как контроллер
public class HomeController {
    @RequestMapping("/")
    public String showHomePage(@RequestParam("name") String name, @RequestParam("pass") String pass, Model model){
        String msg="Hello "+ name;
        model.addAttribute("message", msg);
        return "hello";
    }

}