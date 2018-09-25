package com.dimon.tryjava.myThread;

public class MyThread01 implements Runnable {

    @Override
    public void run() {
        for (int i =0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " is running!");
        }
    }

    public static void main(String[] args){
        MyThread01 mt0 = new MyThread01();
        Thread t = new Thread(mt0);
        t.start();

        for (int i=0; i<1000; i++) {
            System.out.println(Thread.currentThread().getName() + " is running!");
        }
    }
}
