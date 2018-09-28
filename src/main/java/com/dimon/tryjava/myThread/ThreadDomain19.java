package com.dimon.tryjava.myThread;

public class ThreadDomain19
{
    public void serviceMethodA()
    {
        synchronized (this)
        {
            try
            {
                System.out.println("A begin time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end time = " + System.currentTimeMillis());
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }

    public void serviceMethodB()
    {
        synchronized (this)
        {
            System.out.println("B begin time = " + System.currentTimeMillis());
            System.out.println("B end time = " + System.currentTimeMillis());
        }
    }

    /*
    * 两个synchronized块之间具有互斥性
    * 如果线程1访问了一个对象A方法的synchronized块，那么线程B对同一对象B方法的synchronized块的访问将被阻塞
    *
    * 看到对于serviceMethodB()方法synchronized块的访问必须等到对于serviceMethodA()方法synchronized块的访问结束之后。
    * 那其实这个例子，我们也可以得出一个结论：synchronized块获得的是一个对象锁，换句话说，synchronized块锁定的是整个对象。
    *
    *
    * */
    public static void main(String[] args)
    {
        ThreadDomain19 td = new ThreadDomain19();
        MyThread19_0 mt0 = new MyThread19_0(td);
        MyThread19_1 mt1 = new MyThread19_1(td);
        mt0.start();
        mt1.start();
    }
}