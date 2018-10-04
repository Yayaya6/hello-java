package com.dimon.tryjava.myThread.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by limeng on 2018/10/4.
 */
public class ThreadDomain46 extends ReentrantLock
{
    public void testMethod()
    {
        try
        {
            lock();
            System.out.println(Thread.currentThread().getName() + "线程持有了锁！");
            System.out.println(Thread.currentThread().getName() + "线程是否持有锁？" +
                    isHeldByCurrentThread());
            System.out.println("是否任意线程持有了锁？" + isLocked());
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

    public void testHoldLock()
    {
        System.out.println(Thread.currentThread().getName() + "线程是否持有锁？" +
                isHeldByCurrentThread());
        System.out.println("是否任意线程持有了锁？" + isLocked());
    }

    /*
    * isHeldByCurrentThread()表示此对象监视器是否由当前线程保持
    * isLocked()表示此对象监视器是否由任意线程保持
    * */

    public static void main(String[] args)
    {
        final ThreadDomain46 td = new ThreadDomain46();
        Runnable runnable0 = new Runnable()
        {
            public void run()
            {
                td.testMethod();
            }
        };
        Runnable runnable1 = new Runnable()
        {
            public void run()
            {
                td.testHoldLock();
            }
        };
        Thread t0 = new Thread(runnable0);
        Thread t1 = new Thread(runnable1);
        t0.start();
        t1.start();
    }
}