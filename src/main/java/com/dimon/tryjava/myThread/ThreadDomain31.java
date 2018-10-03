package com.dimon.tryjava.myThread;

/**
 * Created by limeng on 2018/10/2.
 */
public class ThreadDomain31
{
    public void testMethod(Object lock)
    {
        try
        {
            synchronized (lock)
            {
                System.out.println(Thread.currentThread().getName() + " Begin wait()");
                lock.wait();
                System.out.println(Thread.currentThread().getName() + " End wait");
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
