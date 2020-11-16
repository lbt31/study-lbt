package com.lbt.designPattern.pattern.factory.method;

import com.lbt.designPattern.pattern.factory.entity.DellMouse;
import com.lbt.designPattern.pattern.factory.entity.Mouse;

public class DellMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
