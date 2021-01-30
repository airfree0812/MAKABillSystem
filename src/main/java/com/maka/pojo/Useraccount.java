package com.maka.pojo;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel(value = "记账实体类")
public class Useraccount {
  @ApiModelProperty(value = "id",notes = "主键",dataType = "long",required = false)
  private long id;
  @ApiModelProperty(value = "userId",notes = "用户ID",dataType = "long",required = false)
  private long userId;
  @ApiModelProperty(value = "paymentId",notes = "支付类型",dataType = "long",required = true)
  private long paymentId;
  @ApiModelProperty(value = "money",notes = "金额",dataType = "double",required = true)
  private double money;
  @ApiModelProperty(value ="billTypeId",required = true,notes = "账单类型，收入为1，支出为2",dataType = "long")
  private long billTypeId;
  @ApiModelProperty(value = "incomeType",notes = "收支类型",dataType = "long",required = true)
  private long incomeType;
  @ApiModelProperty(value = "billTime",notes = "记账时间",dataType = "Date",required = true)
  private Date billTime;
  @ApiModelProperty(value = "common",notes = "备注",dataType = "String",required = false)
  private String common;
  private Payment payment;
  private Billtype billtype;
  private Gainandpaytype gainandpaytype;

}
