package com.mashibing.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable 重写call方法，配合FutureTask
 * Callable一般用于有返回结果的非阻塞的执行方法
 * <p>
 * 同步非阻塞。
 */
public class ThreadCreateTest5 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1. 创建MyCallable
        MyCallable myCallable = new MyCallable();
        //2. 创建FutureTask，传入Callable
        FutureTask futureTask = new FutureTask(myCallable);
        //3. 创建Thread线程
        Thread t1 = new Thread(futureTask);
        //4. 启动线程
        t1.start();
        //5. 做一些操作
        //6. 要结果
        Object count = futureTask.get();
        System.out.println("总和为：" + count);
    }
}

class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            count += i;
        }
        return count;
    }
}
