package com.maka.common;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Description: 返回数据实体
 * Version: V1.0
 */
public class R<T> {
    private int code;  //返回状态码
    private String msg; //返回消息
    private T data; //返回数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
