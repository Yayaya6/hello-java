package com.dimon.tryjava.myThread;

public class MyThread06 extends Thread
{
    public void run()
    {
        System.out.println("run = " + this.isAlive());
    }

    public static void main(String[] args) throws Exception
    {
        MyThread06 mt = new MyThread06();
        System.out.println("begin == " + mt.isAlive());
        mt.start();
//        main函数中加上Thread.sleep(100)的原因是为了确保Thread06的run()方法中的代码执行完，否则有可能end这里打印出来的是true
//        Thread.sleep(100);
        System.out.println("end == " + mt.isAlive());
    }
}