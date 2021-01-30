package com.maka.service.Impl;

import com.maka.common.R;
import com.maka.mapper.Usermapper;
import com.maka.pojo.Questions;
import com.maka.pojo.User;
import com.maka.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maka.service.Userservice;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

@Service
public class UsererviceImpl implements Userservice {
    @Autowired(required = (false))
    private Usermapper usermapper;
    @Override
    public int insertUser(String userName,String userPwd) {
        return usermapper.insertuser(userName,userPwd);
    }

    @Override
    public R login(String userCode, String userPwd) {
        R r = new R();

        try {
            String mdPwd = MD5.getMD5(userPwd).toString();
            User user = usermapper.login(userCode, mdPwd);
            if (user!=null){
                r.setCode(200);
                r.setMsg("登录成功！");
            }else {
                r.setCode(501);
                r.setMsg("你特么自己的账号密码都不知道了吗！");
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            r.setCode(500);
            r.setMsg("服务器异常！");
        }
        return r;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R register(User user) {
        R r = new R();
        try {
            String mdPwd = MD5.getMD5(user.getUserPwd()).toString();
            user.setUserPwd(mdPwd);
            if(usermapper.register(user)>0){
                r.setCode(200);
                r.setMsg("注册成功！");
            }else {
                r.setCode(501);
                r.setMsg("注册失败！");
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            r.setCode(500);
            r.setMsg("服务器异常！");
        }
        return r;
    }

    @Override
    public Questions queryquestion(Integer questionId) {
        System.out.println(questionId);
        return usermapper.queryquestion(questionId);
    }
}
