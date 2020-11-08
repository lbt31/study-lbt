package com.lbt.thread.singleThread.producerAndconsumer;

import java.util.function.Consumer;

/**
 * @Author LiBiTong
 * @Description wait形式实现生产者消费者模式
 * @Date 2020/9/14 21:43
 */
public class WaitStyle {
    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(10);
        ProducerTest producer = new ProducerTest(myBlockingQueue);
        ConsumerTest consumer = new ConsumerTest(myBlockingQueue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
class ProducerTest implements Runnable {

    private MyBlockingQueue storage;

    public ProducerTest(MyBlockingQueue storage) {
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

class ConsumerTest implements Runnable {

    private MyBlockingQueue storage;

    public ConsumerTest(MyBlockingQueue storage) {
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
