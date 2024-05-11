package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    // user dashboard page
    @RequestMapping("/dashboard")
    public String userDashboard(){
        System.out.println("User dashboard");
        return "user/dashboard";
    }

    //user profile page
    @RequestMapping("/profile")
    public String userProfile(){
        System.out.println("User profile ");
        return "user/profile";
    }

    //user add contact page

    //user view contacts page

    //user edit contact 

    //user delete contact


}
