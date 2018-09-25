package com.dimon.tryjava.myThread;

public class MyThread04 extends Thread
{
    static
    {
        System.out.println("静态块的打印：" +
                Thread.currentThread().getName());
    }

    public MyThread04()
    {
        System.out.println("构造方法的打印：" +
                Thread.currentThread().getName());
    }

    public void run()
    {
        System.out.println("run()方法的打印：" +
                Thread.currentThread().getName());
    }

    /*
    * currentThread()方法返回的是对当前正在执行线程对象的引用。
    * 这个例子说明了，线程类的构造方法、静态块是被main线程调用的，而线程类的run()方法才是应用线程自己调用的。
    *
    * */

    public static void main(String[] args)
    {
        MyThread04 mt = new MyThread04();
        mt.start();
    }
}