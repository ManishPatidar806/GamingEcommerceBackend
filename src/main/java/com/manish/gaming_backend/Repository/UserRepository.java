package com.manish.gaming_backend.Repository;

import com.manish.gaming_backend.Model.Role.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {

  User findByEmail(String email);
  User findByPhone(String phoneNumber);

}
