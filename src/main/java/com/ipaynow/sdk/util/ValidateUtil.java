package com.ipaynow.sdk.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Set;

public class ValidateUtil {
    /**
     * 逐个字段校验，有错误立即返回
     * <p>为空代表校验通过， 否则有错误信息
     *
     * @param obj
     * @return
     */
    public static String validateOneByOne(Object obj) {
        if (obj == null) {
            return null;
        }
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
            if (ArrayUtils.isEmpty(propertyDescriptors)) {
                return null;
            }
            StringBuilder errorMsgBuilder = new StringBuilder();
            for (PropertyDescriptor descriptor : propertyDescriptors) {
                String propertyName = descriptor.getName();
                Set<ConstraintViolation<Object>> constraintViolationSet = validator.validateProperty(obj, propertyName);
                if (CollectionUtils.isNotEmpty(constraintViolationSet)) {
                    for (ConstraintViolation<Object> violation : constraintViolationSet) {
                        errorMsgBuilder.append(violation.getMessage() + ",");
                    }
                    errorMsgBuilder.deleteCharAt(errorMsgBuilder.lastIndexOf(","));
                }
                if (StringUtils.isNotBlank(errorMsgBuilder.toString())) {
                    return "<字段：[" + propertyName + "] > -> " + errorMsgBuilder.toString();
                }
            }
            return null;
        } catch (Throwable throwable) {
            throw new RuntimeException("Validators 框架校验字段合法性时发生异常", throwable);
        }
    }
}
