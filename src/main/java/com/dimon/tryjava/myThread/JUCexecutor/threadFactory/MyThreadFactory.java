package com.dimon.tryjava.myThread.JUCexecutor.threadFactory;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {
    private final int MAX_NUM; // 最大线程数
    private AtomicInteger num = new AtomicInteger(0); // 原子量

    public MyThreadFactory(int maxNum) {
        if (maxNum < 0)
            this.MAX_NUM = 0;
        else
            this.MAX_NUM = maxNum;
    }

    @Override
    public Thread newThread(Runnable r) {
        int n = num.getAndIncrement(); // 原子后自增
        if (num.get() > MAX_NUM)
            return null;
        return new Thread(r, "MyFactory-Thread-" + n);
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool =
                new ThreadPoolExecutor(0, Integer.MAX_VALUE, // 无核心线程，可存在任意多个线程
                        30L, TimeUnit.SECONDS, // 超时时间为 30s
                        new SynchronousQueue<Runnable>(), // 长度为 0 的阻塞队列
                        new MyThreadFactory(5)); // 线程工厂只允许创建 5 个线程

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 10; i++)
            pool.execute(task);

        pool.shutdown();
    }
}
