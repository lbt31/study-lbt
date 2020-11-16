package com.lbt.designPattern.pattern.factory.method;

import com.lbt.designPattern.pattern.factory.entity.IBMMouse;
import com.lbt.designPattern.pattern.factory.entity.Mouse;

public class IBMMouseFactory extends LenovoMouseFactory {
    @Override
    public Mouse createMouse(){
        return new IBMMouse();
    }
}
