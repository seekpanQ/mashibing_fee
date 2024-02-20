package com.mashibing.method;

/**
 * 守护线程
 * 默认情况下，线程都是非守护线程
 * <p>
 * JVM会在程序中没有非守护线程时，结束掉当前JVM
 * <p>
 * 主线程默认是非守护线程，如果主线程执行结束，需要查看当前JVM内是否还有非守护线程，如果没有JVM直接停止
 */
public class DaemonThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("t1:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setDaemon(true);//设置为守护线程,非守护线程结束，守护线程不管有没有运行截止都会直接结束
        t1.start();
    }
}
