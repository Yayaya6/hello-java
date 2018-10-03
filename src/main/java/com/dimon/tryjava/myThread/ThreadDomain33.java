package com.dimon.tryjava.myThread;

/**
 * Created by limeng on 2018/10/2.
 */
public class ThreadDomain33
{
    public void testMethod(Object lock)
    {
        try
        {
            synchronized (lock)
            {
                System.out.println("Begin wait()");
                lock.wait();
                System.out.println("End wait()");
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("wait()被interrupt()打断了！");
            e.printStackTrace();
        }
    }
}