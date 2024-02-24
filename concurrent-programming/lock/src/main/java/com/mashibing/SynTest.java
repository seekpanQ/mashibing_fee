package com.mashibing;

/**
 * ### 类锁、对象锁
 * <p>
 * synchronized的使用一般就是同步方法和同步代码块。
 * <p>
 * synchronized的锁是基于对象实现的。
 * <p>
 * 如果使用同步方法
 * <p>
 * * static：此时使用的是当前类.class作为锁（类锁）
 * * 非static：此时使用的是当前对象做为锁（对象锁）
 */
public class SynTest {

    public static void main(String[] args) {
        // 锁的是，当前Test.class
        Test.a();

        Test test = new Test();
        // 锁的是new出来的test对象
        test.b();
    }
}

class Test {
    public static synchronized void a() {
        System.out.println("1111");
    }

    public synchronized void b() {
        System.out.println("2222");
    }
}
