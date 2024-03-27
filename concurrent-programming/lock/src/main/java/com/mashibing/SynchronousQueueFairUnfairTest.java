package com.mashibing;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueFairUnfairTest {

    public static void main(String[] args) throws InterruptedException {
        // 因为当前队列不存在数据，没有长度的概念。
//        SynchronousQueue queue = new SynchronousQueue(true);
        SynchronousQueue queue = new SynchronousQueue(false);

        new Thread(() -> {
            try {
                queue.put("生1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                queue.put("生2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                queue.put("生3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(100);
        new Thread(() -> {
            System.out.println("消1：" + queue.poll());
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            System.out.println("消2：" + queue.poll());
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            System.out.println("消3：" + queue.poll());
        }).start();
    }
}
