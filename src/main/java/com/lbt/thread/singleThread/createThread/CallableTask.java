package com.lbt.thread.singleThread.createThread;

import java.util.concurrent.Callable;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/9/14 20:27
 */
public class CallableTask implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("实现Callable接口创建线程");
        return null;
    }

}
