package com.dimon.tryjava.myThread;

public class TestMain12_0
{

    /*
    * interrupt()方法的作用实际上是：在线程受到阻塞时抛出一个中断信号，这样线程就得以退出阻塞状态。
    * 换句话说，没有被阻塞的线程，调用interrupt()方法是不起作用的。
    * */
    public static void main(String[] args)
    {
        try
        {
            MyThread12 mt = new MyThread12();
            mt.start();
            Thread.sleep(2000);
            mt.interrupt();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}