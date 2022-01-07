package com.wangsh.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 只要在nacos中修改数据，也会实时去动态更新配置
 */
@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${user.name}")
    String userName;

    @Value("${user.age}")
    int age;

    @RequestMapping("/getConfig")
    public String getConfig(){
        return "userName:"+userName+",agg:"+age;
    }
}
