package com.dimon.tryjava.designPattern.singleton;

public class Single4 {

    private static volatile Single4 instance;

    private Single4() {}

    public static Single4 getInstance() {
        if (instance == null) {
            synchronized (Single4.class) {
                if (instance == null) {
                    instance = new Single4();
                }
            }
        }
        return instance;
    }

}
