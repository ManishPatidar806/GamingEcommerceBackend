package com.manish.gaming_backend.Model.Review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manish.gaming_backend.Model.Product.Product;
import com.manish.gaming_backend.Model.Role.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Review {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private int star;
private String name;
private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(length = 800)
    private String comment;

    @JsonIgnore
@ManyToOne
@JoinColumn(name = "user_id" , nullable = false)
private User user;

    @JsonIgnore
@ManyToOne
@JoinColumn(name = "product_id" , nullable = false)
private Product product;

}
