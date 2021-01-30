package com.maka.controller;

import com.maka.common.R;
import com.maka.mapper.Usermapper;
import com.maka.pojo.Questions;
import com.maka.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.maka.service.Userservice;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class userController {
    @Autowired
    private Userservice userservice;
    //插入用户
    @RequestMapping(value = "/insertuser",method = RequestMethod.GET)
    public int insert(String username,String userpwd){
        int i = userservice.insertUser(username, userpwd);
        System.out.println(i);

        return i;

    }
    //登录
    @GetMapping("/login")
    @ApiOperation(value = "用户登录接口",notes = "验证用户的用户名和密码",httpMethod = "get", response = String.class)
    @ResponseBody
    public R login(String userCode, String userPwd){
        return userservice.login(userCode, userPwd);
    }
    //注册
    @PostMapping("/register")
    @ResponseBody
    public R register(User user){

        return userservice.register(user);
    }
    //查询常见问题答案
    @RequestMapping(value = "/queryquestion",method = RequestMethod.GET)
    @ResponseBody
    public R login(Integer questionId){

        R r=new R();
        Questions questions=new Questions();
        try {

           questions= userservice.queryquestion(questionId);

            if (questions!=null) {
                r.setCode(200);
                r.setMsg("查询问题答案成功");
                r.setData(questions);
            } else {
                r.setCode(501);
                r.setMsg("没有该问题答案");

            }
        } catch (Exception e) {
            e.printStackTrace();
            r.setCode(500);
            r.setMsg("系统开小差，联系管理员");
        }
        return r;
    }
}
