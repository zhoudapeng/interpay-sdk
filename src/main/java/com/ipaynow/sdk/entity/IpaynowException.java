package com.ipaynow.sdk.entity;

import com.ipaynow.sdk.enumeration.ResultStatus;

public class IpaynowException extends RuntimeException {
    private String code;
    private String desc;

    public IpaynowException(ResultStatus status) {
        this.code = status.getCode();
        this.desc = status.getDesc();
    }

    public IpaynowException(ResultStatus status,String desc) {
        this.code = status.getCode();
        this.desc = desc;
    }
}
