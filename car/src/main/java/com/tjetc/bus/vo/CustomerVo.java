package com.tjetc.bus.vo;

import com.tjetc.bus.doman.Customer;
import lombok.Data;

@Data
public class CustomerVo extends Customer {
    /**
     * 分⻚参数
     */
    private Integer page;
    private Integer limit;
    //介绍多个客户id
    private String[] ids;
}