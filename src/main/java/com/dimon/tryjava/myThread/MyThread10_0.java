package com.dimon.tryjava.myThread;

public class MyThread10_0 extends Thread
{
    public void run()
    {
        long beginTime = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++){}
        long endTime = System.currentTimeMillis();
        System.out.println("◆◆◆◆◆ thread0 use time = " +
                (endTime - beginTime));
    }
}