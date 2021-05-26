package com.peerlender.securityapp;

import com.peerlender.securityapp.user.model.User;
import com.peerlender.securityapp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User(1, "John","user1"));
        userRepository.save(new User(2, "Anna","user2"));
        userRepository.save(new User(3, "Larry","user3"));
        userRepository.save(new User(4, "Linda","user4"));
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

}
