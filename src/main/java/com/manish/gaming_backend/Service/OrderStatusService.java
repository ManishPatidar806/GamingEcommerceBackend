package com.manish.gaming_backend.Service;

import com.manish.gaming_backend.Model.Activity.OrderStatus;
import com.manish.gaming_backend.Model.Role.User;
import com.manish.gaming_backend.Request.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderStatusService {

public List<OrderStatus> findAllOrder();

public boolean saveOrderList(List<OrderRequest> orderRequests, User user);

}
