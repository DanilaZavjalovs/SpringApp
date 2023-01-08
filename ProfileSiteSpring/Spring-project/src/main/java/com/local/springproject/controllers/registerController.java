package com.local.springproject.controllers;

import com.local.springproject.JPA.UserRepository;
import com.local.springproject.JPA.UserStatisticsRepository;
import com.local.springproject.User.UserClass;
import com.local.springproject.statistics.UserStatistics;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
@AllArgsConstructor
public class registerController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserStatisticsRepository statisticsRepository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping
    public String register(Model model) {
        model.addAttribute("user", new UserClass());

        return "register";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") UserClass user) {

        UserStatistics statistics = new UserStatistics();

        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);

        statistics.setName(user.getName());

        statisticsRepository.save(statistics);

        return "home";
    }

}
