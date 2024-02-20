package com.mashibing.method.stopthread;

/**
 * 使用共享变量（很少会用）
 * 这种方式用的也不多，有的线程可能会通过死循环来保证一直运行。
 * <p>
 * 咱们可以通过修改共享变量在破坏死循环，让线程退出循环，结束run方法
 */
public class ThreadStopWithFlag {

    static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (flag) {
                // 处理任务
            }
            System.out.println("任务结束");
        });
        t1.start();
        Thread.sleep(500);
        flag = false;
    }
}
