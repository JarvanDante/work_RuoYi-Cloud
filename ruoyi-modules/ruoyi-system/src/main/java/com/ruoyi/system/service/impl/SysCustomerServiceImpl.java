package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysCustomer;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.mapper.SysCustomerMapper;
import com.ruoyi.system.mapper.SysNoticeMapper;
import com.ruoyi.system.service.ISysCustomerService;
import com.ruoyi.system.service.ISysNoticeService;
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


    /**
     * 查询客户列表
     *
     * @param sysCustomer 客户信息
     * @return 客户集合
     */
    @Override
    public List<SysCustomer> selectCustomerList(SysCustomer sysCustomer) {
        return sysCustomerMapper.selectCustomerList(sysCustomer);
    }

}
