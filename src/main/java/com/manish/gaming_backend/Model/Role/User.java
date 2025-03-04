package com.manish.gaming_backend.Model.Role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manish.gaming_backend.Model.Activity.OrderStatus;
import com.manish.gaming_backend.Model.Cart.Cart;
import com.manish.gaming_backend.Model.Review.Review;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String name;
    @Column(nullable = false , unique = true)
    private String email;
    @Column(nullable = false , unique = true)
    private String phone;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<OrderStatus> Order;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<Cart> cart;


    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<Review> review;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
