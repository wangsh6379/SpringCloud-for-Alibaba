package com.wangsh.spirngcloudforalibaba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangsh.spirngcloudforalibaba.entity.Stock;

public interface StockDao extends BaseMapper<Stock> {

    /**
     * 扣减库存难
     * @param productId
     * @return
     */
    Integer reductStock(Integer productId);
}
