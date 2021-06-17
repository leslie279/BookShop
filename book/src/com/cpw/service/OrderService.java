package com.cpw.service;

import com.cpw.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
