package com.mashibing.order;

/**
 * ### 3.1 什么是有序性
 * <p>
 * 在Java中，.java文件中的内容会被编译，在执行前需要再次转为CPU可以识别的指令，CPU在执行这些指令时，为了提升执行效率，在不影响最终结果的前提下（满足一些要求），会对指令进行重排。
 * <p>
 * 指令乱序执行的原因，是为了尽可能的发挥CPU的性能。
 * <p>
 * Java中的程序是乱序执行的。
 * <p>
 * Java程序验证乱序执行效果：
 */
public class OrderProblemTest {
    static int a, b, x, y;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            a = 0;
            b = 0;
            x = 0;
            y = 0;

            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            if (x == 0 && y == 0) {
                System.out.println("第" + i + "次，x = " + x + ",y = " + y);
            }

        }
    }
}