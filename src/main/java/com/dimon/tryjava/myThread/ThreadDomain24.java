package com.dimon.tryjava.myThread;

public class ThreadDomain24
{
    public void testMethod1(MyObject mo)
    {
        try
        {
            synchronized (mo)
            {
                System.out.println("testMethod1__getLock time = " +
                        System.currentTimeMillis() + ", run ThreadName = " +
                        Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("testMethod1__releaseLock time = " +
                        System.currentTimeMillis() + ", run ThreadName = " +
                        Thread.currentThread().getName());
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


    /*
    * 细化synchronized(非this对象x)的三个结论
    * synchronized(非this对象x)格式的写法是将x对象本身作为对象监视器，有三个结论得出：
    * 1、当多个线程同时执行synchronized(x){}同步代码块时呈同步效果
    * 2、当其他线程执行x对象中的synchronized同步方法时呈同步效果
    * 3、当其他线程执行x对象方法中的synchronized(this)代码块时也呈同步效果
    *
    * */
    public static void main(String[] args)
    {
        ThreadDomain24 td = new ThreadDomain24();
        MyObject mo = new MyObject();
        MyThread24_0 mt0 = new MyThread24_0(td, mo);
        MyThread24_1 mt1 = new MyThread24_1(mo);
        mt0.start();
        mt1.start();
    }
}