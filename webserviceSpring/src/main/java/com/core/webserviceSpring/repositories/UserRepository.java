package com.core.webserviceSpring.repositories;


import com.core.webserviceSpring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
