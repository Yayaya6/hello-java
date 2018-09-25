package com.dimon.tryjava.myThread;

public class MyThread09_0 extends Thread
{
    public void run()
    {
        System.out.println("MyThread9_0 run priority = " +
                this.getPriority());
    }
}