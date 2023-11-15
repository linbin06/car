package com.tjetc.bus.mapper;

import com.tjetc.bus.doman.Customer;
import com.tjetc.bus.vo.CustomerVo;

import java.util.List;

public interface CustomerMapper {
    List<Customer> queryAllCustomer(CustomerVo customerVo);

    void insertSelective(CustomerVo customerVo);

    void deleteCustomer(String identity);

    void updateCustomer(CustomerVo customerVo);

}
