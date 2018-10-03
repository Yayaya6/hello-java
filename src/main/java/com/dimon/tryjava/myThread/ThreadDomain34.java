package com.dimon.tryjava.myThread;

/**
 * Created by limeng on 2018/10/2.
 */
public class ThreadDomain34
{
    public void testMethod(Object lock)
    {
        try
        {
            synchronized (lock)
            {
                System.out.println("Begin wait(), ThreadName = " + Thread.currentThread().getName());
                lock.wait();
                System.out.println("End wait(), ThreadName = " + Thread.currentThread().getName());
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception
    {
        Object lock = new Object();
        MyThread34_0 mt0 = new MyThread34_0(lock);
        MyThread34_0 mt1 = new MyThread34_0(lock);
        MyThread34_0 mt2 = new MyThread34_0(lock);
        mt0.start();
        mt1.start();
        mt2.start();
        Thread.sleep(1000);
        MyThread34_1 mt3 = new MyThread34_1(lock);
        mt3.start();
    }
}