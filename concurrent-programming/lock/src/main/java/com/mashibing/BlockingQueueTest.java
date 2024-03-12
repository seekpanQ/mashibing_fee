package com.mashibing;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * add(E)     	// 添加数据到队列，如果队列满了，无法存储，抛出异常
 * offer(E)    // 添加数据到队列，如果队列满了，返回false
 * offer(E,timeout,unit)   // 添加数据到队列，如果队列满了，阻塞timeout时间，如果阻塞一段时间，依然没添加进入，返回false
 * put(E)      // 添加数据到队列，如果队列满了，挂起线程，等到队列中有位置，再扔数据进去，死等！
 * <p>
 * remove()    // 从队列中移除数据，如果队列为空，抛出异常
 * poll()      // 从队列中移除数据，如果队列为空，返回null，么的数据
 * poll(timeout,unit)   // 从队列中移除数据，如果队列为空，挂起线程timeout时间，等生产者扔数据，再获取
 * take()     // 从队列中移除数据，如果队列为空，线程挂起，一直等到生产者扔数据，再获取
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
// 必须设置队列的长度
        ArrayBlockingQueue queue = new ArrayBlockingQueue(4);

        // 生产者扔数据
        queue.add("1");
        queue.offer("2");
        queue.offer("3", 2, TimeUnit.SECONDS);
        queue.put("2");

        // 消费者取数据
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.take());
    }
}
