package com.tjetc.bus.vo;

import com.tjetc.bus.doman.Car;
import lombok.Data;

@Data
public class CarVo extends Car {
    /**
     * 分⻚参数
     */
    private Integer page;
    private Integer limit;
    //介绍多个⻋辆id
    private String[] ids;
}