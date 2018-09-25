package com.dimon.tryjava.myThread;

public class MyThread36 extends Thread
{
    public void run()
    {
        try
        {
            int secondValue = (int)(Math.random() * 10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /*
    * join()方法的作用是等待线程销毁。
    * join()方法反应的是一个很现实的问题，比如main线程的执行时间是1s，子线程的执行时间是10s，但是主线程依赖子线程执行完的结果，这时怎么办？可以像生产者/消费者模型一样，搞一个缓冲区，子线程执行完把数据放在缓冲区中，通知main线程，main线程去拿，这样就不会浪费main线程的时间了。
    * 另外一种方法，就是join()了。
    *
    * join()方法的一个重点是要区分出和sleep()方法的区别。
    * join(2000)也是可以的，表示调用join()方法所在的线程最多等待2000ms，
    * 两者的区别在于：sleep(2000)不释放锁，join(2000)释放锁，因为join()方法内部使用的是wait()，因此会释放锁。
    * */

    public static void main(String[] args) throws Exception
    {
        MyThread36 mt = new MyThread36();
        mt.start();
        mt.join();
        System.out.println("我想当mt对象执行完毕之后我再执行，我做到了");
    }
}