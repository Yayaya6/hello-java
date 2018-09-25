package com.dimon.tryjava.myThread;

public class MyThread08 extends Thread
{
    public void run()
    {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++)
        {
            Thread.yield();
            count = count + i + 1;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - beginTime) + "毫秒！");




    }

    /*
    * 暂停当前执行的线程对象，并执行其他线程。
    * 这个暂停是会放弃CPU资源的，并且放弃CPU的时间不确定，
    * 有可能刚放弃，就获得CPU资源了，也有可能放弃好一会儿，才会被CPU执行。
    * */

    public static void main(String[] args)
    {
        MyThread08 mt = new MyThread08();
        mt.start();
    }
}