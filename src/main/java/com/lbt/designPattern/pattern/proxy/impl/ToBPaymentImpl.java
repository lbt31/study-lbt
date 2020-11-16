package com.lbt.designPattern.pattern.proxy.impl;

import com.lbt.designPattern.pattern.proxy.ToBPayment;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/9/13 22:48
 */
public class ToBPaymentImpl implements ToBPayment {
    @Override
    public void pay() {
        System.out.println("以公司的名义进行支付");
    }
}
