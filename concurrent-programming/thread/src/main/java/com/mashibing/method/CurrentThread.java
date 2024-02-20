package com.mashibing.method;

/**
 * Thread的静态方法获取当前线程对象
 */
public class CurrentThread {

    public static void main(String[] args) {
        // 获取当前线程的方法
        Thread main = Thread.currentThread();
        System.out.println(main);

        // "Thread[" + getName() + "," + getPriority() + "," +  group.getName() + "]";
        // Thread[main,5,main]
    }
}
