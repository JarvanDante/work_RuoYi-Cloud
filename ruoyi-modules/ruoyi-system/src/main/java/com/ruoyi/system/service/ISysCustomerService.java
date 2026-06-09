package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysCustomer;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.domain.vo.SysCustomerVO;

import java.util.List;

/**
 * 客户 服务层
 * 
 * @author ruoyi
 */
public interface ISysCustomerService
{

    /**
     * 查询客户列表
     * 
     * @param sysCustomer 客户信息
     * @return 客户集合
     */
    public List<SysCustomerVO> selectCustomerList(SysCustomer sysCustomer);


    public SysCustomerVO selectCustomerInfo(Integer customerId);

    public int insertCustomer(SysCustomer sysCustomer);

    public int updateCustomer(SysCustomer sysCustomer);

    public int deleteCustomer(Integer[] customerIds);


}
