package com.lbt.designPattern.pattern.factory.method;

import com.lbt.designPattern.pattern.factory.entity.HpMouse;
import com.lbt.designPattern.pattern.factory.entity.Mouse;

public class HpMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
