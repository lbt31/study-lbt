package com.lbt.thread.singleThread.stopThread;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/9/14 20:56
 */
public class VolatileCanStop implements Runnable {
    private volatile boolean canceled = false;
    @Override
    public void run() {
        int num = 0;
        try {
            while (!canceled && num <= 1000000) {
                if (num % 10 == 0) {
                    System.out.println(num + "是10的倍数。");
                }
                num++;
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 什么场景下 volatile 修饰标记位可以让线程正常停止呢？如代码所示，声明了一个叫作 VolatileStopThread 的类，
     * 它实现了 Runnable 接口，然后在 run() 中进行 while 循环，在循环体中又进行了两层判断，首先判断 canceled
     * 变量的值，canceled 变量是一个被 volatile 修饰的初始值为 false 的布尔值，当该值变为 true 时，while 跳出循
     * 环，while 的第二个判断条件是 num 值小于1000000（一百万），在while 循环体里，只要是 10 的倍数就打印出来，
     * 然后 num++。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        VolatileCanStop r = new VolatileCanStop();
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(3000);
        r.canceled = true;
    }
}
