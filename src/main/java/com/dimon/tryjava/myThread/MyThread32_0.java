package com.dimon.tryjava.myThread;

/**
 * Created by limeng on 2018/10/2.
 */
public class MyThread32_0 extends Thread
{
    private Object lock;

    public MyThread32_0(Object lock)
    {
        this.lock = lock;
    }

    public void run()
    {
        ThreadDomain32 td = new ThreadDomain32();
        td.testMethod(lock);
    }
}