package com.mashibing.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 到底什么是CAS
 * <p>
 * compare and swap也就是比较和交换，他是一条CPU的并发原语。
 * <p>
 * 他在替换内存的某个位置的值时，首先查看内存中的值与预期值是否一致，如果一致，执行替换操作。这个操作是一个原子性操作。
 * <p>
 * Java中基于Unsafe的类提供了对CAS的操作的方法，JVM会帮助我们将方法实现CAS汇编指令。
 * <p>
 * 但是要清楚CAS只是比较和交换，在获取原值的这个操作上，需要你自己实现。
 * <p>
 * **CAS的缺点**：CAS只能保证对一个变量的操作是原子性的，无法实现对多行代码实现原子性。
 */
public class CAS {

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                count.incrementAndGet();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                count.incrementAndGet();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
