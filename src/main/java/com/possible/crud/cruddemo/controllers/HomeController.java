package com.possible.crud.cruddemo.controllers;

import com.possible.crud.cruddemo.entities.User;
import com.possible.crud.cruddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    private UserService userService;

    @Autowired
    public void userService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping(path = "/addUser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signup";
        }
        model.addAttribute("user", userService.saveUser(user));
        return "redirect:/login";
    }

/*    @PostMapping("/login")
    public String welcome(){
        return "redirect:/taskList";
    }*/
}
