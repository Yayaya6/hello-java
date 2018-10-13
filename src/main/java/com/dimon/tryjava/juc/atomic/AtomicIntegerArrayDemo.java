package com.dimon.tryjava.juc.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {
    static AtomicIntegerArray arr = new AtomicIntegerArray(10);

    public static class AddThread implements Runnable{
        public void run(){
            for(int k=0;k<10000;k++)
                //执行数组中元素自增操作,参数为index,即数组下标
                arr.getAndIncrement(k%arr.length());
        }
    }
    public static void main(String[] args) throws InterruptedException {

        Thread[] ts=new Thread[10];
        //创建10条线程
        for(int k=0;k<10;k++){
            ts[k]=new Thread(new AddThread());
        }
        //启动10条线程
        for(int k=0;k<10;k++){ts[k].start();}
        for(int k=0;k<10;k++){ts[k].join();}
        //执行结果
        //[10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000]
        System.out.println(arr);
    }
}
/*
---------------------
        作者：zejian_
        来源：CSDN
        原文：https://blog.csdn.net/javazejian/article/details/72772470?utm_source=copy
        版权声明：本文为博主原创文章，转载请附上博文链接！*/
