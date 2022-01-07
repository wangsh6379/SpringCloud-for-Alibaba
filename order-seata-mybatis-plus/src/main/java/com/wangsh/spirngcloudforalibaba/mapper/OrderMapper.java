package com.wangsh.spirngcloudforalibaba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangsh.spirngcloudforalibaba.model.Order;

public interface OrderMapper extends BaseMapper<Order> {
    Integer insertOrder(Order order);
}
