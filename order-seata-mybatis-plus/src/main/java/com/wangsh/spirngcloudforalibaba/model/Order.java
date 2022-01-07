package com.wangsh.spirngcloudforalibaba.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@TableName("order_tb1")
@AllArgsConstructor
@Data
@Builder
public class Order implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer productId;
    private Double totolAmount;
    //该数据在插入与更新是插入
//    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer status;
}
