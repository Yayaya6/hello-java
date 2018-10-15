package com.dimon.tryjava.myThread.interruptedLock;

public class uninterruptedLock {

    public static void main(String[] args)
            throws InterruptedException
    {
        // 锁对象
        Object lock = new Object();

        // 线程 A，我们故意让它先持有锁
        Runnable taskA = () -> {
            synchronized (lock) {
                System.out.println("[A]\t你们都别想了，锁已经归我所有了");
                while (true) {
                    try {
                        Thread.sleep(Integer.MAX_VALUE); // 就是不释放锁
                    } catch (InterruptedException e) {
                        System.out.println("[A]\t别吵我睡觉");
                    }
                }
            }
        };

        // 线程 B，一直无法获取锁，无限制等待
        Runnable taskB = () -> {
            System.out.println("[B]\t我就不信了，我就一直在这等 ...");
            synchronized (lock) {
                System.out.println("[B]\t终于轮到老子装逼了，哈哈哈");
            }
        };

        // 创建线程 A、线程 B
        Thread t1 = new Thread(taskA);
        Thread t2 = new Thread(taskB);

        // 先启动线程 A
        t1.start();
        // 休息片刻
        Thread.sleep(100);
        // 再启动线程 B
        t2.start();

        // 尝试中断线程 B
        t2.interrupt(); // 无法中断
    }

}
