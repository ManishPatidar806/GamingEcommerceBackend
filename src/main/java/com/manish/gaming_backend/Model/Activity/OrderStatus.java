package com.manish.gaming_backend.Model.Activity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manish.gaming_backend.Model.Role.User;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class OrderStatus {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private String name;
    private String image;
    private LocalDate date;
    private long price;

    private String company;

    private double largePrice;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;
    private com.manish.gaming_backend.Utils.OrderStatus status;

    public User getUser() {
        return user;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getLargePrice() {
        return largePrice;
    }

    public void setLargePrice(double largePrice) {
        this.largePrice = largePrice;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public com.manish.gaming_backend.Utils.OrderStatus getStatus() {
        return status;
    }

    public void setStatus(com.manish.gaming_backend.Utils.OrderStatus status) {
        this.status = status;
    }



}
