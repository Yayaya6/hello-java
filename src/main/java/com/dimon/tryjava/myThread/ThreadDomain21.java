package com.dimon.tryjava.myThread;

public class ThreadDomain21
{
    private String userNameParam;
    private String passwordParam;
    private String anyString = new String();

    public void setUserNamePassword(String userName, String password)
    {
        try
        {
            synchronized (anyString)
            {
                System.out.println("线程名称为：" + Thread.currentThread().getName() +
                        "在 " + System.currentTimeMillis() + " 进入同步代码块");
                userNameParam = userName;
                Thread.sleep(3000);
                passwordParam = password;
                System.out.println("线程名称为：" + Thread.currentThread().getName() +
                        "在 " + System.currentTimeMillis() + " 离开同步代码块");
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /*
    * 多个线程持有"对象监视器"为同一个对象的前提下，同一时间只能有一个线程可以执行synchronized(非this对象x)代码块中的代码。
    * 锁非this对象具有一定的优点：
    * 如果在一个类中有很多synchronized方法，这时虽然能实现同步，但会受到阻塞，从而影响效率。
    * 但如果同步代码块锁的是非this对象，则synchronized(非this对象x)代码块中的程序与同步方法是异步的，
    * 不与其他锁this同步方法争抢this锁，大大提高了运行效率。
    *
    * 注意一下"private String anyString = new String();"这句话，
    * 现在它是一个全局对象，因此监视的是同一个对象。如果移到try里面，那么对象的监视器就不是同一个了，
    * 调用的时候自然是异步调用，可以自己试一下。
    *
    * 最后提一点，synchronized(非this对象x)，这个对象如果是实例变量的话，
    * 指的是对象的引用，只要对象的引用不变，即使改变了对象的属性，运行结果依然是同步的。
    *
    * */

    public static void main(String[] args)
    {
        ThreadDomain21 td = new ThreadDomain21();
        MyThread21_0 mt0 = new MyThread21_0(td);
        MyThread21_1 mt1 = new MyThread21_1(td);
        mt0.start();
        mt1.start();
    }
}