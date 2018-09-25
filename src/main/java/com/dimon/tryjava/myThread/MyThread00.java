package com.dimon.tryjava.myThread;

public class MyThread00 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i< 100; i++){
            System.out.println(Thread.currentThread().getName() + " is running!");
        }
    }

    public static void main(String[] args) {
        MyThread00 mt0 = new MyThread00();
        mt0.start();

        for (int i =0 ; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " is running!");
        }
    }
}