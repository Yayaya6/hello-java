package com.dimon.tryjava.myThread.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by limeng on 2018/10/4.
 */
public class ThreadDomain48_2 extends ReentrantReadWriteLock
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
    * 读和写之间互斥
    * 从时间上看，也是10000ms即10s，和代码里面是一致的，证明了读和写之间是互斥的。
    * 注意一下，"读和写互斥"和"写和读互斥"是两种不同的场景，但是证明方式和结论是一致的，所以就不证明了。
    * */
    public static void main(String[] args)
    {
        final ThreadDomain48_2 td = new ThreadDomain48_2();
        Runnable readRunnable = new Runnable()
        {
            public void run()
            {
                td.read();
            }
        };
        Runnable writeRunnable = new Runnable()
        {
            public void run()
            {
                td.write();
            }
        };
        Thread t0 = new Thread(readRunnable);
        Thread t1 = new Thread(writeRunnable);
        t0.start();
        t1.start();
    }

}

