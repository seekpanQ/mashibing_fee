package com.mashibing.method;

/**
 * 线程的休眠
 * Thread的静态方法，让线程从运行状态转变为等待状态
 * <p>
 * sleep有两个方法重载：
 * <p>
 * * 第一个就是native修饰的，让线程转为等待状态的效果
 * * 第二个是可以传入毫秒和一个纳秒的方法（如果纳秒值大于等于0.5毫秒，就给休眠的毫秒值+1。如果传入的毫秒值是0，纳秒值不为0，就休眠1毫秒）
 * <p>
 * sleep会抛出一个InterruptedException
 */
public class ThreadSleep {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis());
    }
}
