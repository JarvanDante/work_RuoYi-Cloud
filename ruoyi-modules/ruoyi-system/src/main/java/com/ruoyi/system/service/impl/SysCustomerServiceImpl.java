package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysCustomer;
import com.ruoyi.system.domain.vo.SysCustomerVO;
import com.ruoyi.system.mapper.SysCustomerMapper;
import com.ruoyi.system.service.ISysCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户 服务层实现
 * 
 * @author ruoyi
 */
@Service
public class SysCustomerServiceImpl implements ISysCustomerService
{
    @Autowired
    private SysCustomerMapper sysCustomerMapper;


    @Override
    public List<SysCustomerVO> selectCustomerList(SysCustomer sysCustomer) {
        return sysCustomerMapper.selectCustomerList(sysCustomer).stream()
                .map(this::toVO)
                .toList();
    }

    @Override
    public SysCustomerVO selectCustomerInfo(Integer customerId) {
        SysCustomer sysCustomer = sysCustomerMapper.selectCustomerInfo(customerId);
        return sysCustomer == null ? null : toVO(sysCustomer);
    }

    private SysCustomerVO toVO(SysCustomer customer) {
        SysCustomerVO vo = new SysCustomerVO();
        vo.setId(customer.getId());
        vo.setName(customer.getName());
        vo.setPhone(customer.getPhone());
        vo.setStatus(customer.getStatus());
        vo.setCreateTime(customer.getCreateTime());
        return vo;
    }

    @Override
    public int insertCustomer(SysCustomer sysCustomer){
        return sysCustomerMapper.insertCustomer(sysCustomer);
    }

    @Override
    public int updateCustomer(SysCustomer sysCustomer){
        return sysCustomerMapper.updateCustomer(sysCustomer);
    }

    @Override
    public int deleteCustomer(Integer[] customerIds){
        return sysCustomerMapper.deleteCustomerByIds(customerIds);
    }
}
