package com.wangsh.spirngcloudforalibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;


    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result error(Integer code, String msg) {
        return new Result(code, msg);
    }
}
