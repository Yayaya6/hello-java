package com.dimon.tryjava.myThread;

/**
 * Created by limeng on 2018/10/2.
 */
public class MyThread25_2 extends Thread
{
    private ThreadDomain25 td;

    public MyThread25_2(ThreadDomain25 td)
    {
        this.td = td;
    }

    public void run()
    {
        td.printC();
    }
}