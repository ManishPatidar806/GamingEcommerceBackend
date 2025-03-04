package com.manish.gaming_backend.Response;

import com.manish.gaming_backend.Model.Cart.Cart;
import lombok.Data;

import java.util.List;

public class CartDataResponse {
    private List<Cart> list;

    public List<Cart> getList() {
        return list;
    }

    public void setList(List<Cart> list) {
        this.list = list;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private String message;
    private boolean status;


}
