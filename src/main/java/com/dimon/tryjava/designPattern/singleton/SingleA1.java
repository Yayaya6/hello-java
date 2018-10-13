package com.dimon.tryjava.designPattern.singleton;


// 懒汉
/*public class SingleA1 {
    private static SingleA1 instance;
    public static SingleA1 getInstance() {
        if (instance == null) {
            instance = new SingleA1();
        }
        return instance;
    }

}*/



public class SingleA1 {
    private static SingleA1 instance;
    private SingleA1() {}

    public static SingleA1 getInstance() {
        if (instance == null) {
            instance = new SingleA1();
        }
        return instance;
    }

}