package com.dimon.tryjava.myThread;

/**
 * Created by limeng on 2018/10/2.
 */
public class MyThread30_1 extends Thread
{
    private Object lock;

    public MyThread30_1(Object lock)
    {
        this.lock = lock;
    }

    public void run()
    {
        synchronized (lock)
        {
            System.out.println("开始------notify time = " + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束------notify time = " + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) throws Exception
    {
        Object lock = new Object();
        MyThread30_0 mt0 = new MyThread30_0(lock);
        mt0.start();
        Thread.sleep(3000);
        MyThread30_1 mt1 = new MyThread30_1(lock);
        mt1.start();
    }
}