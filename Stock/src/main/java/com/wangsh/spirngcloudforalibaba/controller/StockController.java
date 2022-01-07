package com.wangsh.spirngcloudforalibaba.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangshenghui
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @RequestMapping("/reduct")
    public String reduct(){
        System.out.println("扣减库存成功");
        return "success";
    }
}
