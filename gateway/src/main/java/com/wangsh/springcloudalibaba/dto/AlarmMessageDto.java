package com.wangsh.springcloudalibaba.dto;

import lombok.Data;

//实体类
@Data
public class  AlarmMessageDto {
    private int scopeId;
    private String scope;//所有可用的Scope
    private String name;//目标Scope的实体名称
    private String id0;//scope实体的ID
    private String id1;//保留字段，暂未使用
    private String ruleName;//告警规则名称
    private String alermMessage;//告警消息内容
    private long startTime; //告警时间
}