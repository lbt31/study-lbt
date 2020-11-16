package com.lbt.designPattern.pattern.factory.abstractf;

import com.lbt.designPattern.pattern.factory.entity.Keyboard;
import com.lbt.designPattern.pattern.factory.entity.LenovoKeyboard;
import com.lbt.designPattern.pattern.factory.entity.LenovoMouse;
import com.lbt.designPattern.pattern.factory.entity.Mouse;

public class LenovoComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new LenovoMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new LenovoKeyboard();
    }
}
