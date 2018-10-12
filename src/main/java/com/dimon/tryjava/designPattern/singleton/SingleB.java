package com.dimon.tryjava.designPattern.singleton;

//饿汉式
public class SingleB {
    private static final SingleB INSTANCE = new SingleB();
    private SingleB() {}
    public static SingleB getInstance() {
        return INSTANCE;
    }

}
