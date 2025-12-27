package com.core.webserviceSpring.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;

    private final Set<Product> products = new HashSet<Product>();

    public Category() {}

    public Category(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    // Getters
    public String getCategoryName() {
        return categoryName;
    }

    public Long getId() {
        return id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    // Setters
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Category category)) return false;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
