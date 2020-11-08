package com.lbt.thread.singleThread.stopThread;

/**
 * @Author LiBiTong
 * @Description sleep 期间能否感受到中断验证
 * @Date 2020/9/14 20:45
 */
public class StopDuringSleep {
    /**
     * 如果 sleep、wait 等可以让线程进入阻塞的方法使线程休眠了，而处于休眠中的线程被中断，
     * 那么线程是可以感受到中断信号的，并且会抛出一个 InterruptedException 异常，同时清除中断
     * 信号，将中断标记位设置成 false。这样一来就不用担心长时间休眠中线程感受不到中断了，因为
     * 即便线程还在休眠，仍然能够响应中断通知，并抛出异常。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            int count = 0;
            try{
                System.out.println(Thread.currentThread().isInterrupted());
                while(!Thread.currentThread().isInterrupted() && count<1000){
                    System.out.println("count  = "+ count++);
                    Thread.sleep(10000);
                }
            }catch (InterruptedException e) {
                System.out.println(e);
                e.printStackTrace();
            }

        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }

}
