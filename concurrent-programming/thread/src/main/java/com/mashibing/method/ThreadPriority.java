package com.mashibing.method;

/**
 * 线程的优先级
 * 其实就是CPU调度线程的优先级、
 * <p>
 * java中给线程设置的优先级别有10个级别，从1~10任取一个整数。
 * <p>
 * 如果超出这个范围，会排除参数异常的错误
 */
public class ThreadPriority {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("t1:" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("t2:" + i);
            }
        });
        t1.setPriority(1);
        t2.setPriority(10);
        t2.start();
        t1.start();
    }
}
