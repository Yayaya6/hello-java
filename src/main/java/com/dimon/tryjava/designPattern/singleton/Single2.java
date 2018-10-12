package com.dimon.tryjava.designPattern.singleton;

public class Single2 {

    private static Single2 instance;

    private Single2() {
    }

    public synchronized static Single2 getInstance() {
        if (instance == null) {
            instance = new Single2();
        }
        return instance;
    }


    public static void main(String[] args) {
        System.out.println(Single2.getInstance());
    }

}

