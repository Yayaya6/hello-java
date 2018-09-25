package com.dimon.tryjava.myThread;

public class MyThread05 extends Thread
{
    public MyThread05()
    {
        System.out.println("MyThread5----->Begin");
        System.out.println("Thread.currentThread().getName()----->" +
                Thread.currentThread().getName());
        System.out.println("this.getName()----->" + this.getName());
        System.out.println("MyThread5----->end");
    }

    public void run()
    {
        System.out.println("run----->Begin");
        System.out.println("Thread.currentThread().getName()----->" +
                Thread.currentThread().getName());
        System.out.println("this.getName()----->" + this.getName());
        System.out.println("run----->end");
    }


    /*
    *
    * 要理解一个重要的概念，就是"this.XXX()"和"Thread.currentThread().XXX()"的区别，这个就是最好的例子。必须要清楚的一点就是：当前执行的Thread未必就是Thread本身。从这个例子就能看出来：
    * （1）执行MyThread05构造方法是main，当前线程却是Thread-0
    * （2）执行run()方法的Thread-0，当前线程也是Thread-0，说明run()方法就是被线程实例去执行的
    * 所以，再强调一下，未必在MyThread05里调用Thread.currentThread()返回回来的线程对象的引用就是MyThread05
    * */
    public static void main(String[] args)
    {
        MyThread05 mt5 = new MyThread05();
        mt5.start();
    }
}