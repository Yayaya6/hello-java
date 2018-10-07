package com.dimon.tryjava.myThread.thisEscape;

public class ThisEscapeTest_0 {
    private StringBuilder sb; // 26 个大写字母

    public ThisEscapeTest_0() {
        // 先启动一个线程，成员式内部类
        new Thread(new Task()).start();

        this.sb = new StringBuilder();

        for (char i = 65; i <= 90; i++) {
            sb.append(i);
            // 模拟耗时操作
            for (long l = 0L; l < 50000000; l++);
        }
    }

    private class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("ThisEscapeTest_0.Task.run(): " + ThisEscapeTest_0.this.sb);
        }
    }

    public static void main(String[] args) {
        System.out.println("ThisEscapeTest_0.main(): " + new ThisEscapeTest_0().sb);
    }

}
