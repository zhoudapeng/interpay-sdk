package com.ipaynow.sdk.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PayRequest{
    /**
     * 商户订单号
     */
    @NotNull(message = "商户订单号不能为空")
    @Size(max = 40, message = "商户订单号长度不大于40")
    private String mhtOrderNo;

    /**
     * 商户订单名称
     */
    @NotNull(message = "商户订单名称不能为空")
    @Size(max = 40, message = "商户订单名称最大长度为40个字节")
    private String mhtOrderName;

    /**
     * 商户订单类型
     * 05:独立商户号，消费交易
     */
    @NotNull(message = "商户订单类型不能为空")
    @Pattern(regexp = "01", message = "商户订单类型设置不正确")
    private String mhtOrderType = "01";

    /**
     * 商户货币类型
     */
    @NotNull(message = "币种类型不能为空")
    private String mhtCurrencyType;

    /**
     * 商户交易金额
     */
    @NotNull(message = "商户订单金额不能为空")
    @Pattern(regexp = "[0-9]*", message = "商户订单金额只能是数字")
    private String mhtOrderAmt;

    /**
     * 金额币种单位标记
     */
    @NotNull(message = "商户订单币种类型不能为空")
    @Pattern(regexp = "0|1", message = "商户订单币种类型设置不正确")
    private String mhtAmtCurrFlag;

    /**
     * 商户订单详情
     */
    @NotNull(message = "商户订单详情不能为空")
    @Size(max = 1000, message = "商户订单详情长度不能大于1000")
    private String mhtOrderDetail;

    /**
     * 商户订单超时时间
     */
    @Pattern(regexp = "[0-9]*", message = "订单超时时间设置不正确")
    private String mhtOrderTimeOut;

    /**
     * 商户订单开始时间
     */
    @NotNull(message = "商户订单开始日期不能为空")
    @Size(max = 14, min = 14, message = "商户订单开始时间格式为yyyyMMddHHmmss")
    private String mhtOrderStartTime;

    /**
     * 商户后台通知URL
     */
    private String notifyUrl;

    /**
     * 商户前台通知URL
     */
    private String frontNotifyUrl;

    /**
     * 商户字符集
     */
    @NotNull(message = "商户字符集不能为空")
    private String mhtCharset = "UTF-8";

    /**
     * 设备ID
     */
    @NotNull(message = "设备类型不能为空")
    @Pattern(regexp = "01|02|05|06|0600|0608", message = "设备类型选择不正确")
    private String deviceType;

    /**
     * 支付渠道类型
     */
    @NotNull(message = "支付渠道类型不能为空")
    @Pattern(regexp = "70|80|90", message = "支付渠道类型选择不正确")
    private String payChannelType;

    /**
     * 商户保留域
     */
    private String mhtReserved;

    /**
     * 拓展信息
     */
    private String extendInfo;

    /**
     * 渠道授权码（扫码枪扫到的值）
     */
    private String channelAuthCode;

    /**
     * 微信支付需要关注
     */
    private String detail;
    /**
     * 微信支付需要关注
     */
    private String version;

    public String getMhtOrderNo() {
        return mhtOrderNo;
    }

    public void setMhtOrderNo(String mhtOrderNo) {
        this.mhtOrderNo = mhtOrderNo;
    }

    public String getMhtOrderName() {
        return mhtOrderName;
    }

    public void setMhtOrderName(String mhtOrderName) {
        this.mhtOrderName = mhtOrderName;
    }

    public String getMhtOrderType() {
        return mhtOrderType;
    }

    public void setMhtOrderType(String mhtOrderType) {
        this.mhtOrderType = mhtOrderType;
    }

    public String getMhtCurrencyType() {
        return mhtCurrencyType;
    }

    public void setMhtCurrencyType(String mhtCurrencyType) {
        this.mhtCurrencyType = mhtCurrencyType;
    }

    public String getMhtOrderAmt() {
        return mhtOrderAmt;
    }

    public void setMhtOrderAmt(String mhtOrderAmt) {
        this.mhtOrderAmt = mhtOrderAmt;
    }

    public String getMhtAmtCurrFlag() {
        return mhtAmtCurrFlag;
    }

    public void setMhtAmtCurrFlag(String mhtAmtCurrFlag) {
        this.mhtAmtCurrFlag = mhtAmtCurrFlag;
    }

    public String getMhtOrderDetail() {
        return mhtOrderDetail;
    }

    public void setMhtOrderDetail(String mhtOrderDetail) {
        this.mhtOrderDetail = mhtOrderDetail;
    }

    public String getMhtOrderTimeOut() {
        return mhtOrderTimeOut;
    }

    public void setMhtOrderTimeOut(String mhtOrderTimeOut) {
        this.mhtOrderTimeOut = mhtOrderTimeOut;
    }

    public String getMhtOrderStartTime() {
        return mhtOrderStartTime;
    }

    public void setMhtOrderStartTime(String mhtOrderStartTime) {
        this.mhtOrderStartTime = mhtOrderStartTime;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getFrontNotifyUrl() {
        return frontNotifyUrl;
    }

    public void setFrontNotifyUrl(String frontNotifyUrl) {
        this.frontNotifyUrl = frontNotifyUrl;
    }

    public String getMhtCharset() {
        return mhtCharset;
    }

    public void setMhtCharset(String mhtCharset) {
        this.mhtCharset = mhtCharset;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getPayChannelType() {
        return payChannelType;
    }

    public void setPayChannelType(String payChannelType) {
        this.payChannelType = payChannelType;
    }

    public String getMhtReserved() {
        return mhtReserved;
    }

    public void setMhtReserved(String mhtReserved) {
        this.mhtReserved = mhtReserved;
    }

    public String getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(String extendInfo) {
        this.extendInfo = extendInfo;
    }

    public String getChannelAuthCode() {
        return channelAuthCode;
    }

    public void setChannelAuthCode(String channelAuthCode) {
        this.channelAuthCode = channelAuthCode;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
