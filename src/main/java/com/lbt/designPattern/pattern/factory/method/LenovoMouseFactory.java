package com.lbt.designPattern.pattern.factory.method;

import com.lbt.designPattern.pattern.factory.entity.LenovoMouse;
import com.lbt.designPattern.pattern.factory.entity.Mouse;

public class LenovoMouseFactory  implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new LenovoMouse();
    }
}
