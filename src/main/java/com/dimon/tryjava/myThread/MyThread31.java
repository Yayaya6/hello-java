package com.dimon.tryjava.myThread;

/**
 * Created by limeng on 2018/10/2.
 */
public class MyThread31 extends Thread
{
    private Object lock;

    public MyThread31(Object lock)
    {
        this.lock = lock;
    }

    public void run()
    {
        ThreadDomain31 td = new ThreadDomain31();
        td.testMethod(lock);
    }

    public static void main(String[] args)
    {
        Object lock = new Object();
        MyThread31 mt0 = new MyThread31(lock);
        MyThread31 mt1 = new MyThread31(lock);
        mt0.start();
        mt1.start();
    }
}