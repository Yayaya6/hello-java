package com.dimon.tryjava.myThread.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by limeng on 2018/10/4.
 */
public class ThreadDomain43
{
    private ReentrantLock lock = new ReentrantLock();

    public void testMethod1()
    {
        try
        {
            lock.lock();
            System.out.println("testMethod1 getHoldCount = " + lock.getHoldCount());
            testMethod2();
        }
        finally
        {
            lock.unlock();
        }
    }

    public void testMethod2()
    {
        try
        {
            lock.lock();
            System.out.println("testMethod2 getHoldCount = " + lock.getHoldCount());
        }
        finally
        {
            lock.unlock();
        }
    }

    /*
    * ReentrantLock和synchronized一样，
    * 锁都是可重入的，同一线程的同一个ReentrantLock的lock()方法被调用了多少次，getHoldCount()方法就返回多少
    * */

    public static void main(String[] args)
    {
        ThreadDomain43 td = new ThreadDomain43();
        td.testMethod1();
    }
}
