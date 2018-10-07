package com.dimon.tryjava.myThread.threadlocal;

public class ThreadLocalTest_1 {

    private static final    // ThreadLocal 通常为 static 变量
            ThreadLocal<Boolean> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalTest_1.threadLocal.set(true); // 在 Main 线程中修改值为 true
        System.out.printf("[Thread-Main]\tthreadLocal: %s\n", ThreadLocalTest_1.threadLocal.get());

        new Thread(() -> {
            ThreadLocalTest_1.threadLocal.set(false);    // 在 A 线程中修改值为 false
            System.out.printf("[Thread-A]\tthreadLocal: %s\n", ThreadLocalTest_1.threadLocal.get());
        }).start();

        new Thread(() -> {
            // ThreadLocal 默认 value 为 null，可通过 initialValue() 设置默认值
            System.out.printf("[Thread-B]\tthreadLocal: %s\n", ThreadLocalTest_1.threadLocal.get());
        }).start();
    }
}
