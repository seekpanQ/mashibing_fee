package com.mashibing.method;

/**
 * 线程的强占
 * <p>
 * Thread的非静态方法join方法
 * <p>
 * 需要在某一个线程下去调用这个方法
 * <p>
 * 如果在main线程中调用了t1.join()，那么main线程会进入到等待状态，需要等待t1线程全部执行完毕，在恢复到就绪状态等待CPU调度。
 * <p>
 * 如果在main线程中调用了t1.join(2000)，那么main线程会进入到等待状态，需要等待t1执行2s后，在恢复到就绪状态等待CPU调度。如果在等待期间，t1已经结束了，那么main线程自动变为就绪状态等待CPU调度。
 */
public class ThreadJoin {

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

        t1.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 1) {
                try {
                    t1.join();//等待t1执行完毕
//                    t1.join(2000);//等待t1执行2秒
//                    t1.join(20000);//等待t1执行20秒,20秒内t1执行结束，则等待结束
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
