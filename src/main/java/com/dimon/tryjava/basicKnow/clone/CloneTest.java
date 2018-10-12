package com.dimon.tryjava.basicKnow.clone;

public class CloneTest {
    public static void main(String[] args) throws Exception
    {
        SimpleObject so0 = new SimpleObject();
        so0.setStr("111");
        SimpleObject so1 = (SimpleObject)so0.clone();

        System.out.println("so0 == so1?" + (so0 == so1));
        System.out.println("so0.getClass() == so1.getClass()?" + (so0.getClass() == so1.getClass()));
        System.out.println("so0.equals(so1)?" + (so0.equals(so1)));

        // shadow clone & deep clone
        System.out.println("so0.getStr()：" + so0.getStr());
        System.out.println("so1.getStr()：" + so1.getStr());

        so1.setStr("222");
        System.out.println("so0.getStr()：" + so0.getStr());
        System.out.println("so1.getStr()：" + so1.getStr());



    }
}
