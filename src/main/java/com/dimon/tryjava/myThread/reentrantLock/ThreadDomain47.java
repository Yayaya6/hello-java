package com.dimon.tryjava.myThread.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by limeng on 2018/10/4.
 */
public class ThreadDomain47 extends ReentrantLock
{
    public void waitMethod()
    {
        if (tryLock())
            System.out.println(Thread.currentThread().getName() + "获得了锁");
        else
            System.out.println(Thread.currentThread().getName() + "没有获得锁");
    }

    /*
    * tryLock()方法的作用是，在调用try()方法的时候，如果锁没有被另外一个线程持有，那么就返回true，否则返回false
    * tryLock(long timeout, TimeUnit unit)是tryLock()另一个重要的重载方法，
    * 表示如果在指定等待时间内获得了锁，则返回true，否则返回false
    * 注意一下，tryLock()只探测锁是否，并没有lock()的功能，要获取锁，还得调用lock()方法，
    *
    * 第一个线程获得了锁返回true，第二个线程自然返回的false。由于有了tryLock()这种机制，
    * 如果一个线程长时间在synchronzied代码/synchronized代码块之中，
    * 别的线程不得不长时间无限等待的情况将可以被避免。
    *
    * */

    public static void main(String[] args)
    {
        final ThreadDomain47 td = new ThreadDomain47();
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                td.waitMethod();
            }
        };
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        t0.start();
        t1.start();
    }
}