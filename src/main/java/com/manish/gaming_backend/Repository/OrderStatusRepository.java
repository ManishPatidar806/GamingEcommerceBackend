package com.manish.gaming_backend.Repository;

import com.manish.gaming_backend.Model.Activity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus , Long> {
    OrderStatus findByName(String name);
}
