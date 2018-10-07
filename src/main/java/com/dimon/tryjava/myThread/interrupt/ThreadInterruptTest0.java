package com.dimon.tryjava.myThread.interrupt;

public class ThreadInterruptTest0 {

 /*   代码分为以下几步：
      1、main函数起一个t线程
      2、main函数3秒钟之后给t线程打一个中断标识位，表示t线程要中断
      3、t线程无限轮询自己的中断标识位，中断了则打印、退出，否则一直运行

    从控制台上打印的语句看到，3秒钟中断后，打印出该打印的语句后，就停止了。
    那这种场景就是前面说的"频繁地检查"，导致程序效率低下；
    那如果不频繁地检查呢，比如在while中的else分支中加上Thread.sleep(500)，表示500ms即0.5s检查一次，
    那这种场景就是前面说的"中断得不到及时的响应"。

    其实这个例子中，t线程完全可以不用去管这个中断标识位的，不去检查就好了，只管做自己的事情，
    这说明中断标识位设不设置是别人的事情，处不处理是我自己的事情，没有强制要求必须处理中断。

    但是，那些会抛出InterruptedException的方法要除外。像sleep、wait、notify、join，
    这些方法遇到中断必须有对应的措施，可以直接在catch块中处理，也可以抛给上一层。
    这些方法之所以会抛出InterruptedException就是由于Java虚拟机在实现这些方法的时候，
    本身就有某种机制在判断中断标识位，如果中断了，就抛出一个InterruptedException。
    */

    public static void main(String[] args) throws Exception
    {
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                while (true)
                {
                    if (Thread.currentThread().isInterrupted())
                    {
                        System.out.println("线程被中断了");
                        return ;
                    }
                    else
                    {
                        System.out.println("线程没有被中断");
                    }
                }
            }
        };
        Thread t = new Thread(runnable);
        t.start();
        Thread.sleep(3000);
        t.interrupt();
        System.out.println("线程中断了，程序到这里了");
    }

}
