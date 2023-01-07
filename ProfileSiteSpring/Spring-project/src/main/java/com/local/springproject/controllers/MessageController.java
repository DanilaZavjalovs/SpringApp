package com.local.springproject.controllers;

import com.local.springproject.mail.Message;
import com.local.springproject.mail.service.EmailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sendMessage")
public class MessageController {

    @Autowired
    EmailServiceImpl emailSender;

    @GetMapping
    public String messageView(Model model) {
        model.addAttribute("message", new Message());

        return "message";
    }

    @PostMapping
    public String sendMessage(@ModelAttribute("message") Message message) {

        emailSender.sendMessage(message);

        return "home";
    }

}
