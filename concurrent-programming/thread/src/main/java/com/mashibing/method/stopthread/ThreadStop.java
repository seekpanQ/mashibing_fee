package com.mashibing.method.stopthread;

/**
 * stop方法（不用）
 * 强制让线程结束，无论你在干嘛，不推荐使用当然当然方式，但是，他确实可以把线程干掉
 */
public class ThreadStop {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread.sleep(500);
        t1.stop();
        Thread.sleep(500);
        System.out.println(t1.getState());
    }
}
