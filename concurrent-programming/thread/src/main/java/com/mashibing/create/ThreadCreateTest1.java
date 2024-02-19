package com.mashibing.create;

/**
 * 继承Thread类 重写run方法
 */
public class ThreadCreateTest1 {

    public static void main(String[] args) {
        MyJob t1 = new MyJob();
        t1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main:" + i);
        }

    }
}

class MyJob extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyJob:" + i);
        }
    }
}
