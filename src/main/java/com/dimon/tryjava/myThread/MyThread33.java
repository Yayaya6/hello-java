package com.dimon.tryjava.myThread;

/**
 * Created by limeng on 2018/10/2.
 */
public class MyThread33 extends Thread
{
    private Object lock;

    public MyThread33(Object lock)
    {
        this.lock = lock;
    }

    public void run()
    {
        ThreadDomain33 td = new ThreadDomain33();
        td.testMethod(lock);
    }


    public static void main(String[] args) throws Exception
    {
        Object lock = new Object();
        MyThread33 mt = new MyThread33(lock);
        mt.start();
        Thread.sleep(5000);
        mt.interrupt();
    }
}