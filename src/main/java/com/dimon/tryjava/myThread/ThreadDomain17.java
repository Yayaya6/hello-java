package com.dimon.tryjava.myThread;

public class ThreadDomain17
{
    public synchronized void testMethod()
    {
        try
        {
            System.out.println("Enter ThreadDomain17.testMethod, currentThread = " +
                    Thread.currentThread().getName());
            long l = Integer.MAX_VALUE;
            while (true)
            {
                long lo = 2 / l;
                l--;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /*
    * 当一个线程执行的代码出现异常时，其所持有的锁会自动释放
    * */

    public static void main(String[] args)
    {
        ThreadDomain17 td = new ThreadDomain17();
        MyThread17 mt0 = new MyThread17(td);
        MyThread17 mt1 = new MyThread17(td);
        mt0.start();
        mt1.start();
    }
}