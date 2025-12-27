package com.core.webserviceSpring.resources;

import com.core.webserviceSpring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Leonardo", "Melo", "leo@example.com", "234657823465bhbh");
        return ResponseEntity.ok().body(user);
    }
}
