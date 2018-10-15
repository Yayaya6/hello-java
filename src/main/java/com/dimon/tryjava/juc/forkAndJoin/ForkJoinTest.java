package com.dimon.tryjava.juc.forkAndJoin;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ExecutionException;

public class ForkJoinTest {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException
    {
        int[] arr = new int[100_000_000]; // 该数组占用内存 381.46 MB
        Arrays.parallelSetAll(arr,        // 使用随机数填充数组
                i -> ThreadLocalRandom.current().nextInt(100));

        ForkJoinPool pool = new ForkJoinPool(); // CPU 核数个线程

        long beg = System.nanoTime(); // 起始时间
        Future<Integer> future = pool.submit(new SumTask(arr, 0, arr.length));
        int result = future.get(); // 计算结果
        long end = System.nanoTime(); // 结束时间

        System.out.printf("计算结果: %d, 计算用时: %g ms\n", result, (end - beg) / 1000_000.0D);
        pool.shutdown(); // 关闭 ForkJoinPool 执行器
    }
}

class SumTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID = -7073936093401677580L;
    private static final int THRESHOLD = 80000; // 阀值

    private int[] arr;
    private int beg;
    private int end;

    public SumTask(int[] arr, int beg, int end) {
        this.arr = arr;
        this.beg = beg;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - beg <= THRESHOLD) { // 如果小于阀值则直接计算
            for (int i = beg; i < end; i++)
                sum += arr[i];
        } else { // 否则进行分割（递归）
            int mid = (beg + end) >> 1; // 取均值
            SumTask left = new SumTask(arr, beg, mid); // 任务 1
            SumTask right = new SumTask(arr, mid, end); // 任务 2
            left.fork(); // 执行任务 1
            right.fork(); // 执行任务 2
            sum = left.join() + right.join(); // 合并任务 1、2
        }
        return sum; // 返回计算结果
    }
}

//https://www.zfl9.com/java-juc-framework.html#%E5%8E%9F%E5%AD%90%E6%9B%B4%E6%96%B0%E6%95%B0%E7%BB%84