package com.dimon.tryjava.myThread.JUCexecutor.scheduledThreadPoolExecutor;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest1 {

    public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPoolExecutor crontabService =
                new ScheduledThreadPoolExecutor(1);

        System.out.printf("current datetime: %1$tF %1$tT\n", new Date());
        crontabService.scheduleAtFixedRate(
                () -> System.out.printf("execute datetime: %1$tF %1$tT\n", new Date()),
                0, 1, TimeUnit.SECONDS); // 每秒执行一次

        Thread.sleep(5 * 1000); // 睡眠 5s
        crontabService.shutdown(); // 关闭线程池
    }

}
