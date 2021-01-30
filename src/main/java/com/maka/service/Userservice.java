package com.maka.service;


import com.maka.common.R;
import com.maka.pojo.Questions;
import com.maka.pojo.User;

public interface Userservice {
    int insertUser(String username,String userpwd);
    //登录
    R login(String userCode, String userPwd);

    //注册
    R register(User user);

    Questions queryquestion(Integer questionId);
}
