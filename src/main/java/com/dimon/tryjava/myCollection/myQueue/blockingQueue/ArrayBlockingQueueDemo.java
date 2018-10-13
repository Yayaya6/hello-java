package com.dimon.tryjava.myCollection.myQueue.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


public class ArrayBlockingQueueDemo {

    private final static ArrayBlockingQueue<Apple> queue = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}

class Apple {

    public Apple() {
    }
}

/**
 * 生产者线程
 */
class Producer implements Runnable {

    private final ArrayBlockingQueue<Apple> mAbq;

    Producer(ArrayBlockingQueue<Apple> arrayBlockingQueue) {
        this.mAbq = arrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            Produce();
        }
    }

    private void Produce() {
        try {
            Apple apple = new Apple();
            mAbq.put(apple);
            System.out.println("生产:" + apple);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 消费者线程
 */
class Consumer implements Runnable {

    private ArrayBlockingQueue<Apple> mAbq;

    Consumer(ArrayBlockingQueue<Apple> arrayBlockingQueue) {
        this.mAbq = arrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                comsume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void comsume() throws InterruptedException {
        Apple apple = mAbq.take();
        System.out.println("消费Apple=" + apple);
    }
}
/*---------------------
    作者：zejian_
    来源：CSDN
    原文：https://blog.csdn.net/javazejian/article/details/77410889?utm_source=copy
    版权声明：本文为博主原创文章，转载请附上博文链接！*/


