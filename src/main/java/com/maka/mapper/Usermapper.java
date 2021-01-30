package com.maka.mapper;

import com.maka.pojo.Questions;
import com.maka.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface Usermapper {
    int insertuser(@Param("user_name") String user_name, @Param("user_pwd") String user_pwd);
    //登录
    User login(@Param("userCode") String userCode, @Param("userPwd") String userPwd);
    //注册
    int register(User user);

    Questions queryquestion(@Param("questionId") Integer questionId);
}
