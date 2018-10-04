package com.dimon.tryjava.myThread.producerAndConsumer.awaitSignal;

/**
 * Created by limeng on 2018/10/4.
 */
public class main {
    public static void main(String[] args)
    {
        Object lock = new Object();
        final Producer producer = new Producer(lock);
        final Customer customer = new Customer(lock);
        Runnable producerRunnable = new Runnable()
        {
            public void run()
            {
                while (true)
                {
                    producer.setValue();
                }
            }
        };
        Runnable customerRunnable = new Runnable()
        {
            public void run()
            {
                while (true)
                {
                    customer.getValue();
                }
            }
        };
        Thread producerThread = new Thread(producerRunnable);
        Thread CustomerThread = new Thread(customerRunnable);
        producerThread.start();
        CustomerThread.start();
    }
}
