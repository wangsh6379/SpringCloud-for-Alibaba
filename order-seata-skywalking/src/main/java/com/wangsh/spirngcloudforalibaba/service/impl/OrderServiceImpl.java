package com.wangsh.spirngcloudforalibaba.service.impl;


import com.wangsh.spirngcloudforalibaba.dao.OrderDao;
import com.wangsh.spirngcloudforalibaba.entity.Order;
import com.wangsh.spirngcloudforalibaba.service.OrderService;
import com.wangsh.spirngcloudforalibaba.service.StockFeignService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private StockFeignService stockFeignService;
    @Override
    @Trace
//    @Tag(key = "selectOrder",value = "returnedObj") // key = 方法名，value=返回值
    @Tags({@Tag(key = "param",value = "arg[0]"),
            @Tag(key = "selectOrder",value = "returnedObj")})//key = "param"查看参数，value = "arg[0]"查看请求值，0=第一个参数
    public Order selectOrder(Integer id) {
        return orderDao.selectById(id);
    }

    /**
     * Trace:自定义链路追踪
     * @param order
     * @return
     */
    @Override
    @GlobalTransactional
    public Order insertOrder(Order order) {
//        Integer insert = orderDao.insert(order);

        int i = orderDao.updateById(order);

//
//        Integer insert = orderDao.insertOrder(order);
//        System.out.println("订单插入状态:" + insert);
//        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<String, Object>();
//        multiValueMap.add("productId", order.getProductId());
//        String forObject = restTemplate.postForObject("http://stock-seata-service/stock/reductStock", multiValueMap, String.class);

        String reductStock = stockFeignService.reductStock(order.getProductId());
        System.out.println("扣减库存结果是：" + reductStock);

//        int a = 1 / 0;
        return order;
    }
}
