package com.ipaynow.sdk.enumeration;

public enum ResultStatus {
    SUCCESS("A001","交易成功"),
    FAIL("A002","交易失败");
    private String code;
    private String desc;

    ResultStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResultStatus find(String code) {
        for (ResultStatus status:values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
