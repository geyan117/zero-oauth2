package com.zero.lab.oauth2.common.utils;


import cn.hutool.core.bean.BeanUtil;

/**
 * @author geyan
 * @date 2025/8/24
 */
public class ZeroBeanUtil {

    public static <T> T toBean(Object source, Class<T> targetClass) {
        return BeanUtil.toBean(source, targetClass);
    }
}
