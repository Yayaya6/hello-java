package com.dimon.tryjava.myThread.JUCexecutor.threadPoolExecutor;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest0 {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool =
                new ThreadPoolExecutor(5, 5,
                        0L, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(20));

        pool.execute(new Task("A"));
        pool.execute(new Task("B"));
        pool.execute(new Task("C"));
        pool.execute(new Task("D"));
        pool.execute(new Task("E"));
        pool.execute(new Task("F"));
        pool.execute(new Task("G"));

        pool.shutdown();
        pool.awaitTermination(3, TimeUnit.SECONDS);
        pool.shutdownNow();
    }

}

class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("task-%s running ...\n", name);
        try {
            Thread.sleep(new Random().nextInt(2500) + 500);
        } catch (InterruptedException e) {
            System.out.printf("task-%s interrupted!\n", name);
            return;
        }
        System.out.printf("task-%s completed.\n", name);
    }
}
