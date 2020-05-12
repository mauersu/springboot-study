package com.demo.common;

public enum ErrorCodeEnum {

    SUCCESS("2000000", "成功"),
    PARAM_ERROR("4001001", "参数错误"),
    SYSTEM_ERROR("5001001", "后台错误"),
    UNKNOW("5001002", "系统异常"),

    FAILED_INSERT_USER("6001001", "插入用户失败"),
    ;

    String code;
    String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
