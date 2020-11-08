package com.lbt.thread.singleThread.producerAndconsumer;

import java.util.LinkedList;

/**
 * @Author LiBiTong
 * @Description 用 wait/notify 实现生产者消费者模式
 * @Date 2020/9/14 21:39
 */
public class MyBlockingQueue {

    private int maxSize;
    private LinkedList<Object> storage;

    public MyBlockingQueue(int size) {
        this.maxSize = size;
        storage = new LinkedList<>();
    }

    public synchronized void put(Object o ) throws InterruptedException {
        while (maxSize == storage.size()){
            wait();
        }
        storage.add(o);
        notifyAll();
    }
    public synchronized void take() throws InterruptedException {
        while (storage.size() == 0) {
            wait();
        }
        System.out.println(storage.remove());
        notifyAll();
    }

}
