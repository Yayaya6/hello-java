package com.dimon.tryjava.designPattern.singleton;

public class SingleA4 {

    private static volatile SingleA4 instance;

    private SingleA4() {}

    public static SingleA4 getInstance() {
        if (instance == null) {
            synchronized (SingleA4.class) {
                if (instance == null) {
                    instance = new SingleA4();
                }
            }
        }
        return instance;
    }

}
