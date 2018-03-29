package com.ipaynow.sdk.enumeration;

public enum Profile {
    BETA("测试环境","http://dby.ipaynow.cn/global"),PRODUCT("生产环境","https://gapi.ipaynow.cn/global");
    private String desc;
    private String url;

    Profile(String desc, String url) {
        this.desc = desc;
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }
}
