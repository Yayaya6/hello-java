package com.dimon.tryjava.myThread.producerAndConsumer.awaitSignal;

/**
 * Created by limeng on 2018/10/4.
 */
public class Customer
{
    private Object lock;

    public Customer(Object lock)
    {
        this.lock = lock;
    }

    public void getValue()
    {
        try
        {
            synchronized (lock)
            {
                if (ValueObject.value.equals(""))
                    lock.wait();
                System.out.println("Get的值是：" + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}