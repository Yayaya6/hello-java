package com.dimon.tryjava.designPattern.singleton;


// double-check
public class Single3 {
    private static Single3 instance;
    private Single3(){}

    public static Single3 getInstance() {
        if (instance == null) {
            synchronized (Single3.class) {
                if (instance == null) {
                    instance = new Single3();
                }
            }
        }
        return instance;
    }

}
