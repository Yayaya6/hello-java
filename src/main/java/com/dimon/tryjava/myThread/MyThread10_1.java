package com.dimon.tryjava.myThread;

public class MyThread10_1 extends Thread
{
    public void run()
    {
        long beginTime = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++){}
        long endTime = System.currentTimeMillis();
        System.out.println("◇◇◇◇◇ thread1 use time = " +
                (endTime - beginTime));
    }

    /*
    * CPU会尽量将执行资源让给优先级比较高的线程
    * */

    public static void main(String[] args)
    {
        for (int i = 0; i < 5; i++)
        {
            MyThread10_0 mt0 = new MyThread10_0();
            mt0.setPriority(5);
            mt0.start();
            MyThread10_1 mt1 = new MyThread10_1();
            mt1.setPriority(4);
            mt1.start();
        }
    }
}