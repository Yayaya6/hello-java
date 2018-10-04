package com.dimon.tryjava.myThread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by limeng on 2018/10/4.
 */
public class ThreadDomain40
{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await()
    {
        try
        {
            lock.lock();
            System.out.println("await时间为：" + System.currentTimeMillis());
            condition.await();
            System.out.println("await等待结束");
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

    public void signal()
    {
        try
        {
            lock.lock();
            System.out.println("signal时间为：" + System.currentTimeMillis());
            condition.signal();
        }
        finally
        {
            lock.unlock();
        }
    }

    /*
    * 差值是3000毫秒也就是3秒，符合代码预期，成功利用ReentrantLock的Condition实现了等待/通知模型。
    * 其实这个例子还证明了一点，Condition的await()方法是释放锁的，
    * 原因也很简单，要是await()方法不释放锁，那么signal()方法又怎么能调用到Condition的signal()方法呢？
    * 注意要是用一个Condition的话，那么多个线程被该Condition给await()后，调用Condition的signalAll()方法唤醒的是所有的线程。
    * 如果想单独唤醒部分线程该怎么办呢？
    * new出多个Condition就可以了，这样也有助于提升程序运行的效率。
    * 使用多个Condition的场景是很常见的，像ArrayBlockingQueue里就有。
    * */

    public static void main(String[] args) throws Exception
    {
        ThreadDomain40 td = new ThreadDomain40();
        MyThread40 mt = new MyThread40(td);
        mt.start();
        Thread.sleep(3000);
        td.signal();
    }

}