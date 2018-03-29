package com.ipaynow.sdk.enumeration;

public enum ChannelType {
    WECHAT("80","微信"),ALIPAY("90","支付宝");
    private String code;
    private String desc;

    ChannelType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
