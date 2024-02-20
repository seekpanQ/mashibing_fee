package com.mashibing.order;

/**
 * 单例模式由于指令重排序可能会出现问题：
 * <p>
 * 线程可能会拿到没有初始化的对象，导致在使用时，可能由于内部属性为默认值，导致出现一些不必要的问题
 * <p>
 * <p>
 * 如果需要让程序对某一个属性的操作不出现指令重排，除了满足happens-before原则之外，还可以基于volatile修饰属性，从而对这个属性的操作，就不会出现指令重排的问题了。
 * <p>
 * volatile如何实现的禁止指令重排？
 * <p>
 * 内存屏障概念。将内存屏障看成一条指令。
 * <p>
 * 会在两个操作之间，添加上一道指令，这个指令就可以避免上下执行的其他指令进行重排序。
 */
public class SingleTon {

    private static volatile SingleTon singleTon = null;//volatile禁止指令重排序，可以解决此问题

    private SingleTon() {

    }

    public static SingleTon getInstance() {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null) {
                    // 开辟空间，test指向地址，初始化
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
