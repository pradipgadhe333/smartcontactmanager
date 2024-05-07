package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String registerPage(Model model){

        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        return "register";
    }

    //process register

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session){

        System.out.println("Processing registration...");

        //fetch form data
        //UserForm
        System.out.println(userForm);

        //validate form data
        if (rBindingResult.hasErrors()) {
            return "register";
        }

        //save to database

        //UserForm --> User

        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://img.freepik.com/free-vector/user-circles-set_78370-4704.jpg?size=626&ext=jpg&ga=GA1.1.59568811.1713857647&semt=ais")
        // .build();

        //builder me default values nahi aa rahi thi enum ki to hum normal object banayege

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://img.freepik.com/free-vector/user-circles-set_78370-4704.jpg?size=626&ext=jpg&ga=GA1.1.59568811.1713857647&semt=ais");
        
        User savedUser = userService.saveUser(user);

        System.out.println("User Saved...");

        // add the message 
        //message = "Registration Successfull"
        Message msg = Message.builder().content("Registration Successfull...").type(MessageType.green).build();
        session.setAttribute("message", msg);

        //redirect to login page
        
        return "redirect:/register";
    }

}

