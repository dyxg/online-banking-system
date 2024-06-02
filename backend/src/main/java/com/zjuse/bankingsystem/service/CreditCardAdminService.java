package com.zjuse.bankingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjuse.bankingsystem.entity.creditCard.CreditCardAdmin;
import com.zjuse.bankingsystem.entity.creditCard.CreditCardInspector;
import com.zjuse.bankingsystem.mapper.CreditCardAdminMapper;
import com.zjuse.bankingsystem.utils.ApiResult;

@Service
public class CreditCardAdminService {
    @Autowired
    private CreditCardAdminMapper adminMapper;  

    public ApiResult loginAdmin(String name, String password) {
        CreditCardAdmin creditCardAdmin = adminMapper.loginAdmin(name, password);
        if (creditCardAdmin == null) {
            return new ApiResult(false, "登录失败");
        } else {
            return new ApiResult(true, "登录成功");
        }
    }

    public ApiResult queryInspectors() {
        List<CreditCardInspector> creditCardInspectors = adminMapper.queryInspectors();
        return new ApiResult(true, creditCardInspectors);
    }

    public ApiResult modifyInspectorPassword(Integer id, String password) {
        adminMapper.modifyInspectorPassword(id, password);
        return new ApiResult(true, "修改成功");
    }

    public ApiResult modifyInspectorLevel(Integer id, Integer permission) {
        adminMapper.modifyInspectorLevel(id, permission);
        return new ApiResult(true, "修改成功");
    }

    public ApiResult deleteInspector(Integer id) {
        adminMapper.deleteInspector(id);
        return new ApiResult(true, "删除成功");
    }

    public ApiResult addNewInspector(String name, String password, Integer permission) {
        adminMapper.addNewInspector(name, password, permission);
        return new ApiResult(true, "添加成功");
    }
}