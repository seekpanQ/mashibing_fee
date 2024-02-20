package com.mashibing.method;

/**
 * 线程的等待和唤醒
 * <p>
 * 可以让获取synchronized锁资源的线程通过wait方法进去到锁的**等待池**，并且会释放锁资源
 * <p>
 * 可以让获取synchronized锁资源的线程，通过notify或者notifyAll方法，将等待池中的线程唤醒，添加到**锁池**中
 * <p>
 * notify随机的唤醒等待池中的一个线程到锁池
 * <p>
 * notifyAll将等待池中的全部线程都唤醒，并且添加到锁池
 * <p>
 * 在调用wait方法和notify以及norifyAll方法时，必须在synchronized修饰的代码块或者方法内部才可以，因为要操作基于某个对象的锁的信息维护。
 */
public class ThreadNotify {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            sync();
        }, "t1");

        Thread t2 = new Thread(() -> {
            sync();
        }, "t2");
        t1.start();
        t2.start();
        Thread.sleep(12000);
        synchronized (ThreadNotify.class) {
//            ThreadNotify.class.notify();//随机的唤醒等待池中的一个线程到锁池
            ThreadNotify.class.notifyAll();//唤醒所有等待池中的线程，并添加到锁池，等待被CPU调度
        }

    }

    public static synchronized void sync() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    ThreadNotify.class.wait();//进入等待池，释放锁资源
                }
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
