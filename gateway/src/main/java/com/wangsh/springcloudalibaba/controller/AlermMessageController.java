package com.wangsh.springcloudalibaba.controller;

import com.alibaba.fastjson.JSON;
import com.wangsh.springcloudalibaba.dto.AlarmMessageDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用于接收Skywalking的告警数据
 *
 */
@RestController
@RequestMapping("/alerm")
public class AlermMessageController {

    @PostMapping("/message")
    public String message(@RequestBody List<AlarmMessageDto> alarmMessageList){
        System.out.println("告警信息：");
        System.out.println(JSON.toJSONString(alarmMessageList));
        //具体处理告警信息
        return alarmMessageList.toString();
    }
}
