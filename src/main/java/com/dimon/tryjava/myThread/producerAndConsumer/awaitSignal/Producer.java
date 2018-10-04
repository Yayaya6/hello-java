package com.dimon.tryjava.myThread.producerAndConsumer.awaitSignal;

/**
 * Created by limeng on 2018/10/4.
 */
public class Producer
{
    private Object lock;

    public Producer(Object lock)
    {
        this.lock = lock;
    }

    public void setValue()
    {
        try
        {
            synchronized (lock)
            {
                if (!ValueObject.value.equals(""))
                    lock.wait();
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("Set的值是：" + value);
                ValueObject.value = value;
                lock.notify();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}