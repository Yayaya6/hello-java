package com.dimon.tryjava.myThread;

public class MyThread17 extends Thread
{
    private ThreadDomain17 td;

    public MyThread17(ThreadDomain17 td)
    {
        this.td = td;
    }

    public void run()
    {
        td.testMethod();
    }
}