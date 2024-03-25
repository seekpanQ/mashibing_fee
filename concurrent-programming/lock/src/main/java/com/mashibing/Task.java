package com.mashibing;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 声明一个可以写入DelayQueue的元素类
 */
public class Task implements Delayed {
    /**
     * 任务的名称
     */
    private String name;

    /**
     * 什么时间点执行
     */
    private Long time;

    /**
     * @param name
     * @param time 单位毫秒。
     */
    public Task(String name, Long time) {
        this.name = name;
        this.time = time;
    }

    /**
     * 设置任务什么时候可以出延迟队列
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        // 单位是毫秒，视频里写错了，写成了纳秒，
        return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 两个任务在插入到延迟队列时的比较方式
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        return (int) (this.time - ((Task) o).getTime());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
