package com.ipaynow.sdk.enumeration;

public enum  FuncodeEnum {
    WP001("WP001","统一下单接口"),
    CANCEL("CANCEL","撤销订单（适用于被扫支付返回状态为未知的支付单）"),
    REFUND("R001","退款");
    private String name;
    private String desc;

    FuncodeEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
