package com.ipaynow.sdk.util;

import com.ipaynow.sdk.entity.IpaynowException;
import com.ipaynow.sdk.enumeration.ResultStatus;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.util.Map;

public class ResultHandlerUtil {
    private static final Logger logger = LoggerFactory.getLogger(ResultHandlerUtil.class);
    private static final String DEFAULT_CHARSET = "UTF-8";

    public static <T> T handle(String result,String appKey,Class<T> clazz) {
        return handle(result, appKey, DEFAULT_CHARSET,clazz);
    }

    public static <T> T handle(String result,String appKey,String charSet,Class<T> clazz) {
        if (StringUtils.isBlank(charSet)) {
            charSet = DEFAULT_CHARSET;
        }
        if (StringUtils.isBlank(result) || "中小开发者HTTPS服务通讯失败".equals(result)) {
            throw new IpaynowException(ResultStatus.FAIL);
        }
        Map<String,String> dataMap = ConvertUtil.convert(result);
        for (Map.Entry<String,String> entry:dataMap.entrySet()) {
            try {
                dataMap.put(entry.getKey(), URLDecoder.decode(entry.getValue(),charSet));
            } catch (Exception e) {
                logger.warn("decode 失败,entry=" + entry);
                throw new RuntimeException(e);
            }
        }
        String signature = dataMap.remove("signature");
        if (StringUtils.isBlank(signature)) {
            logger.info("signature为空，不验证签名");
            return ConvertUtil.convert(dataMap,clazz);
        }
        dataMap.remove("signType");
        boolean checkSignSuccess = SignUtil.check(dataMap,appKey,signature);
        if (!checkSignSuccess) {
            logger.warn("签名校验失败");
            throw new IpaynowException(ResultStatus.FAIL);
        }
        return ConvertUtil.convert(dataMap,clazz);
    }
}
