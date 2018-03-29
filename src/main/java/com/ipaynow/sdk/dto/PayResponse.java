package com.ipaynow.sdk.dto;

public class PayResponse extends BaseResponse {
    private String mhtOrderNo;
    private String nowPayOrderNo;

    public String getMhtOrderNo() {
        return mhtOrderNo;
    }

    public void setMhtOrderNo(String mhtOrderNo) {
        this.mhtOrderNo = mhtOrderNo;
    }

    public String getNowPayOrderNo() {
        return nowPayOrderNo;
    }

    public void setNowPayOrderNo(String nowPayOrderNo) {
        this.nowPayOrderNo = nowPayOrderNo;
    }

    @Override
    public String toString() {
        return "PayResponse{" +
                "mhtOrderNo='" + mhtOrderNo + '\'' +
                ", nowPayOrderNo='" + nowPayOrderNo + '\'' +
                "} " + super.toString();
    }
}
