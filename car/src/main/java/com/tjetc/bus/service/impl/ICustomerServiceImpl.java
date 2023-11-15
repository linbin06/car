package com.tjetc.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tjetc.bus.doman.Customer;
import com.tjetc.bus.mapper.CustomerMapper;
import com.tjetc.bus.service.ICustomerService;
import com.tjetc.bus.vo.CustomerVo;
import com.tjetc.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICustomerServiceImpl implements ICustomerService {
    private final CustomerMapper customerMapper;

    public ICustomerServiceImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    /**
     * 分⻚查询客户信息
     *
     * @param customerVo
     * @return
     */
    @Override
    public DataGridView queryAllCustomer(CustomerVo customerVo) {
        Page<Object> page = PageHelper.startPage(customerVo.getPage(), customerVo.getLimit());
        List<Customer> data = customerMapper.queryAllCustomer(customerVo);
        return new DataGridView(page.getTotal(), data);
    }

    /**
     * 添加客户信息
     *
     * @param customerVo
     */
    @Override
    public void addCustomer(CustomerVo customerVo) {
        customerMapper.insertSelective(customerVo);
    }

    /**
     * 删除客户信息
     *
     * @param customerVo
     */
    @Override
    public void deleteCustomer(String identity) {
        customerMapper.deleteCustomer(identity);
    }


    /**
     * 修改客户信息
     */
    @Override
    public void updateCustomer(CustomerVo customerVo) {
        customerMapper.updateCustomer(customerVo);
    }

    @Override
    public void deleteBatchCustomer(String[] ids) {
        for (String identity : ids) {
            deleteCustomer(identity);
        }
    }
}