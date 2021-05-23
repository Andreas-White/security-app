package com.peerlender.securityapp.user.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String username) {
        System.out.println("User " + username + " not found");
    }
}
