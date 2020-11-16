package com.lbt.designPattern.pattern.proxy;

import com.lbt.designPattern.pattern.proxy.cglib.AlipayMethodInterceptor;
import com.lbt.designPattern.pattern.proxy.cglib.CglibDynamicProxyUtil;
import net.sf.cglib.proxy.MethodInterceptor;


/**
 * @Author LiBiTong
 * @Description 静态代理demo
 * @Date 2020/9/13 22:43
 */
public class ProxyDemo {
    public static void main(String[] args) {
        //静态代理**************
//        ToCPayment toCProxy = new AlipayToC(new ToCPaymentImpl());
//        toCProxy.pay();
//        ToBPayment toBPayment = new AlipayToB(new ToBPaymentImpl());
//        toBPayment.pay();
        //jdk动态代理************
       /* ToCPayment toCPayment =new ToCPaymentImpl();
        InvocationHandler invocationHandler = new AlipayInvocationHandler(toCPayment);
        ToCPayment toCProxy = JdkDynamicProxyUtil.newProyInstance(toCPayment, invocationHandler);
        toCProxy.pay();*/
        //cgLib动态代理****************
        CommonPayment commonPayment = new CommonPayment();
        MethodInterceptor interceptor = new AlipayMethodInterceptor();
        CommonPayment commonPaymentProxy =
                CglibDynamicProxyUtil.createProxy(commonPayment,interceptor);
        commonPaymentProxy.pay();

    }
}
