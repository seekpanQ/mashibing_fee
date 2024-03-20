package com.mashibing;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 首先PriorityBlockingQueue是一个优先级队列，他不满足先进先出的概念。
 * <p>
 * 会将查询的数据进行排序，排序的方式就是基于插入数据值的本身。
 * <p>
 * **如果是自定义对象必须要实现Comparable接口才可以添加到优先级队列**
 * <p>
 * 排序的方式是基于**二叉堆**实现的。底层是采用数据结构实现的二叉堆。
 */
public class PriorityBlockingQueueTest {

    public static void main(String[] args) {

        PriorityBlockingQueue queue = new PriorityBlockingQueue();
        queue.add("234");
        queue.add("123");
        queue.add("456");
        queue.add("345");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}
