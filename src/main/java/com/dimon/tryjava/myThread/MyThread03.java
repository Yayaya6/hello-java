package com.dimon.tryjava.myThread;

public class MyThread03 extends Thread
{
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
    }

    // 调用start()方法的顺序不代表线程启动的顺序，线程启动顺序具有不确定性
    public static void main(String[] args)
    {
        MyThread03 mt0 = new MyThread03();
        MyThread03 mt1 = new MyThread03();
        MyThread03 mt2 = new MyThread03();

        mt0.start();
        mt1.start();
        mt2.start();
    }
}