package com.dimon.tryjava.myThread;

public class ThreadDomain20
{
    public synchronized void otherMethod()
    {
        System.out.println("----------run--otherMethod");
    }

    public void doLongTask()
    {
        synchronized (this)
        {
            for (int i = 0; i < 1000; i++)
            {
                System.out.println("synchronized threadName = " +
                        Thread.currentThread().getName() + ", i = " + (i + 1));
                try
                {
                    Thread.sleep(5);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    * 既然上面得到了一个结论synchronized块获得的是对象锁，
    * 那么如果线程1访问了一个对象方法A的synchronized块，
    * 线程2对于同一对象同步方法B的访问应该是会被阻塞的，
    * 因为线程2访问同一对象的同步方法B的时候将会尝试去获取这个对象的对象锁，
    * 但这个锁却在线程1这里。
    * */

    public static void main(String[] args) throws Exception
    {
        ThreadDomain20 td = new ThreadDomain20();
        MyThread20_0 mt0 = new MyThread20_0(td);
        MyThread20_1 mt1 = new MyThread20_1(td);
        mt0.start();
        Thread.sleep(100);
        mt1.start();
    }
}