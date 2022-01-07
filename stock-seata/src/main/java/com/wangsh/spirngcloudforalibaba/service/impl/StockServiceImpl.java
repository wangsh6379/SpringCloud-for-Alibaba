package com.wangsh.spirngcloudforalibaba.service.impl;

import com.wangsh.spirngcloudforalibaba.dao.StockDao;
import com.wangsh.spirngcloudforalibaba.entity.Stock;
import com.wangsh.spirngcloudforalibaba.service.StockService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangshenghui
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;

    @Override
    public Stock insetStock(Stock stock) {
        Integer insert = stockDao.insert(stock);
        System.out.println("插入数据结果：" + insert);
        return stock;
    }

    @Override
    public Stock selectStock(Integer id) {
        return stockDao.selectById(id);
    }

    @Override
    public Integer reductStock(Integer productId) {
        Integer integer = stockDao.reductStock(productId);
        System.out.println("更新结果：" + integer);
        return integer;
    }
}
