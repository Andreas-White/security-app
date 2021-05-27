package com.peerlender.securityapp.application;

import com.peerlender.securityapp.user.dto.UserDTO;
import com.peerlender.securityapp.user.exception.UserNotFoundException;
import com.peerlender.securityapp.user.model.User;
import com.peerlender.securityapp.user.repository.UserRepository;
import com.peerlender.securityapp.user.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final NotificationService notificationService;

    @Autowired
    public UserController(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    @PostMapping(value = "/validate")
    public String validateTokenAndGetUsername(@RequestHeader("Authorization") String token) {
        return userRepository.findById(token)
                .orElseThrow(() -> new UserNotFoundException(token)).getUsername();
    }

    @PostMapping(value = "/register")
    public void register(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO.getUsername(),userDTO.getPassword());
        userRepository.save(user);
        notificationService.sendMessage(userDTO);
    }

    @GetMapping(value = "/allUsers")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
