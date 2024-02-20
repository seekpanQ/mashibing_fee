package com.mashibing.visible;

/**
 * synchronized也是可以解决可见性问题的，synchronized的内存语义。
 * <p>
 * 如果涉及到了synchronized的同步代码块或者是同步方法，获取锁资源之后，将内部涉及到的变量从CPU缓存中移除，
 * 必须去主内存中重新拿数据，而且在释放锁之后，会立即将CPU缓存中的数据同步到主内存。
 */
public class SynSolution {

    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

            while (flag) {
                synchronized (SynSolution.class) {
                    // ....
                }
                System.out.println(111);
            }
            System.out.println("t1线程结束");
        });

        t1.start();
        Thread.sleep(10);
        flag = false;
        System.out.println("主线程将flag改为false");

    }
}
