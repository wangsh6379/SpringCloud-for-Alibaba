package com.wangsh.spirngcloudforalibaba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangsh.spirngcloudforalibaba.entity.Order;

/**
 * @author wangshenghui
 */
public interface OrderDao extends BaseMapper<Order> {

    Integer insertOrder(Order order);
}
