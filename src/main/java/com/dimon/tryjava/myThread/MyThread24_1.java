package com.dimon.tryjava.myThread;

public class MyThread24_1 extends Thread
{
    private MyObject mo;

    public MyThread24_1(MyObject mo)
    {
        this.mo = mo;
    }

    public void run()
    {
        mo.speedPrintString();
    }
}