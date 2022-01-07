package com.wangsh.spirngcloudforalibaba.service;

import com.wangsh.spirngcloudforalibaba.entity.Stock;

public interface StockService {

    Stock insetStock(Stock stock);

    Stock selectStock(Integer id);

    /**
     * 扣减库存
     * @param productId
     * @return
     */
    Integer reductStock(Integer productId);
}
