package com.local.springproject.controllers;



import com.local.springproject.JPA.UserRepository;
import com.local.springproject.User.UserClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/authorization")
public class LoginController {
    @Autowired
    UserRepository repository;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("User", new UserClass());


        return "login";
    }

    @PostMapping("/profile")
    public ModelAndView profile(@ModelAttribute("User") UserClass user) {
        ModelAndView view = new ModelAndView("login");

        if(!repository.findByNameAndPassword(user.getName(), user.getPassword()).isEmpty()) {
            Optional<UserClass> userProfile = repository.findById(user.getId());

            if (userProfile.isPresent()) {
                view.setViewName("profile");

                view.addObject("UserProfile", userProfile.get());

                return view;
            }
        }
        return view;
    }
}
