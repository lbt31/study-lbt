package com.lbt.designPattern.pattern.eventmode;

import java.util.ArrayList;
import java.util.List;

public class EventSource {
    //事件监听器list
    private List<EventListener> listenerList = new ArrayList<>();
    //事件监听器注册
    public void register(EventListener listener){
        listenerList.add(listener);
    }
    //发布事件
    public void publishEvent(Event event){
        for(EventListener listener: listenerList){
            listener.processEvent(event);
        }
    }
}
