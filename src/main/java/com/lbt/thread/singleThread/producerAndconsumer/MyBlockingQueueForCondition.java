package com.lbt.thread.singleThread.producerAndconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LiBiTong
 * @Description 用 Condition 实现生产者消费者模式的阻塞队列
 * @Date 2020/9/14 21:13
 */
public class MyBlockingQueueForCondition {
    private Queue queue;
    private int max = 16;
    private ReentrantLock lock = new ReentrantLock();
    //空标志
    private Condition notEmpty = lock.newCondition();
    //满标志
    private Condition notFull = lock.newCondition();

    public MyBlockingQueueForCondition(int size) {
        this.max = size;
        queue = new LinkedList();
    }

    public void put(Object o) throws InterruptedException {
        lock.lock();
        try {
            while (max == queue.size()) {
                notFull.await();
            }
            queue.add(o);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException{
        lock.lock();
        try{
            while(queue.size() == 0){
                notEmpty.await();
            }
            Object o = queue.remove();
            notFull.signalAll();
            return o;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyBlockingQueueForCondition conditionQueue = new MyBlockingQueueForCondition(10);
        ProducerCondition pro = new ProducerCondition(conditionQueue);
        ConsumerCondition con = new ConsumerCondition(conditionQueue);
        new Thread(pro).start();
        new Thread(con).start();
    }
}

class ProducerCondition implements Runnable {

    private MyBlockingQueueForCondition storage;

    public ProducerCondition(MyBlockingQueueForCondition storage) {
        this.storage = storage;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                storage.put(new Object());
                System.out.println("生成一个Object对象");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerCondition implements Runnable {

    private MyBlockingQueueForCondition storage;

    public ConsumerCondition(MyBlockingQueueForCondition storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                storage.take();
                System.out.println("消费一个Object对象");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

