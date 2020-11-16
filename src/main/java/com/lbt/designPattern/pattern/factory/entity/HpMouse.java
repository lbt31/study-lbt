package com.lbt.designPattern.pattern.factory.entity;

import com.lbt.designPattern.annotation.TestAnnotation;

public class HpMouse  implements Mouse {
    @Override
    @TestAnnotation
    public void sayHi() {
        System.out.println("我是惠普鼠标");
    }
}
