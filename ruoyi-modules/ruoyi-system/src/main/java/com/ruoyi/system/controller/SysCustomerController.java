package com.ruoyi.system.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.system.domain.SysCustomer;
import com.ruoyi.system.domain.vo.SysCustomerVO;
import com.ruoyi.system.service.ISysCustomerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 客户 信息操作处理
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/customer")
public class SysCustomerController extends BaseController
{
    @Autowired
    private ISysCustomerService customerService;

    /**
     * 获取客户列表
     */
    @RequiresPermissions("system:customer:list")
    @GetMapping("/list")
    public TableDataInfo list(SysCustomer sysCustomer)
    {
        startPage();
        List<SysCustomerVO> list = customerService.selectCustomerList(sysCustomer);
        return getDataTable(list);
    }

    /**
     * 导出客户列表
     */
    @RequiresPermissions("system:customer:export")
    @Log(title = "客户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysCustomer sysCustomer)
    {
        List<SysCustomerVO> list = customerService.selectCustomerList(sysCustomer);
        ExcelUtil<SysCustomerVO> util = new ExcelUtil<>(SysCustomerVO.class);
        util.exportExcel(response, list, "客户数据");
    }

    /**
     * 获取客户详细信息
     * @param customerId
     * @return
     */
    @RequiresPermissions("system:customer:query")
    @GetMapping("/{customerId}")
    public AjaxResult getInfo(@PathVariable Integer customerId)
    {
        return success(customerService.selectCustomerInfo(customerId));
    }


    @RequiresPermissions("system:customer:add")
    @Log(title = "客户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysCustomer customer)
    {
        return toAjax(customerService.insertCustomer(customer));
    }

    @RequiresPermissions("system:customer:edit")
    @Log(title = "客户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysCustomer customer)
    {
        if(customer.getId()==null){
            return error("客户ID不能为空");
        }
        return toAjax(customerService.updateCustomer(customer));
    }

    @RequiresPermissions("system:customer:remove")
    @Log(title = "客户", businessType = BusinessType.DELETE)
    @DeleteMapping("/{customerIds}")
    public AjaxResult delete(@PathVariable Integer[] customerIds)
    {
        return toAjax(customerService.deleteCustomer(customerIds));
    }
    
}
