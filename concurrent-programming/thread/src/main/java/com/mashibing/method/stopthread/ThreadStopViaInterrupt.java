package com.mashibing.method.stopthread;

/**
 * interrupt方式
 */
public class ThreadStopViaInterrupt {

    public static void main(String[] args) throws InterruptedException {
        // 线程默认情况下，    interrupt标记位：false
        System.out.println(Thread.currentThread().isInterrupted());
        // 执行interrupt之后，再次查看打断信息
        Thread.currentThread().interrupt();
        // interrupt标记位：ture
        System.out.println(Thread.currentThread().isInterrupted());
        // 返回当前线程interrupt的标记位：ture，并归位为false
        System.out.println(Thread.interrupted());
        // 已经归位了
        System.out.println(Thread.interrupted());

        // =====================================================
        Thread t1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                // 处理业务
            }
            System.out.println("t1结束");
        });
        t1.start();
        Thread.sleep(500);
        t1.interrupt();
    }
}
