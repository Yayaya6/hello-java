package com.dimon.tryjava.basicKnow.clone;

public class SimpleObject implements Cloneable
{
    private String str;

    public SimpleObject()
    {
        System.out.println("Enter SimpleObject.constructor()");
    }

    public String getStr()
    {
        return str;
    }

    public void setStr(String str)
    {
        this.str = str;
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }



}

