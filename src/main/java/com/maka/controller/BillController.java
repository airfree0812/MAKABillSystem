package com.maka.controller;

import com.maka.common.R;
import com.maka.common.staticdata;
import com.maka.pojo.AccountData;
import com.maka.pojo.User;
import com.maka.pojo.Useraccount;
import com.maka.service.BillService;
import com.maka.service.Userservice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Api(value = "记账接口", tags = "记账接口API")
@Controller
@RequestMapping(value = "/Bill")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private Userservice userservice;

    @ApiOperation(value = "新增记账接口", notes = "添加记账信息", httpMethod = "get", response = String.class)
    @RequestMapping(value = "/insertBill", method = RequestMethod.GET)
    @ResponseBody
    R insertBill(@ApiParam(name = "Useraccount", value = "新增记账信息", required = true) com.maka.pojo.Useraccount useraccount) {

        R r = new R();
        int i = 0;

        try {
            useraccount.setBillTime(new Date());
            i = billService.insertAccount(useraccount);
            if (i > 0) {
                r.setCode(200);
                r.setMsg("添加记账成功");
                r.setData("1");
            } else {
                r.setCode(501);
                r.setMsg("添加失败");
                r.setData("1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            r.setCode(500);
            r.setMsg("系统开小差，联系管理员");
        }
        return r;
    }

    @ApiOperation(value = "/queryAllBill", notes = "显示记账信息", httpMethod = "post", response = String.class)
    @RequestMapping(value = "/queryAllBill", method = RequestMethod.POST)
    @ResponseBody
    R queryAllBill() {
        List<Map> useraccountList = null;
        R r = new R();

        useraccountList = billService.queryAllaccount(1);
        for (Map useraccount : useraccountList) {
            System.out.println(useraccount.toString());
        }
        try {
            if (useraccountList != null) {
                r.setCode(200);
                r.setMsg("查询成功");
                r.setData(useraccountList);
            } else {
                r.setCode(501);
                r.setMsg("用户未进行记账");
                r.setData(useraccountList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            r.setCode(500);
            r.setMsg("系统开小差，联系管理员");
        }
        return r;
    }
    @ApiOperation(value = "/queryAccount", notes = "月份年度统计", httpMethod = "post", response = String.class)
    @RequestMapping(value = "/queryAccount",method = RequestMethod.POST)
    @ResponseBody
    R queryaccount(){
        R r = new R();
        AccountData accountData;
         accountData= billService.queryaccount();
        try {

            if (accountData!=null) {
                r.setCode(200);
                r.setMsg("查询成功");
                r.setData(accountData);
            } else {
                r.setCode(501);
                r.setMsg("查询失败");
                r.setData("1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            r.setCode(500);
            r.setMsg("系统开小差，联系管理员");
        }
        return r;
    }
}
