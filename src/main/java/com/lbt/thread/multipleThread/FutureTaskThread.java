package com.lbt.thread.multipleThread;

import java.util.concurrent.*;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/9/15 21:16
 */
public class FutureTaskThread {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        FutureTask future = (FutureTask) service.submit(new FutureThread.CallableTask());
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                Thread.sleep(500);
            }
            System.out.println(future.isDone());
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            throw new IllegalArgumentException("Callable抛出异常");
        }
    }

}
