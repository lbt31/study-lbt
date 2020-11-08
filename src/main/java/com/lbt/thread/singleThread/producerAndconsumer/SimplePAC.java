package com.lbt.thread.singleThread.producerAndconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @Author LiBiTong
 * @Description 最简单的 BlockingQueue 生成者消费者模式
 * @Date 2020/9/14 21:06
 */
public class SimplePAC {
    public static void main(String[] args) {
        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(10);
         Runnable producer  = () ->{
             while (true){
                 try {
                     blockingQueue.put(new Object());
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         };
        new Thread(producer).start();
        new Thread(producer).start();
         Runnable consumer = () -> {
             while (true){
                 try {
                     blockingQueue.take();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         };
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}
