package com.wangsh.spirngcloudforalibaba.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangshenghui
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("stock_tb1")
public class Stock implements Serializable{

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer productId;
    private Integer count;
}
