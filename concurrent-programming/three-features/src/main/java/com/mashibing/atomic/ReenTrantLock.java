package com.mashibing.atomic;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁是在JDK1.5由Doug Lea研发的，他的性能相比synchronized在JDK1.5的时期，性能好了很多多，但是在JDK1.6对synchronized优化之后，性能相差不大，但是如果涉及并发比较多时，推荐ReentrantLock锁，性能会更好。
 * <p>
 * 实现方式：
 * <p>
 * <p>
 * ReentrantLock可以直接对比synchronized，在功能上来说，都是锁。
 * <p>
 * 但是ReentrantLock的功能性相比synchronized更丰富。
 * <p>
 * **ReentrantLock底层是基于AQS实现的，有一个基于CAS维护的state变量来实现锁的操作。**
 */
public class ReenTrantLock {

    private static int count;

    private static ReentrantLock lock = new ReentrantLock();

    public static void increment() {
        lock.lock();
        try {
            count++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();//必须保证锁能释放
        }


    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
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
        System.out.println(count);
    }
}
