package com.lbt.designPattern.pattern.factory.abstractf;

import com.lbt.designPattern.pattern.factory.entity.DellKeyboard;
import com.lbt.designPattern.pattern.factory.entity.DellMouse;
import com.lbt.designPattern.pattern.factory.entity.Keyboard;
import com.lbt.designPattern.pattern.factory.entity.Mouse;

public class DellComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
