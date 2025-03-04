package com.manish.gaming_backend.Controller;

import com.manish.gaming_backend.Helper.Security;
import com.manish.gaming_backend.Model.Activity.OrderStatus;
import com.manish.gaming_backend.Model.Role.Admin;
import com.manish.gaming_backend.Model.Role.User;
import com.manish.gaming_backend.Request.OrderRequest;
import com.manish.gaming_backend.Request.PaymentRequest;
import com.manish.gaming_backend.Response.CommonObjectResponse;
import com.manish.gaming_backend.Response.CommonResponse;
import com.manish.gaming_backend.Service.AuthService;
import com.manish.gaming_backend.Service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderStatusController {

    @Autowired
    private Security security;

    @Autowired
    private OrderStatusService orderStatusService;

    @Autowired
    private AuthService authService;

    @GetMapping("/getOrderList")
    public ResponseEntity<CommonObjectResponse> findAllOrder(@RequestHeader("Authorization") String token){
        CommonObjectResponse response = new CommonObjectResponse();
        try {
            if (!security.validateToken(token)) {
                throw new Exception("UnAuthorized Access");
            }

            String role = security.extractRole(token);
            if (role.equalsIgnoreCase("ADMIN")) {
                throw new Exception("Invalid Access");
            }

            List<OrderStatus> orderStatusList = orderStatusService.findAllOrder();
            response.setObj(orderStatusList);
            response.setMessage("Order Found  Successfully");
            response.setStatus(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(false);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addOrderList")
    public ResponseEntity<CommonResponse> findAllOrder(@RequestHeader("Authorization") String token , @RequestBody List<OrderRequest> orderRequest){
        CommonResponse response = new CommonResponse();
        try {
            if (!security.validateToken(token)) {
                throw new Exception("UnAuthorized Access");
            }
            String role =security.extractRole(token);
            if(role.equals("ADMIN")){
                throw new Exception("Invalid Access");
            }
            String email =  security.extractEmail(token);
            if(email.isEmpty()){
                throw new Exception("User is not found");
            }
            User user = authService .findUserByEmail(email);
            if(user==null){
                throw new Exception("User not found");
            }

            if(!orderStatusService.saveOrderList(orderRequest,user)){
                throw new Exception("Order uploaded Failed");
            }
            response.setMessage("Order uploaded  Successfully");
            response.setStatus(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(false);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
