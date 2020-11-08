package com.lbt.thread.singleThread.createThread;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/9/14 20:24
 */
public class RunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println("实现Runnable接口创建线程");
    }
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类创建线程");
            }
        }).start();
    }
}
