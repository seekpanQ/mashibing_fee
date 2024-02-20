package com.mashibing.visible;

/**
 * volatile是一个关键字，用来修饰成员变量。
 * <p>
 * 如果属性被volatile修饰，相当于会告诉CPU，对当前属性的操作，不允许使用CPU的缓存，必须去和主内存操作
 * <p>
 * volatile的内存语义：
 * <p>
 * * volatile属性被写：当写一个volatile变量，JMM会将当前线程对应的CPU缓存及时的刷新到主内存中
 * * volatile属性被读：当读一个volatile变量，JMM会将对应的CPU缓存中的内存设置为无效，必须去主内存中重新读取共享变量
 * <p>
 * 其实加了volatile就是告知CPU，对当前属性的读写操作，不允许使用CPU缓存，加了volatile修饰的属性，会在转为汇编之后后，追加一个lock的前缀，CPU执行这个指令时，如果带有lock前缀会做两个事情：
 * <p>
 * * 将当前处理器缓存行的数据写回到主内存
 * * 这个写回的数据，在其他的CPU内核的缓存中，直接无效。
 * <p>
 * **总结：volatile就是让CPU每次操作这个数据时，必须立即同步到主内存，以及从主内存读取数据
 */
public class VisibleSolution {
    private volatile static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (flag) {
                // ....
            }
            System.out.println("t1线程结束");
        });

        t1.start();
        Thread.sleep(10);
        flag = false;
        System.out.println("主线程将flag改为false");
    }
}
