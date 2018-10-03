package com.dimon.tryjava.myThread;

/**
 * Created by limeng on 2018/10/2.
 */
public class MyThread34_0 extends Thread
{
    private Object lock;

    public MyThread34_0(Object lock)
    {
        this.lock = lock;
    }

    public void run()
    {
        ThreadDomain34 td = new ThreadDomain34();
        td.testMethod(lock);
    }
}