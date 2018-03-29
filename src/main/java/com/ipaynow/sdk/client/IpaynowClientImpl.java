package com.ipaynow.sdk.client;

import com.ipaynow.sdk.dto.*;
import com.ipaynow.sdk.entity.IpaynowConfig;
import com.ipaynow.sdk.enumeration.FuncodeEnum;
import com.ipaynow.sdk.util.RpcUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IpaynowClientImpl implements IpaynowClient{
    private static final Logger logger = LoggerFactory.getLogger(IpaynowClient.class);
    private IpaynowConfig config;

    public IpaynowClientImpl(IpaynowConfig config) {
        logger.info("初始配置信息:" + config.toString());
        this.config = config;
    }

    public PayResponse pay(PayRequest request) throws Exception {
        return RpcUtil.request(config,FuncodeEnum.WP001,request,PayResponse.class);
    }

    public CancelResponse cancel(CancelRequest request) throws Exception {
        return RpcUtil.request(config,FuncodeEnum.CANCEL,request,CancelResponse.class);
    }

    public RefundResponse refund(RefundRequest request) throws Exception {
        return RpcUtil.request(config,FuncodeEnum.REFUND,request,RefundResponse.class);
    }
}
