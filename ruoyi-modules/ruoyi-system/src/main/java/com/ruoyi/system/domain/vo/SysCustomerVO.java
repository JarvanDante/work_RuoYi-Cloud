package com.ruoyi.system.domain.vo;

import com.ruoyi.common.core.annotation.Excel;

import java.util.Date;

public class SysCustomerVO {
    @Excel(name = "客户ID")
    private Integer id;
    @Excel(name = "客户名称")
    private String name;
    @Excel(name = "手机号")
    private String phone;
    @Excel(name = "状态", readConverterExp = "0=禁用,1=启用")
    private String status;
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
