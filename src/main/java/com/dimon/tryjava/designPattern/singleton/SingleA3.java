package com.dimon.tryjava.designPattern.singleton;


// double-check
public class SingleA3 {
    private static SingleA3 instance;
    private SingleA3(){}

    public static SingleA3 getInstance() {
        if (instance == null) {
            synchronized (SingleA3.class) {
                if (instance == null) {
                    instance = new SingleA3();
                }
            }
        }
        return instance;
    }

}
