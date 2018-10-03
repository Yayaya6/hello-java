package com.dimon.tryjava.myThread;

/**
 * Created by limeng on 2018/10/2.
 */
public class DeadLock
{
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() throws Exception
    {
        synchronized (left)
        {
            Thread.sleep(2000);
            synchronized (right)
            {
                System.out.println("leftRight end!");
            }
        }
    }

    public void rightLeft() throws Exception
    {
        synchronized (right)
        {
            Thread.sleep(2000);
            synchronized (left)
            {
                System.out.println("rightLeft end!");
            }
        }
    }


    public static void main(String[] args)
    {
        DeadLock dl = new DeadLock();
        Thread0 t0 = new Thread0(dl);
        Thread1 t1 = new Thread1(dl);
        t0.start();
        t1.start();

        while(true);
    }
}