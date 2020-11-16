package com.lbt.designPattern.pattern.factory.simple;

import com.lbt.designPattern.pattern.factory.entity.DellMouse;
import com.lbt.designPattern.pattern.factory.entity.HpMouse;
import com.lbt.designPattern.pattern.factory.entity.LenovoMouse;
import com.lbt.designPattern.pattern.factory.entity.Mouse;

public class MouseFactory {
    public static Mouse  createMouse(int type){
        switch (type) {
            case 0: return new DellMouse();
            case 1: return new HpMouse();
            case 2: return new LenovoMouse();
            default: return new DellMouse();
        }
    }

    public static void main(String[] args) {
        Mouse mouse = MouseFactory.createMouse(1);
        mouse.sayHi();
    }
}
