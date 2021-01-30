package com.maka.mapper;

import com.maka.pojo.User;
import com.maka.pojo.Useraccount;

import java.util.List;
import java.util.Map;

public interface Billmapper {

    int insertAccount(com.maka.pojo.Useraccount useraccount);

    List<Map> queryAllaccount(long id);
}
