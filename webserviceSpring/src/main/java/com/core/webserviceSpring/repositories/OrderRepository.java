package com.core.webserviceSpring.repositories;

import com.core.webserviceSpring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
