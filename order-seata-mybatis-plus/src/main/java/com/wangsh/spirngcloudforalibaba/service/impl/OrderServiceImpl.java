package com.wangsh.spirngcloudforalibaba.service.impl;

import com.wangsh.spirngcloudforalibaba.mapper.OrderMapper;
import com.wangsh.spirngcloudforalibaba.model.Order;
import com.wangsh.spirngcloudforalibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    @Override
    public Order insertOrder(Order order) {
        Integer integer = orderMapper.insertOrder(order);
        System.out.println("插入结果："+integer);

            if(1 == 1){
                throw new RuntimeException("异常");
            }
        return null;
    }

    @Override
    public Order selectOrder(Integer id) {

        return orderMapper.selectById(id);
    }
}
