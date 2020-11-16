package com.lbt.designPattern.pattern.factory.abstractf;

import com.lbt.designPattern.pattern.factory.entity.Keyboard;
import com.lbt.designPattern.pattern.factory.entity.Mouse;

public interface ComputerFactory {
    Mouse createMouse();
    Keyboard createKeyboard();
}
