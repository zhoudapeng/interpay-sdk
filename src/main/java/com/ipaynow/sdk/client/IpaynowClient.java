package com.ipaynow.sdk.client;

import com.ipaynow.sdk.dto.*;

public interface IpaynowClient {

    /**
     * 支付
     * @param request
     * @return
     * @throws Exception
     */
    PayResponse pay(PayRequest request) throws Exception;



    /**
     * 撤销，被扫支付才有意义
     * @param request
     * @return
     * @throws Exception
     */
    CancelResponse cancel(CancelRequest request) throws Exception;

    /**
     * 退款
     * @param request
     * @return
     * @throws Exception
     */
    RefundResponse refund(RefundRequest request) throws Exception;
}
