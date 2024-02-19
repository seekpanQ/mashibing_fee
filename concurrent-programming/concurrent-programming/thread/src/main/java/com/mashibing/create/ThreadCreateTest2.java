package com.mashibing.create;

/**
 * 实现Runnable接口 重写run方法
 */
public class ThreadCreateTest2 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        t1.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main:" + i);
        }

    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("MyRunnable:" + i);
        }
    }
}
