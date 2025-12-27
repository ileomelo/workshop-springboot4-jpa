package com.core.webserviceSpring.repositories;

import com.core.webserviceSpring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
