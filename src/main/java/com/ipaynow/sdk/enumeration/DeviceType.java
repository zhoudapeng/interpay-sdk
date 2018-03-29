package com.ipaynow.sdk.enumeration;

public enum DeviceType {
    MOBILE("01","手机"),
    PC("02","电脑"),
    PAD("03","平板"),
    TV("04","电视"),
    TVWAP("08","主扫支付"),
    INTELLIJ_POS("05","被扫支付"),
    MOBILE_WAP("06","手机网页"),
    MOBILE_WAP_OFFICE("0600","手机网页公众号"),
    MOBILE_WAP_CARD("0602","收款卡牌"),
    MOBILE_WAP_LIMA("0603","新立马"),
    MOBILE_WAP_H5("0601","手机网页H5"),
    MOBILE_WAP_KJ_CARD("0608","跨境卡牌"),
    MOBILE_WEIXIN_GONGZONGHAO("36","微信公众号"),
    NOWPOS("07","现在收银台"),
    MPOS("09","MPOS"),
    TOTAL("TL","所有设备");
    private String code;
    private String desc;

    DeviceType(String code, String desc) {
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
