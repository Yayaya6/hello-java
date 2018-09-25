package com.dimon.tryjava.myThread;

public class ThreadDomain14_0
{
    public synchronized void methodA()
    {
        try
        {
            System.out.println("Begin methodA, threadName = " +
                    Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("End methodA, threadName = " +
                    Thread.currentThread().getName() + ", end Time = " +
                    System.currentTimeMillis());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void methodB()
    {
        try
        {
            System.out.println("Begin methodB, threadName = " +
                    Thread.currentThread().getName() + ", begin time = " +
                    System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("End methodB, threadName = " +
                    Thread.currentThread().getName());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /*
    * 从这个例子我们得出两个重要结论：
    * 1、A线程持有Object对象的Lock锁，B线程可以以异步方式调用Object对象中的非synchronized类型的方法
    * 2、A线程持有Object对象的Lock锁，B线程如果在这时调用Object对象中的synchronized类型的方法则需要等待，也就是同步
    *
    * */

    public static void main(String[] args)
    {
        ThreadDomain14_0 td = new ThreadDomain14_0();
        MyThread14_0 mt0 = new MyThread14_0(td);
        mt0.setName("A");
        MyThread14_1 mt1 = new MyThread14_1(td);
        mt1.setName("B");
        mt0.start();
        mt1.start();
    }
}