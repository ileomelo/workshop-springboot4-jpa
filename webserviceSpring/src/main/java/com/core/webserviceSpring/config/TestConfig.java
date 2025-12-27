package com.core.webserviceSpring.config;

import com.core.webserviceSpring.entities.User;
import com.core.webserviceSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "John", "Doe", "johndoe@example.com", "123qwer");
        User u2 = new User(null, "Marie", "Doe", "mariedoe@example.com", "456asdf");


        userRepository.save(u1);
        userRepository.save(u2);
    }
}
