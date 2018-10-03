package com.dimon.tryjava.myThread;

/**
 * Created by limeng on 2018/10/2.
 */
public class MyThread34_1 extends Thread
{
    private Object lock;

    public MyThread34_1(Object lock)
    {
        this.lock = lock;
    }

    public void run()
    {
        synchronized (lock)
        {
            lock.notifyAll();
        }
    }
}