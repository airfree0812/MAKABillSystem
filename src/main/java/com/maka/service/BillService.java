package com.maka.service;

import com.maka.pojo.AccountData;
import com.maka.pojo.User;
import com.maka.pojo.Useraccount;

import java.util.List;
import java.util.Map;

public interface BillService {

    int insertAccount(Useraccount useraccount);
    List<Map> queryAllaccount(long id);

    AccountData queryaccount();
}
