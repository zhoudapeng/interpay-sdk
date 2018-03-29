package com.ipaynow.sdk.dto;

import javax.validation.constraints.NotNull;

public class RefundRequest {
    @NotNull(message = "mhtOrderNo不能为空")
    private String mhtOrderNo;

    public String getMhtOrderNo() {
        return mhtOrderNo;
    }

    public void setMhtOrderNo(String mhtOrderNo) {
        this.mhtOrderNo = mhtOrderNo;
    }
}
