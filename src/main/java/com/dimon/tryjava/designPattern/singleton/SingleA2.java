package com.dimon.tryjava.designPattern.singleton;

public class SingleA2 {

    private static SingleA2 instance;

    private SingleA2() {
    }

    public synchronized static SingleA2 getInstance() {
        if (instance == null) {
            instance = new SingleA2();
        }
        return instance;
    }


    public static void main(String[] args) {
        System.out.println(SingleA2.getInstance());
    }

}

