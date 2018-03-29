package com.ipaynow.sdk.util;

import com.google.common.collect.Maps;
import com.ipaynow.sdk.entity.IpaynowConfig;
import com.ipaynow.sdk.enumeration.FuncodeEnum;
import com.ipaynow.sdk.enumeration.SignIngorePolicy;
import com.ipaynow.sdk.enumeration.SignType;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.TreeMap;

public class RpcUtil {
    public static <Request,Response> Response request(IpaynowConfig config,FuncodeEnum funcodeEnum, Request request, Class<Response> clazz) throws Exception{
        String errorMsg = ValidateUtil.validateOneByOne(request);
        if (StringUtils.isNotBlank(errorMsg)) {
            throw new IllegalArgumentException(errorMsg);
        }
        SignIngorePolicy policy = SignIngorePolicy.find(funcodeEnum);
        if (policy == null) {
            throw new RuntimeException("funcodeEnum不合法,value=" + funcodeEnum);
        }
        String[] ignoreParams = policy.getIgnoreParams();
        Map<String,String> paramMap = BeanUtils.describe(request);
        paramMap.remove("class");
        Map<String,String> signIgnoreParamMap = Maps.newHashMap();
        for (String ignoreParam:ignoreParams) {
            String value = paramMap.remove(ignoreParam);
            if (StringUtils.isNotBlank(value)) {
                signIgnoreParamMap.put(ignoreParam,value);
            }
        }
        paramMap.put("appId", config.getAppId());
        System.out.println("original map:" + new TreeMap<String,String>(paramMap));
        String sign = SignUtil.sign(paramMap, config.getAppKey());
        paramMap.put("mhtSignType", SignType.MD5);
        paramMap.put("mhtSignature", sign);
        paramMap.putAll(signIgnoreParamMap);
        paramMap.put("funcode",funcodeEnum.getName());
        System.out.println("final param map:" + new TreeMap<String,String>(paramMap));
        String result = HttpUtil.sendPost(config.getProfile().getUrl(), paramMap);
        return ResultHandlerUtil.handle(result, config.getAppKey(), clazz);
    }

    public static void main(String[] args) {
        String str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDI231MfJfzfDM5w+4eHQU+xydJ" +
                "WMfvLA4Djpo0s8R4M5xHhTuWrSoQ7HYnQiOzLqWWOBSZd4jGXBSKd7csZprYz74F" +
                "hsba2jpZdXFYaYc5YZ9bFdpblnVCGtB0zMGUxCHxINaJip8C2wfs7VTaEuiVSetL" +
                "KOXEI4gTr6i0KW7rpwIDAQAB";
        System.out.println(str);
    }
}
