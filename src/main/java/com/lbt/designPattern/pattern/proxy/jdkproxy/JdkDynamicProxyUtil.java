package com.lbt.designPattern.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/9/13 23:06
 */
public class JdkDynamicProxyUtil {

    public static <T>T newProyInstance(T targetObject, InvocationHandler handler){
        ClassLoader classLoader = targetObject.getClass().getClassLoader();
        Class<?>[] interfaces = targetObject.getClass().getInterfaces();
        return (T)Proxy.newProxyInstance(classLoader,interfaces,handler);
    }
}
