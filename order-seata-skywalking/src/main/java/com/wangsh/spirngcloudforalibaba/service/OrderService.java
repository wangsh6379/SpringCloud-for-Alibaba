package com.wangsh.spirngcloudforalibaba.service;

import com.wangsh.spirngcloudforalibaba.entity.Order;

public interface OrderService {

    Order selectOrder(Integer id);

    Order insertOrder(Order order);
}
