package com.dimon.tryjava.myThread;

public class MyThread12 extends Thread {
    public void run()
    {
        for (int i = 0; i < 500000; i++)
        {
            System.out.println("i = " + (i + 1));
        }
    }

}
