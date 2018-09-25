package com.dimon.tryjava.myThread;

public class MyThread09_1 extends Thread
{
    public void run()
    {
        System.out.println("MyThread9_1 run priority = " +
                this.getPriority());
        MyThread09_0 thread = new MyThread09_0();
        thread.start();
    }

    /*
    * 线程默认优先级为5，如果不手动指定，那么线程优先级具有继承性，比如线程A启动线程B，那么线程B的优先级和线程A的优先级相同
    *
    * */
    public static void main(String[] args)
    {
        System.out.println("main thread begin, priority = " +
                Thread.currentThread().getPriority());
        System.out.println("main thread end, priority = " +
                Thread.currentThread().getPriority());
        MyThread09_1 thread = new MyThread09_1();
        thread.start();
    }
}