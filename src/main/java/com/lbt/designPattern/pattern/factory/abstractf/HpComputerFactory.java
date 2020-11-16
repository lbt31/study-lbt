package com.lbt.designPattern.pattern.factory.abstractf;

import com.lbt.designPattern.pattern.factory.entity.HpKeyboard;
import com.lbt.designPattern.pattern.factory.entity.HpMouse;
import com.lbt.designPattern.pattern.factory.entity.Keyboard;
import com.lbt.designPattern.pattern.factory.entity.Mouse;

public class HpComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
