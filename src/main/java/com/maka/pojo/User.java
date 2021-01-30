package com.maka.pojo;


import lombok.Data;

import java.util.List;
@Data
public class User {

  private long id;
  private String userCode;
  private String userPwd;
  private String userName;
  private Useraccount useraccount;
//  private accountlist accountlist;


}
