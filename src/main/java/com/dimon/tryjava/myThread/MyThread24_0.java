package com.dimon.tryjava.myThread;

public class MyThread24_0 extends Thread
{
    private ThreadDomain24 td;
    private MyObject mo;

    public MyThread24_0(ThreadDomain24 td, MyObject mo)
    {
        this.td = td;
        this.mo = mo;
    }

    public void run()
    {
        td.testMethod1(mo);
    }
}