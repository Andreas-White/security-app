package com.peerlender.securityapp.user.service;

import com.google.gson.Gson;
import com.peerlender.securityapp.user.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final RabbitTemplate rabbitTemplate;
    private final static Gson GSON = new Gson();

    @Autowired
    public NotificationService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(User user) {
        // So I pass to the other microservices only username and password, without id
        User newUser = new User(user.getUsername(), user.getPassword());
        rabbitTemplate.convertAndSend("userRegisteredTopic","user.registered",GSON.toJson(newUser));
    }
}
