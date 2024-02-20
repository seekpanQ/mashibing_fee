package com.mashibing.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * **CAS的问题**：
 * <p>
 * * **ABA问题**：问题如下，可以引入版本号的方式，来解决ABA的问题。Java中提供了一个类在CAS时，针对各个版本追加版本号的操作。 AtomicStampeReference
 * AtomicStampedReference在CAS时，不但会判断原值，还会比较版本信息。
 * <p>
 * **自旋时间过长问题**：
 * <p>
 * * 可以指定CAS一共循环多少次，如果超过这个次数，直接失败/或者挂起线程。（自旋锁、自适应自旋锁）
 * * 可以在CAS一次失败后，将这个操作暂存起来，后面需要获取结果时，将暂存的操作全部执行，再返回最后的结果。
 */
public class ABA {

    public static void main(String[] args) {
        AtomicStampedReference<String> reference = new AtomicStampedReference<>("AAA", 1);

        String oldValue = reference.getReference();
        int oldVersion = reference.getStamp();
        System.out.println("版本:" + oldVersion);

        boolean b = reference.compareAndSet(oldValue, "B", oldVersion, oldVersion + 1);
        System.out.println("版本:" + reference.getStamp());
        System.out.println("修改1版本的：" + b);


        boolean c = reference.compareAndSet("B", "C", 1, 1 + 1);
        System.out.println("版本:" + reference.getStamp());
        System.out.println("修改2版本的：" + c);
    }
}
