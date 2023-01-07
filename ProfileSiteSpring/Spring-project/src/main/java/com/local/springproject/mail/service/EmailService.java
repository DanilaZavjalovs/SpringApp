package com.local.springproject.mail.service;

import com.local.springproject.mail.Message;

public interface EmailService {
    void sendMessage(Message message);
}
