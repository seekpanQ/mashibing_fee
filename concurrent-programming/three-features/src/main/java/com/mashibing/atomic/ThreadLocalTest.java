package com.mashibing.atomic;

/**
 * ThreadLocal保证原子性的方式，是不让多线程去操作**临界资源**，让每个线程去操作属于自己的数据
 * <p>
 * ThreadLocal实现原理：
 * <p>
 * * 每个Thread中都存储着一个成员变量，ThreadLocalMap
 * * ThreadLocal本身不存储数据，像是一个工具类，基于ThreadLocal去操作ThreadLocalMap
 * * ThreadLocalMap本身就是基于Entry[]实现的，因为一个线程可以绑定多个ThreadLocal，这样一来，可能需要存储多个数据，所以采用Entry[]的形式实现。
 * * 每一个线程都自己独立的ThreadLocalMap，再基于ThreadLocal对象本身作为key，对value进行存取
 * * ThreadLocalMap的key是一个弱引用，弱引用的特点是，即便有弱引用，在GC时，也必须被回收。这里是为了在ThreadLocal对象失去引用后，如果key的引用是强引用，会导致ThreadLocal对象无法被回收
 * <p>
 * ThreadLocal内存泄漏问题：
 * <p>
 * * 如果ThreadLocal引用丢失，key因为弱引用会被GC回收掉，如果同时线程还没有被回收，就会导致内存泄漏，内存中的value无法被回收，同时也无法被获取到。
 * * 只需要在使用完毕ThreadLocal对象之后，及时的调用remove方法，移除Entry即可
 */


public class ThreadLocalTest {

    static ThreadLocal tl1 = new ThreadLocal();
    static ThreadLocal tl2 = new ThreadLocal();

    public static void main(String[] args) {
        tl1.set("123");
        tl2.set("456");
        Thread t1 = new Thread(() -> {
            System.out.println("t1:" + tl1.get());
            System.out.println("t1:" + tl2.get());
        });
        t1.start();

        System.out.println("main:" + tl1.get());
        System.out.println("main:" + tl2.get());
    }
}
