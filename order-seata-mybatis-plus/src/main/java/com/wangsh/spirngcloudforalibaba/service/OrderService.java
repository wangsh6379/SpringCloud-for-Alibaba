package com.wangsh.spirngcloudforalibaba.service;

import com.wangsh.spirngcloudforalibaba.model.Order;

public interface OrderService {
    Order insertOrder(Order order);

    Order selectOrder(Integer id);
}
