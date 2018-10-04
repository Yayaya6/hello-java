package com.dimon.tryjava.myThread.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by limeng on 2018/10/4.
 */
public class ThreadDomain44
{
    public ReentrantLock lock = new ReentrantLock();

    public void testMethod()
    {
        try
        {
            lock.lock();
            System.out.println("ThreadName = " + Thread.currentThread().getName() + "进入方法！");
            System.out.println("是否公平锁？" + lock.isFair());
            Thread.sleep(Integer.MAX_VALUE);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }
    }

    /*
    * getQueueLength()方法用于获取正等待获取此锁定的线程估计数。
    * 注意"估计"两个字，因为此方法遍历内部数据结构的同时，线程的数据可能动态变化
    * isFair()用来获取此锁是否公平锁
    *
    * ReentrantLock默认的是非公平锁，因此是否公平锁打印的是false。
    * 启动了10个线程，只有1个线程lock()了，其余9个等待，都符合预期。
    * */

    public static void main(String[] args) throws InterruptedException
    {
        final ThreadDomain44 td = new ThreadDomain44();
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                td.testMethod();
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++)
            threads[i] = new Thread(runnable);
        for (int i = 0; i < 10; i++)
            threads[i].start();
        Thread.sleep(2000);
        System.out.println("有" + td.lock.getQueueLength() + "个线程正在等待！");
    }
}
