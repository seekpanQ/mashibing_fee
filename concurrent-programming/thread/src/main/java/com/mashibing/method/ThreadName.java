package com.mashibing.method;

/**
 * 在构建Thread对象完毕后，一定要设置一个有意义的名称，方面后期排查错误
 */
public class ThreadName {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        t1.setName("模块-功能-计数器");

        t1.start();

    }
}
