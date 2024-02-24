package com.mashibing;

import org.openjdk.jol.info.ClassLayout;

/**
 * 了可以在Java中看到对象头的MarkWord信息，需要导入依赖
 * <p>
 * ```xml
 * <dependency>
 * <groupId>org.openjdk.jol</groupId>
 * <artifactId>jol-core</artifactId>
 * <version>0.9</version>
 * </dependency>
 * ```
 * <p>
 * 锁默认情况下，开启了偏向锁延迟。
 * 偏向锁在升级为轻量级锁时，会涉及到偏向锁撤销，需要等到一个安全点（STW），才可以做偏向锁撤销，在明知道有并发情况，就可以选择不开启偏向锁，或者是设置偏向锁延迟开启
 * <p>
 * 因为JVM在启动时，需要加载大量的.class文件到内存中，这个操作会涉及到synchronized的使用，为了避免出现偏向锁撤销操作，JVM启动初期，有一个延迟4s开启偏向锁的操作
 * <p>
 * 如果正常开启偏向锁了，那么不会出现无锁状态，对象会直接变为匿名偏向
 */
public class LockState {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        new Thread(() -> {

            synchronized (o) {
                //t1  - 偏向锁
                System.out.println("t1:" + ClassLayout.parseInstance(o).toPrintable());

            }
        }).start();
        //main - 偏向锁 - 轻量级锁CAS - 重量级锁
        synchronized (o) {
            System.out.println("main:" + ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
