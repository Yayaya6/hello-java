package com.dimon.tryjava.myThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by limeng on 2018/10/2.
 */
public class ThreadDomain29
{
    public static AtomicInteger aiRef = new AtomicInteger();

    public void addNum()
    {
        System.out.println(Thread.currentThread().getName() + "加了100之后的结果：" +
                aiRef.addAndGet(100));
        aiRef.getAndAdd(1);
    }
}
