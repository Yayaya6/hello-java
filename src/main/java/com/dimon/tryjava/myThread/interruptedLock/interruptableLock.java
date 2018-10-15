package com.dimon.tryjava.myThread.interruptedLock;

import java.util.concurrent.locks.ReentrantLock;

public class interruptableLock {

    public static void main(String[] args)
            throws InterruptedException
    {
        // 锁对象
        ReentrantLock lock = new ReentrantLock();

        // 线程 A，我们故意让它先持有锁
        Runnable taskA = () -> {
            lock.lock(); // 获取锁
            try {
                System.out.println("[A]\t你们都别想了，锁已经归我所有了");
                while (true) {
                    try {
                        Thread.sleep(Integer.MAX_VALUE); // 就是不释放锁
                    } catch (InterruptedException e) {
                        System.out.println("[A]\t别吵我睡觉");
                    }
                }
            } finally {
                lock.unlock(); // 释放锁
            }
        };

        // 线程 B，一直无法获取锁，无限制等待
        Runnable taskB = () -> {
            try {
                System.out.println("[B]\t我就不信了，我就一直在这等 ...");
                lock.lockInterruptibly(); // 获取锁(可中断)
                try {
                    System.out.println("[B]\t终于轮到老子装逼了，哈哈哈");
                } finally {
                    lock.unlock(); // 释放锁
                }
            } catch (InterruptedException e) {
                System.out.println("[B]\t算了算了，我不要这把破锁了");
            }
        };

        // 创建线程 A、线程 B
        Thread t1 = new Thread(taskA);
        Thread t2 = new Thread(taskB);

        // 先启动线程 A
        t1.start();
        // 休息片刻
        Thread.sleep(100);
        // 再启动线程 B
        t2.start();

        // 尝试中断线程 B
        Thread.sleep(3000);
        t2.interrupt();
    }

}

//https://www.zfl9.com/java-juc-framework.html#%E5%8E%9F%E5%AD%90%E6%9B%B4%E6%96%B0%E6%95%B0%E7%BB%84