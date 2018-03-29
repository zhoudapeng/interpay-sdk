package com.ipaynow.sdk.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class SignUtil {
    private static final Logger logger = LoggerFactory.getLogger(SignUtil.class);
    public static String sign(Map<String, String> signMap, String appSecret) throws Exception {
        Set<String> keySet = signMap.keySet();
        List<String> keyList = new ArrayList<String>(keySet);
        Collections.sort(keyList);
        StringBuilder toMD5StringBuilder = new StringBuilder();
        for (String key : keyList) {
            String value = signMap.get(key);
            if (StringUtils.isNotBlank(value)) {
                toMD5StringBuilder.append(key + "=" + value + "&");
            }
        }
        String securityKeyMD5 = MD5Util.md5(appSecret, "");
        toMD5StringBuilder.append(securityKeyMD5);
        String toMD5String = toMD5StringBuilder.toString();
        String md5Value = MD5Util.md5(toMD5String, "");
        return md5Value;
    }

    public static boolean check(Map<String,String> dataMap,String appKey,String sign) {
        try {
            String mySign = sign(dataMap,appKey);
            return StringUtils.equals(mySign,sign);
        }catch (Exception e) {
            logger.warn("验证sign异常",e);
            return false;
        }
    }

    public static void main(String[] args) {
        String result = "mhtCharset=UTF-8&responseCode=A001&appId=1512462141589110&mhtOrderNo=20171226174831&signType=MD5&nowPayOrderNo=c20130101712261748520512005&responseMsg=%E4%BA%A4%E6%98%93%E6%88%90%E5%8A%9F&funcode=WP001&signature=abd05c2d4390d0c47160b56a5f0043d1&responseTime=20171226174859";
        Map<String,String> map = ConvertUtil.convert(result);
        map.remove("signature");
        map.remove("signType");
        System.out.println(map);
    }
}
