package com.lbt.designPattern.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/9/13 23:02
 */
public class AlipayInvocationHandler implements InvocationHandler {

    //被代理对象
    private Object tarObject;

    public AlipayInvocationHandler(Object tarObject){
        this.tarObject = tarObject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforePay();
        Object result = method.invoke(tarObject, args);
        afterPay();
        return result;
    }



    private void afterPay() {
        System.out.println("支付给慕课网");
    }

    private void beforePay() {
        System.out.println("从招行取款");
    }

}
