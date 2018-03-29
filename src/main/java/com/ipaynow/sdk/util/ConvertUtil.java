package com.ipaynow.sdk.util;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConvertUtil {
    private static final Logger logger = LoggerFactory.getLogger(ConvertUtil.class);

    public static Map<String,String> convert(String value) {
        logger.info("convert to map,input=" + value);
        Map<String,String> dataMap = Maps.newHashMap();
        String[] kvs = value.split("&");
        for (String kv:kvs) {
            String[] entrys = kv.split("=");
            if (entrys.length != 2) {
                logger.warn("返回值不规范-----" + kv);
                continue;
            }
            dataMap.put(entrys[0],entrys[1]);
        }
        logger.info("convert success,output=" + dataMap);
        return dataMap;
    }

    /**
     * 解析返回参数
     * @param dataMap 类似key1=value1&key2=value2这样的返回值
     * @param clazz 需要转换成的类
     * @param <T>
     * @return
     */
    public static <T> T convert(Map<String,String> dataMap,Class<T> clazz) {
        logger.info("解析返回值,input=" + dataMap + "，clazz=" + clazz);
        if (dataMap == null || dataMap.isEmpty()) {
            return null;
        }
        try {
            T t = clazz.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                try {
                    String fieldName = propertyDescriptor.getName();
                    if (SpecialFieldContainer.contains(fieldName)) {
                        continue;
                    }
                    Method setMethod = propertyDescriptor.getWriteMethod();
                    setMethod.invoke(t, dataMap.get(fieldName));
                } catch (Throwable throwable) {
                    logger.warn("解析错误",throwable);
                    //ignore
                }
            }
            logger.info("convert to " + clazz + ",result=" + t);
            return t;
        } catch (Exception e) {
            logger.error("解析返回值异常", e);
            throw new RuntimeException(e);
        }
    }

    static class SpecialFieldContainer {
        public final static String NAME_CLASS = "class";

        public final static String NAME_SERIALVERSIONUID = "serialVersionUID";

        private static Set<String> container = new HashSet<String>();
        static {
            container.add(NAME_CLASS);
            container.add(NAME_SERIALVERSIONUID);
        }

        public static boolean contains(String fieldName){
            if(fieldName == null) return false;

            return container.contains(fieldName);
        }
    }
}
