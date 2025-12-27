package com.core.webserviceSpring.config;

import com.core.webserviceSpring.entities.Order;
import com.core.webserviceSpring.entities.User;
import com.core.webserviceSpring.repositories.OrderRepository;
import com.core.webserviceSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "John", "Doe", "johndoe@example.com", "123qwer");
        User u2 = new User(null, "Marie", "Doe", "mariedoe@example.com", "456asdf");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);


        userRepository.save(u1);
        userRepository.save(u2);
        orderRepository.save(o1);
        orderRepository.save(o2);
        orderRepository.save(o3);
    }
}
