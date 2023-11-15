package com.tjetc.bus.doman;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Customer {
    private String identity;
    private String customerName;
    private Integer sex;
    private String address;
    private String phone;
    private String career;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}