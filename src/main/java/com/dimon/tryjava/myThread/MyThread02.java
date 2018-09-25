package com.dimon.tryjava.myThread;

public class MyThread02 extends Thread
{
    public void run()
    {
        try
        {
            for (int i = 0; i < 3; i++)
            {
                Thread.sleep((int)(Math.random() * 1000));
                System.out.println("run = " + Thread.currentThread().getName());
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        MyThread02 mt = new MyThread02();
        // start()方法的作用讲得直白点就是通知"线程规划器"，此线程可以运行了，正在等待CPU调用线程对象得run()方法，产生一个异步执行的效果
        mt.start();

        try
        {
            // CPU执行哪个线程的代码具有不确定性
            for (int i = 0; i < 3; i++)
            {
                Thread.sleep((int)(Math.random() * 1000));
                System.out.println("run = " + Thread.currentThread().getName());
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}