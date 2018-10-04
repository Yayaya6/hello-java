package com.dimon.tryjava.myThread.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by limeng on 2018/10/4.
 */
public class ThreadDomain42
{
    private Lock lock = new ReentrantLock(true);

    public void testMethod()
    {
        try
        {
            lock.lock();
            System.out.println("ThreadName" + Thread.currentThread().getName() + "获得锁");
        }
        finally
        {
            lock.unlock();
        }
    }

    /*
    * 公平锁与非公平锁
    * ReentrantLock有一个很大的特点，就是可以指定锁是公平锁还是非公平锁，
    * 公平锁表示线程获取锁的顺序是按照线程排队的顺序来分配的，
    * 而非公平锁就是一种获取锁的抢占机制，是随机获得锁的，先来的未必就一定能先得到锁，
    * 从这个角度讲，synchronized其实就是一种非公平锁。
    * 非公平锁的方式可能造成某些线程一直拿不到锁，自然是非公平的了。
    * 看一下例子，new ReentrantLock的时候有一个单一参数的构造函数表示构造的是一个公平锁还是非公平锁，传入true就可以了：
    * */

    public static void main(String[] args) throws Exception
    {
        final ThreadDomain42 td = new ThreadDomain42();
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                System.out.println("◆线程" + Thread.currentThread().getName() + "运行了");
                td.testMethod();
            }
        };
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++)
            threads[i] = new Thread(runnable);
        for (int i = 0; i < 5; i++)
            threads[i].start();
    }
}
