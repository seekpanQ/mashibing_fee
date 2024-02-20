package com.mashibing;

/**
 * **原子性的定义：原子性指一个操作是不可分割的，不可中断的，一个线程在执行时，另一个线程不会影响到他。**
 * <p>
 * 并发编程的原子性用代码阐述：
 * <p>
 * 当前程序：多线程操作共享数据时，预期的结果，与最终的结果不符
 */
public class Atomic {

    private static int count;

    public static void increment() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();//非原子性操作
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);//结果不是预期的200
    }
}
