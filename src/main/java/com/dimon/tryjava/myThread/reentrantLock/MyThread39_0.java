package com.dimon.tryjava.myThread.reentrantLock;

/**
 * Created by limeng on 2018/10/4.
 */
public class MyThread39_0 extends Thread
{
    private ThreadDomain39 td;

    public MyThread39_0(ThreadDomain39 td)
    {
        this.td = td;
    }

    public void run()
    {
        td.methodA();
    }
}