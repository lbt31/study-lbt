package com.lbt.designPattern.pattern.proxy;

/**
 * @Author LiBiTong
 * @Description 代理类
 * @Date 2020/9/13 22:39
 */
public class AlipayToC implements ToCPayment {
    ToCPayment toCPayment;
    public AlipayToC(ToCPayment toCPayment){
        this.toCPayment = toCPayment;
    }
    @Override
    public void pay() {
        beforePay();
        toCPayment.pay();
        afterPay();
    }

    private void afterPay() {
        System.out.println("支付给慕课网");
    }

    private void beforePay() {
        System.out.println("从招行取款");
    }
}
