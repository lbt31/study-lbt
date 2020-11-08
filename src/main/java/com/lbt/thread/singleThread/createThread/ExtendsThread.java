package com.lbt.thread.singleThread.createThread;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/9/14 20:25
 */
public class ExtendsThread extends Thread {

    @Override
    public void run(){
        System.out.println("继承Thread类创建线程");
    }

    public static void main(String[] args) {
        new Thread(() -> System.out.println("使用内部类创建线程："+Thread.currentThread().getName())).start();
    }
}
