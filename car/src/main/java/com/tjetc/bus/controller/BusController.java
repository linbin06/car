package com.tjetc.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bus")
public class BusController {
    /**
     * 跳转到客户管理⻚⾯
     */
    @RequestMapping("toCustomerManager")
    public String toCustomerManager() {
        return "business/customer/customerManager";
    }

    /**
     * 跳转到⻋辆管理⻚⾯
     */
    @RequestMapping("toCarManager")
    public String toCarManager() {
        return "business/car/carManager";
    }
}