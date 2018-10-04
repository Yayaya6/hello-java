package com.dimon.tryjava.myThread.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by limeng on 2018/10/4.
 */
public class ThreadDomain45 extends ReentrantLock
{
    public void waitMethod()
    {
        try
        {
            lock();
            Thread.sleep(Integer.MAX_VALUE);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            unlock();
        }
    }

    /*
    * hasQueuedThread(Thread thread)用来查询指定的线程是否正在等待获取指定的对象监视器
    * hasQueuedThreads()用于查询是否有线程正在等待获取指定的对象监视器
    * */

    public static void main(String[] args) throws InterruptedException
    {
        final ThreadDomain45 td = new ThreadDomain45();
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                td.waitMethod();
            }
        };
        Thread t0 = new Thread(runnable);
        t0.start();
        Thread.sleep(500);
        Thread t1 = new Thread(runnable);
        t1.start();
        Thread.sleep(500);
        Thread t2 = new Thread(runnable);
        t2.start();
        Thread.sleep(500);
        System.out.println("t0 is waiting？" + td.hasQueuedThread(t0));
        System.out.println("t1 is waiting？" + td.hasQueuedThread(t1));
        System.out.println("t2 is waiting？" + td.hasQueuedThread(t2));
        System.out.println("is any thread waiting？" + td.hasQueuedThreads());
    }
}
