package com.mashibing.create;

/**
 * 匿名内部类方式
 */
public class ThreadCreateTest3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("匿名内部类:" + i);
                }
            }
        });

        t1.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main:" + i);
        }
    }
}
