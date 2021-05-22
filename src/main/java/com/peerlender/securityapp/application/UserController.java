package com.peerlender.securityapp.application;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/validate")
    public String validateTokenAndGetUsername(@RequestHeader("Authorization") String token) {
        return "";
    }
}
