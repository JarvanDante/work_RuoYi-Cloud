package com.ruoyi.system.domain;

import com.ruoyi.common.core.web.domain.BaseEntity;
import com.ruoyi.common.core.xss.Xss;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SysCustomer extends BaseEntity {

    /* id */
    private Integer id;

    /* 名称 */
    @Xss(message = "名称不能包含脚本字符")
    @NotBlank(message = "名称不能为空")
    @Size(min = 0, max = 50, message = "名称不能超过50个字符")
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /* 手机 */
    @Xss(message = "手机不能包含脚本字符")
    @NotBlank(message = "手机不能为空")
    @Size(min = 0, max = 11, message = "手机不能超过11个字符")
    private String phone;

    /* 状态 */
    private String status = "1";

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
