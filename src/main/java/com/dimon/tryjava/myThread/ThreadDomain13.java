package com.dimon.tryjava.myThread;

public class ThreadDomain13
{
    private int num = 0;

    /*
    * 关键字synchronized取得的锁都是对象锁，而不是把一段代码或方法（函数）当作锁，
    * 哪个线程先执行带synchronized关键字的方法，哪个线程就持有该方法所属对象的锁，其他线程都只能呈等待状态。
    * 但是这有个前提：既然锁叫做对象锁，那么势必和对象相关，所以多个线程访问的必须是同一个对象。
    * */

    public synchronized  void addNum(String userName)
    {
        try
        {
            if ("a".equals(userName))
            {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            }
            else
            {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(userName + " num = " + num);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}