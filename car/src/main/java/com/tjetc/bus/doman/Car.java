package com.tjetc.bus.doman;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Car {
    //⻋牌
    private String carNumber;
    //⻋辆类型
    private String carType;
    //⻋辆颜⾊
    private String color;
    //⻋辆价格
    private Double price;
    //租⾦
    private Double rentPrice;
    //押⾦
    private Double deposit;
    //是否出租 0未出租 1 已出租
    private Integer isRenting;
    //描述
    private String description;
    //⻋辆图⽚
    private String carImg;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}