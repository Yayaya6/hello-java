package com.dimon.tryjava.myThread;

public class MyThread14_0 extends Thread
{
    private ThreadDomain14_0 td;

    public MyThread14_0(ThreadDomain14_0 td)
    {
        this.td = td;
    }

    public void run()
    {
        td.methodA();
    }
}