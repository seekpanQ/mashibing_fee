package com.mashibing;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 */
public class ReentrantReadWriteLockTest {

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            readLock.lock();
            try {
                System.out.println("子线程！");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                readLock.unlock();
            }
        }).start();

        Thread.sleep(1000);
        writeLock.lock();
        try {
            System.out.println("主线程！");
        } finally {
            writeLock.unlock();
        }
    }
}
