package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home page handler");

        //sending data to view
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("youtube","learncode");

        return "home";
    }

}
