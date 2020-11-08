package com.lbt.thread.singleThread.stopThread;

/**
 * @Author LiBiTong
 * @Description 停止线程  interrupt方式
 * @Date 2020/9/14 20:38
 */
public class StopThread implements Runnable{

    @Override
    public void run() {
        int count = 0;
        //Thread.currentThread().isInterrupted() 判断线程是否被中断
        System.out.println(Thread.currentThread().isInterrupted());
        while(!Thread.currentThread().isInterrupted() && count<1000){
            System.out.println("count  = "+ count++);
        }
    }

    /**
     * 在 StopThread 类的 run() 方法中，首先判断线程是否被中断，然后判断 count 值是否小于 1000。这个线程的工作内容很简单，
     * 就是打印 0~999 的数字，每打印一个数字 count 值加 1，可以看到，线程会在每次循环开始之前，检查是否被中断了。接下来在
     * main 函数中会启动该线程，然后休眠 5 毫秒后立刻中断线程，该线程会检测到中断信号，于是在还没打印完1000个数的时候就会停
     * 下来，这种就属于通过 interrupt 正确停止线程的情况。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread(new StopThread());
            thread.start();
            Thread.sleep(50);
            thread.interrupt();
    }
}
