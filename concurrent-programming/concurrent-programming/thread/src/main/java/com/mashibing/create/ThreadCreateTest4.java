package com.mashibing.create;

/**
 * lambda方式
 */
public class ThreadCreateTest4 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("lambda:" + i);
            }
        });

        t1.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main:" + i);
        }
    }
}
