package com.lbt.designPattern.pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/9/13 23:24
 */
public class CglibDynamicProxyUtil {
    public static <T>T createProxy(T targetObject, MethodInterceptor interceptor){
        return (T)Enhancer.create(targetObject.getClass(), interceptor);
    }
}
