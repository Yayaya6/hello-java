package com.dimon.tryjava.myThread.producerAndConsumer.waitNotify;

/**
 * Created by limeng on 2018/10/4.
 */
public class main {
    public static void main(String[] args)
    {
        final ThreadDomain41 td = new ThreadDomain41();
        Runnable producerRunnable = new Runnable()
        {
            public void run()
            {
                for (int i = 0; i < Integer.MAX_VALUE; i++)
                    td.set();
            }
        };
        Runnable customerRunnable = new Runnable()
        {
            public void run()
            {
                for (int i = 0; i < Integer.MAX_VALUE; i++)
                    td.get();
            }
        };
        Thread ProducerThread = new Thread(producerRunnable);
        ProducerThread.setName("Producer");
        Thread ConsumerThread = new Thread(customerRunnable);
        ConsumerThread.setName("Consumer");
        ProducerThread.start();
        ConsumerThread.start();
    }
}
