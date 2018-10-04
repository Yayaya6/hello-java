package com.dimon.tryjava.myThread.reentrantLock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by limeng on 2018/10/4.
 */
public class ThreadDomain39
{
    private Lock lock = new ReentrantLock();

    public void methodA()
    {
        try
        {
            lock.lock();
            System.out.println("MethodA begin ThreadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("MethodA end ThreadName = " + Thread.currentThread().getName());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }

    }

    public void methodB()
    {
        lock.lock();
        System.out.println("MethodB begin ThreadName = " + Thread.currentThread().getName());
        System.out.println("MethodB end ThreadName = " + Thread.currentThread().getName());
        lock.unlock();
    }

    /*
    *
    * ReentrantLock持有的是对象监视器
    * ReentrantLock虽然持有对象监视器，但是和synchronized持有的对象监视器不是一个意思，
    * 虽然我也不清楚两个持有的对象监视器有什么区别，
    * 不过把methodB()方法用synchronized修饰，methodA()不变，两个方法还是异步运行的，
    * 所以就记一个结论吧----ReentrantLock和synchronized持有的对象监视器不同。
    * ReentrantLock持有的锁是需要手动去unlock()的
    * */
    public static void main(String[] args)
    {
        ThreadDomain39 td = new ThreadDomain39();
        MyThread39_0 mt0 = new MyThread39_0(td);
        MyThread39_1 mt1 = new MyThread39_1(td);
        mt0.start();
        mt1.start();
    }
}