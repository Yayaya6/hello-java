package com.dimon.tryjava.myThread.threadGroup;

public class ThreadGroupTest1 {

  /*  线程组自动归属特性

    自动归属的意思就是自动归到当前线程组中，*/


/*
    从结果看，实例化了一个group出来，没有指定线程组，
    那么自动归到当前线程所属的线程组中，也就是隐式地在一个线程组中添加了一个子线程组。
*/
    public static void main(String[] args)
    {
        System.out.println("A处线程：" + Thread.currentThread().getName() + ", 所属线程：" + Thread.currentThread().getThreadGroup().getName() +
                ", 组中有线程组数量：" + Thread.currentThread().getThreadGroup().activeGroupCount());
        ThreadGroup group = new ThreadGroup("新的组");
        System.out.println("B处线程：" + Thread.currentThread().getName() + ", 所属线程：" + Thread.currentThread().getThreadGroup().getName() +
                ", 组中有线程组数量：" + Thread.currentThread().getThreadGroup().activeGroupCount());
        ThreadGroup[] tg = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(tg);
        for (int i = 0; i < tg.length; i++)
            System.out.println("第一个线程组名称为：" + tg[i].getName());
    }

}
