package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysCustomer;

import java.util.List;

/**
 * 客户表 数据层
 * 
 * @author ruoyi
 */
public interface SysCustomerMapper
{

    /**
     * 查询客户列表
     * 
     * @param sysCustomer 客户信息
     * @return 客户集合
     */
    public List<SysCustomer> selectCustomerList(SysCustomer sysCustomer);

    public SysCustomer selectCustomerInfo(Integer customerId);

    public int insertCustomer(SysCustomer sysCustomer);

    public int updateCustomer(SysCustomer sysCustomer);

    public int deleteCustomerByIds(Integer[] customerIds);

}