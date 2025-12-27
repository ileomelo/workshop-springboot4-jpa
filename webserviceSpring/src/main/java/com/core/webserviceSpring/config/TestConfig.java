package com.core.webserviceSpring.config;

import com.core.webserviceSpring.entities.Category;
import com.core.webserviceSpring.entities.Order;
import com.core.webserviceSpring.entities.User;
import com.core.webserviceSpring.entities.enums.OrderStatus;
import com.core.webserviceSpring.repositories.CategoryRepository;
import com.core.webserviceSpring.repositories.OrderRepository;
import com.core.webserviceSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "John", "Doe", "johndoe@example.com", "123qwer");
        User u2 = new User(null, "Marie", "Doe", "mariedoe@example.com", "456asdf");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID ,u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Computers");
        Category cat3 = new Category(null, "Books");

        userRepository.saveAll(Arrays.asList(u1, u2));

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }
}
