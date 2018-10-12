package com.dimon.tryjava.designPattern.singleton;


// 懒汉
/*public class Single1 {
    private static Single1 instance;
    public static Single1 getInstance() {
        if (instance == null) {
            instance = new Single1();
        }
        return instance;
    }

}*/



public class Single1 {
    private static Single1 instance;
    private Single1() {}

    public static Single1 getInstance() {
        if (instance == null) {
            instance = new Single1();
        }
        return instance;
    }

}