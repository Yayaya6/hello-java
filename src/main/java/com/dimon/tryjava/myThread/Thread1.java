package com.dimon.tryjava.myThread;

/**
 * Created by limeng on 2018/10/2.
 */
public class Thread1 extends Thread
{
    private DeadLock dl;

    public Thread1(DeadLock dl)
    {
        this.dl = dl;
    }

    public void run()
    {
        try
        {
            dl.rightLeft();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}