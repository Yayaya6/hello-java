package com.dimon.tryjava.myThread;

public class MyThread20_0 extends Thread
{
    private ThreadDomain20 td;

    public MyThread20_0(ThreadDomain20 td)
    {
        this.td = td;
    }

    public void run()
    {
        td.doLongTask();
    }
}