package com.ipaynow.sdk.dto;

public class BaseResponse {
    private String responseCode;
    private String signature;
    private String responseMsg;
    private String responseTime;
    private String signType;
    private String funcode;
    private String appId;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getFuncode() {
        return funcode;
    }

    public void setFuncode(String funcode) {
        this.funcode = funcode;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", signature='" + signature + '\'' +
                ", responseMsg='" + responseMsg + '\'' +
                ", responseTime='" + responseTime + '\'' +
                ", signType='" + signType + '\'' +
                ", funcode='" + funcode + '\'' +
                ", appId='" + appId + '\'' +
                '}';
    }
}
