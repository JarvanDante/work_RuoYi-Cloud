package com.ruoyi.system.domain;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.ruoyi.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class SysCustomer extends BaseEntity {

    /* id */
    private Integer id;

    /* 名称 */
    private String name;

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

    public Char getStatus() {
        return status;
    }

    public void setStatus(Char status) {
        this.status = status;
    }

    /* 手机 */
    private String phone;

    /* 状态 */
    private Char status;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("phone", getPhone())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .toString();
    }

}
