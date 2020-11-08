package com.lbt.designPattern.pattern.proxy;

/**
 * @Author LiBiTong
 * @Description 代理类
 * @Date 2020/9/13 22:39
 */
public class AlipayToB implements ToBPayment {
    ToBPayment toBPayment;
    public AlipayToB(ToBPayment toBPayment){
        this.toBPayment = toBPayment;
    }
    @Override
    public void pay() {
        beforePay();
        toBPayment.pay();
        afterPay();
    }

    private void afterPay() {
        System.out.println("支付给慕课网");
    }

    private void beforePay() {
        System.out.println("从招行取款");
    }
}
