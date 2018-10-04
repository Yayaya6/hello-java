package com.dimon.tryjava.myThread.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by limeng on 2018/10/4.
 */
public class ThreadDomain48_1 extends ReentrantReadWriteLock
{
    public void write()
    {
        try
        {
            writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "获得了写锁, 时间为" +
                    System.currentTimeMillis());
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            writeLock().unlock();
        }
    }

    /*
    * 写和写之间互斥
    *
    * */
    public static void main(String[] args)
    {
        final ThreadDomain48_1 td = new ThreadDomain48_1();
        Runnable readRunnable = new Runnable()
        {
            public void run()
            {
                td.write();
            }
        };
        Thread t0 = new Thread(readRunnable);
        Thread t1 = new Thread(readRunnable);
        t0.start();
        t1.start();
    }
}