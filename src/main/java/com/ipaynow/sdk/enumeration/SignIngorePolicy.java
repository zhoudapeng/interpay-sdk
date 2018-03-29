package com.ipaynow.sdk.enumeration;

public enum SignIngorePolicy {
    ORDER(FuncodeEnum.WP001,new String[]{"funcode","appId","appKey","deviceType","mhtSignType","mhtSignature","detail","version"}),
    CANCEL(FuncodeEnum.CANCEL,new String[]{"funcode","appId","appKey","mhtSignType","mhtSignature"}),
    REFUND(FuncodeEnum.REFUND,new String[]{"funcode","appId","appKey","mhtSignType","mhtSignature"});

    private FuncodeEnum funcodeEnum;
    private String[] ignoreParams;

    SignIngorePolicy(FuncodeEnum funcodeEnum, String[] ignoreParams) {
        this.funcodeEnum = funcodeEnum;
        this.ignoreParams = ignoreParams;
    }

    public static SignIngorePolicy find(FuncodeEnum funcodeEnum) {
        for (SignIngorePolicy policy:values()) {
            if (policy.funcodeEnum == funcodeEnum) {
                return policy;
            }
        }
        return null;
    }

    public FuncodeEnum getFuncodeEnum() {
        return funcodeEnum;
    }

    public String[] getIgnoreParams() {
        return ignoreParams;
    }
}
