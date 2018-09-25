package com.dimon.tryjava.myThread;

public class MyThread11 extends Thread
{
    private int i = 0;

    public void run()
    {
        try
        {
            while (true)
            {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /*
    * Java中有两种线程，一种是用户线程，一种是守护线程。
    * 守护线程是一种特殊的线程，它的作用是为其他线程的运行提供便利的服务，最典型的应用便是GC线程。
    * 如果进程中不存在非守护线程了，那么守护线程自动销毁，因为没有存在的必要，为别人服务，结果服务的对象都没了，当然就销毁了。
    * */
    public static void main(String[] args)
    {
        try
        {
            MyThread11 mt = new MyThread11();
            mt.setDaemon(true);
            mt.start();
            Thread.sleep(5000);
            System.out.println("我离开thread对象再也不打印了，我停止了！");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}