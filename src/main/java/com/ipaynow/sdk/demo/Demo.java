package com.ipaynow.sdk.demo;

import com.ipaynow.sdk.client.IpaynowClient;
import com.ipaynow.sdk.client.IpaynowClientImpl;
import com.ipaynow.sdk.dto.*;
import com.ipaynow.sdk.entity.IpaynowConfig;
import com.ipaynow.sdk.enumeration.Profile;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    private static IpaynowClient client;

    static {
        IpaynowConfig config = new IpaynowConfig();
        config.setAppId("您在现在支付申请的appid");
        config.setAppKey("您在现在支付申请的appkey");
        config.setProfile(Profile.BETA);
        client = new IpaynowClientImpl(config);
    }

    @Test
    public void testAliBarcodePay() throws Exception {
        PayRequest request = new PayRequest();
        request.setMhtOrderNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        request.setMhtOrderAmt("1");
        request.setMhtOrderName("mhtOrderName");
        request.setMhtOrderType("01");
        request.setMhtCurrencyType("NZD");
        request.setMhtAmtCurrFlag("1");
        request.setMhtOrderDetail("detail");
        request.setMhtOrderTimeOut("1000");
        request.setPayChannelType("90");
        request.setDeviceType("05");
        request.setMhtOrderStartTime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        request.setNotifyUrl("");
        request.setFrontNotifyUrl("");
        request.setMhtCharset("UTF-8");
        request.setPayChannelType("90");
        request.setChannelAuthCode("38537835357385788");
        request.setExtendInfo("{\"store_id\":\"store_id\",\"secondary_merchant_industry\":\"7011\",\"secondary_merchant_name\":\"secondary_merchant_name\",\"store_name\":\"store_name\",\"secondary_merchant_id\":\"secondary_merchant_id\"}");
        PayResponse response = client.pay(request);
        System.out.println(response);
    }

    @Test
    public void testWechatBarcodePay() throws Exception {
        PayRequest request = new PayRequest();
        request.setMhtOrderNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        request.setMhtOrderAmt("1");
        request.setMhtOrderName("mhtOrderName");
        request.setMhtOrderType("01");
        request.setMhtCurrencyType("NZD");
        request.setMhtAmtCurrFlag("1");
        request.setMhtOrderDetail("detail");
        request.setMhtOrderTimeOut("1000");
        request.setPayChannelType("90");
        request.setDeviceType("05");
        request.setMhtOrderStartTime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        request.setNotifyUrl("");
        request.setFrontNotifyUrl("");
        request.setMhtCharset("UTF-8");
        request.setPayChannelType("80");
        request.setChannelAuthCode("38537835357385788");
        request.setDetail("{\"goods_detail\":[{\"goods_name\":\"electronic equipment\",\"quantity\":6},{\"goods_name\":\"articles of daily use\",\"quantity\":1},{\"goods_name\":\"snacks\",\"quantity\":1}]}");
        request.setVersion("1.0");
        PayResponse response = client.pay(request);
        System.out.println(response);
    }

    @Test
    public void testCancel() throws Exception {
        String mhtOrderNo = "20171222141526";
        CancelRequest request = new CancelRequest();
        request.setMhtOrderNo(mhtOrderNo);
        BaseResponse response = client.cancel(request);
        System.out.println(response);
    }

    @Test
    public void testRefund() throws Exception {
        String mhtOrderNo = "20171222141526";
        RefundRequest request = new RefundRequest();
        request.setMhtOrderNo(mhtOrderNo);
        BaseResponse response = client.refund(request);
        System.out.println(response);
    }
}