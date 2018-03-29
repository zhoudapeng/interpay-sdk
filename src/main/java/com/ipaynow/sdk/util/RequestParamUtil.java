package com.ipaynow.sdk.util;

import com.ipaynow.sdk.entity.IpaynowConfig;
import com.ipaynow.sdk.enumeration.FuncodeEnum;
import com.ipaynow.sdk.enumeration.SignType;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RequestParamUtil {
    private static final Logger logger = LoggerFactory.getLogger(RequestParamUtil.class);
    public static Map<String,String> buildPayParams(IpaynowConfig config,Object obj) throws Exception {
        Map<String, String> paramMap = BeanUtils.describe(obj);
        paramMap.put("appId", config.getAppId());
        // 不参与签名的参数： deviceType,funcode,mhtSignType,appKey,mhtSignature,detail,version
        String deviceType = paramMap.remove("deviceType");
        paramMap.remove("funcode");
        paramMap.remove("appKey");
        paramMap.remove("mhtSignType");
        paramMap.remove("mhtSignature");
        String detail = paramMap.remove("detail");
        String version = paramMap.remove("version");
        logger.debug("签名前参数为：" + paramMap);
        String sign = SignUtil.sign(paramMap, config.getAppKey());
        paramMap.put("deviceType", deviceType);
        paramMap.put("funcode", FuncodeEnum.WP001.getName());
        paramMap.put("appKey", "Y");
        paramMap.put("mhtSignType", SignType.MD5);
        paramMap.put("mhtSignature", sign);
        paramMap.put("detail",detail);
        paramMap.put("version",version);
        logger.debug("签名后参数为：" + paramMap);
        return paramMap;
    }
}
