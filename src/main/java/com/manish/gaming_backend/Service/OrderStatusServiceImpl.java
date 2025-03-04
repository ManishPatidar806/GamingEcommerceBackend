package com.manish.gaming_backend.Service;

import com.manish.gaming_backend.Model.Activity.OrderStatus;
import com.manish.gaming_backend.Model.Product.Product;
import com.manish.gaming_backend.Model.Role.User;
import com.manish.gaming_backend.Repository.OrderStatusRepository;
import com.manish.gaming_backend.Repository.ProductRepository;
import com.manish.gaming_backend.Request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

@Autowired
   private OrderStatusRepository orderStatusRepository;

@Autowired
 private ProductRepository productRepository;
    @Override
    public List<OrderStatus> findAllOrder() {
        return orderStatusRepository.findAll();
    }

    @Override
    public boolean saveOrderList(List<OrderRequest> orderRequests , User user)  {
try {
    List<OrderStatus> orderStatusList = new ArrayList<>();
    for (OrderRequest orderRequest : orderRequests) {
        long id = orderRequest.getProductId();
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            return false;
        }
      if(orderStatusRepository.findByName(product.get().getName())!=null){
          return false;
      }
        OrderStatus status = new OrderStatus();
        status.setPrice((long) product.get().getPrice());
        status.setDate(LocalDate.now());
        status.setCompany(product.get().getCompany());
        status.setLargePrice(product.get().getLargePrice());
        status.setName(product.get().getName());
        status.setImage(product.get().getMain_Image());
        status.setStatus(com.manish.gaming_backend.Utils.OrderStatus.DOWNLOAD);
        status.setUser(user);
        orderStatusList.add(status);
    }
   List<OrderStatus> orderRequests1 = orderStatusRepository.saveAll(orderStatusList);
    return true;

}catch (Exception e){
    System.out.println(e.getMessage());
    return false;
}
    }
}
