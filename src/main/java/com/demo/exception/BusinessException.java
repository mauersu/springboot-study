package com.demo.exception;

import com.demo.common.ErrorCodeEnum;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
        this.code = errorCodeEnum.getCode();
        this.msg = errorCodeEnum.getMsg();
    }
}
