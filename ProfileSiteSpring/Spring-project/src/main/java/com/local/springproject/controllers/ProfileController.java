package com.local.springproject.controllers;

import com.local.springproject.JPA.UserRepository;
import com.local.springproject.User.UserClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/account")
public class ProfileController {

    @Autowired
    UserRepository repository;

    @GetMapping("/profile/{id}")
    public ModelAndView profile(@PathVariable("id") Integer id) {

        ModelAndView view = new ModelAndView("home");

        Optional<UserClass> user = repository.findById(id);

        if (user.isPresent()) {
            view.addObject("UserProfile", user.get());
            view.setViewName("profile");

            return view;
        }

        return view;
    }
}
