package com.wangsh.spirngcloudforalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangshenghui
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    String prot;

    @RequestMapping("/get/{id}")
    public String get(@PathVariable Integer id) {
        System.out.println("查询商品" + id);
        return "查询商品:" + id + ",:" + prot;
    }
}
