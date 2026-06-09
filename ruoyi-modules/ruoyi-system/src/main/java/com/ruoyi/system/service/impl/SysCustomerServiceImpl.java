package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysCustomer;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.domain.vo.SysCustomerVO;
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
    public List<SysCustomerVO> selectCustomerList(SysCustomer sysCustomer) {
        List<SysCustomer> list = sysCustomerMapper.selectCustomerList(sysCustomer);
        return list.stream().map(item->{
            SysCustomerVO vo =new SysCustomerVO();
            vo.setId(item.getId());
            vo.setName(item.getName());
            vo.setPhone(item.getPhone());
            vo.setStatus(item.getStatus());
            return vo;
        }).toList();
    }

    @Override
    public SysCustomerVO selectCustomerInfo(Integer customerId) {
        SysCustomer sysCustomer = sysCustomerMapper.selectCustomerInfo(customerId);
        SysCustomerVO sysCustomerVO = new SysCustomerVO();

        if (sysCustomer == null) {
            return null;
        }
        sysCustomerVO.setId(sysCustomer.getId());
        sysCustomerVO.setName(sysCustomer.getName());
        sysCustomerVO.setPhone(sysCustomer.getPhone());
        sysCustomerVO.setStatus(sysCustomer.getStatus());
        sysCustomerVO.setCreateTime(sysCustomer.getCreateTime());


        return sysCustomerVO;
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
