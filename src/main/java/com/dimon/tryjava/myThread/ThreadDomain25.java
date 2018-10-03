package com.dimon.tryjava.myThread;

/**
 * Created by limeng on 2018/10/2.
 */
public class ThreadDomain25 {
    public synchronized static void printA()
    {
        try
        {
            System.out.println("线程名称为：" + Thread.currentThread().getName() +
                    "在" + System.currentTimeMillis() + "进入printA()方法");
            Thread.sleep(3000);
            System.out.println("线程名称为：" + Thread.currentThread().getName() +
                    "在" + System.currentTimeMillis() + "离开printA()方法");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public synchronized static void printB()
    {
        System.out.println("线程名称为：" + Thread.currentThread().getName() +
                "在" + System.currentTimeMillis() + "进入printB()方法");
        System.out.println("线程名称为：" + Thread.currentThread().getName() +
                "在" + System.currentTimeMillis() + "离开printB()方法");

    }

    public synchronized void printC()
    {
        System.out.println("线程名称为：" + Thread.currentThread().getName() +
                "在" + System.currentTimeMillis() + "进入printC()方法");
        System.out.println("线程名称为：" + Thread.currentThread().getName() +
                "在" + System.currentTimeMillis() + "离开printC()方法");
    }

    public static void main(String[] args)
    {
        ThreadDomain25 td = new ThreadDomain25();
        MyThread25_0 mt0 = new MyThread25_0();
        MyThread25_1 mt1 = new MyThread25_1();
        MyThread25_2 mt2 = new MyThread25_2(td);
        mt0.start();
        mt1.start();
        mt2.start();
    }
}
