package com.lbt.designPattern.pattern.factory.entity;

public class DellMouse implements Mouse {
    @Override
    public void sayHi() {
        System.out.println("我是戴尔鼠标");
    }
}
