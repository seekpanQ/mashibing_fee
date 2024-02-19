package com.mashibing.state;

public class StateBlocked {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            // t1线程拿不到锁资源，导致变为BLOCKED状态
            synchronized (obj) {

            }

        });
        // main线程拿到obj的锁资源
        synchronized (obj) {
            t1.start();
            Thread.sleep(500);
            System.out.println(t1.getState());
        }
    }
}
