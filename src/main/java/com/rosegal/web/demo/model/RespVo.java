package com.rosegal.web.demo.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
public class RespVo<T> {

    private String timestamp;

    private Integer code;

    private String message;

    private T data;

    public RespVo(T data) {
        this(0, null, data);
    }

    public RespVo(Integer code, String message) {
        this(code, message, null);
    }

    public RespVo(Integer code, String message, T data) {
        this.timestamp = LocalDateTime.now(ZoneId.of("Asia/Shanghai")).toString();
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
