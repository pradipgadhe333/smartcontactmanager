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

    // about route
    @RequestMapping("/about")
    public String aboutPage(){

        System.out.println("About page loading..");

        return "about";
    }

    // services
    @RequestMapping("/services")
    public String servicesPage(){

        System.out.println("Services page loading...");

        return "services";
    }

    //contact page
    @RequestMapping("/contact")
    public String contactPage() {
        return new String("contact");
    }

    //login page
    @RequestMapping("/login")
    public String loginPage() {
        return new String("login");
    }
    
    //signup/register page
    @RequestMapping("/register")
    public String registerPage(){
        return "register";
    }

    

}

