package com.mashibing.method.stopthread;

/**
 * 通过打断WAITING或者TIMED_WAITING状态的线程，从而抛出异常自行处理
 * <p>
 * 这种停止线程方式是最常用的一种，在框架和JUC中也是最常见的
 */
public class ThreadStopViaInterrupt2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                // 获取任务
                // 拿到任务，执行任务
                // 没有任务了，让线程休眠
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("基于打断形式结束当前线程");
                    return;
                }
            }
        });
        t1.start();
        Thread.sleep(500);
        t1.interrupt();
    }
}
