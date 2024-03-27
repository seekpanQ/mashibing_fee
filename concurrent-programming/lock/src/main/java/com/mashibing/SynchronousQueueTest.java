package com.mashibing;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 生产者：
 * <p>
 * - offer()：生产者在放到SynchronousQueue的同时，如果有消费者在等待消息，直接配对。如果没有消费者在等待消息，这里直接返回，告辞。
 * - offer(time,unit)：生产者在放到SynchronousQueue的同时，如果有消费者在等待消息，直接配对。如果没有消费者在等待消息，阻塞time时间，如果还没有，告辞。
 * - put()：生产者在放到SynchronousQueue的同时，如果有消费者在等待消息，直接配对。如果没有，死等。
 * <p>
 * 消费者：poll()，poll(time,unit)，take()。道理和上面的生产者一致。
 */
public class SynchronousQueueTest {

    public static void main(String[] args) throws InterruptedException {
        // 因为当前队列不存在数据，没有长度的概念。
        SynchronousQueue queue = new SynchronousQueue();

        String msg = "消息！";
//        new Thread(() -> {
//            // b = false：代表没有消费者来拿
//            boolean b = false;
//            try {
//                b = queue.offer(msg, 1, TimeUnit.SECONDS);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(b);
//        }).start();
//
//        Thread.sleep(100);
//
//        new Thread(() -> {
//            System.out.println(queue.poll());
//        }).start();

        new Thread(() -> {
            try {
                System.out.println(queue.poll(1, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(100);

        new Thread(() -> {
            queue.offer(msg);
        }).start();
    }
}
