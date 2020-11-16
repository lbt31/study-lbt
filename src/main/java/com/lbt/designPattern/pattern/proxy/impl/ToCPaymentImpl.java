package com.lbt.designPattern.pattern.proxy.impl;

import com.lbt.designPattern.pattern.proxy.ToCPayment;

/**
 * @Author LiBiTong
 * @Description 目标类
 * @Date 2020/9/13 22:38
 */
public class ToCPaymentImpl implements ToCPayment {
    @Override
    public void pay() {
        System.out.println("以用户的名义进行支付");
    }
}
