package com.tjetc.bus.service;

import com.tjetc.bus.vo.CustomerVo;
import com.tjetc.sys.utils.DataGridView;

public interface ICustomerService {
    /**
     * 查询所有客户
     *
     * @param customerVo
     * @return
     */
    DataGridView queryAllCustomer(CustomerVo customerVo);

    /**
     * 添加⼀个客户
     *
     * @param customerVo
     */
    void addCustomer(CustomerVo customerVo);

    void deleteCustomer(String identity);
    void updateCustomer(CustomerVo customerVo);
    void deleteBatchCustomer(String[] ids);
}