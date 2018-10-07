package com.dimon.tryjava.myThread.JUCexecutor.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest0 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> task =
                new FutureTask<>(new Task("test success"));
        new Thread(task).start();
        System.out.println("task result: " + task.get());
    }

}

class Task implements Callable<String> {
    private String result;

    public Task(String result) {
        this.result = result;
    }

    @Override
    public String call() {
        System.out.println("task is running ...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("task is interrupted!");
            return "(null)";
        }
        System.out.println("task is completed.");
        return result;
    }
}
