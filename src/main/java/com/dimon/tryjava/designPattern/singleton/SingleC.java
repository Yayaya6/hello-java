package com.dimon.tryjava.designPattern.singleton;

// 静态内部类
public class SingleC {
    private static class SingletonHolder {
        private static final SingleC INSTANCE = new SingleC();
    }

    private SingleC() {}

    public static final SingleC getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
