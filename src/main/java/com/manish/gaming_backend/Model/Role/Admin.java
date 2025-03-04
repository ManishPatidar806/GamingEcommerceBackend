package com.manish.gaming_backend.Model.Role;


import com.manish.gaming_backend.Model.Product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Admin {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;
        @Column(nullable = false , unique = true)
        private String email;
        @Column(nullable = false , unique = true)
        private String phone;

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





        @Column(nullable = false)
        private String password;

        @OneToMany(mappedBy = "admin" ,cascade = CascadeType.ALL,orphanRemoval = true)
        private List<Product> products;
    }


