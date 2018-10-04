package com.dimon.tryjava.myThread.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by limeng on 2018/10/4.
 */
public class ThreadDomain48_0 extends ReentrantReadWriteLock
{
    public void read()
    {
        try
        {
            readLock().lock();
            System.out.println(Thread.currentThread().getName() + "获得了读锁, 时间为" +
                    System.currentTimeMillis());
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            readLock().unlock();
        }
    }

    /*
    * 尽管方法加了锁，还休眠了10秒，但是两个线程还是几乎同时执行lock()方法后面的代码，看时间就知道了。
    * 说明lock.readLock()读锁可以提高程序运行效率，允许多个线程同时执行lock()方法后面的代码
    * */

    public static void main(String[] args)
    {
        final ThreadDomain48_0 td = new ThreadDomain48_0();
        Runnable readRunnable = new Runnable()
        {
            public void run()
            {
                td.read();
            }
        };
        Thread t0 = new Thread(readRunnable);
        Thread t1 = new Thread(readRunnable);
        t0.start();
        t1.start();
    }

}