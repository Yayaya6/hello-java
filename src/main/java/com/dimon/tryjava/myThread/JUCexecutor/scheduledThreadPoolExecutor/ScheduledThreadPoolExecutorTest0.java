package com.dimon.tryjava.myThread.JUCexecutor.scheduledThreadPoolExecutor;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest0 {

//    这个和 Linux 下的 at 很相似，只执行一次
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor atService =
                new ScheduledThreadPoolExecutor(1);

        System.out.printf("current datetime: %1$tF %1$tT\n", new Date());

        atService.schedule(() -> System.out.printf("execute datetime: %1$tF %1$tT\n", new Date()),
                3, TimeUnit.SECONDS);

        atService.shutdown();
    }

}
