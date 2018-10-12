package com.dimon.tryjava.basicKnow.hashcode;

public class HashCodeClass
{
    private String str0;
    private double dou0;
    private int       int0;

    public boolean equals(Object obj)
    {
        if (obj instanceof HashCodeClass)
        {
            HashCodeClass hcc = (HashCodeClass)obj;
            if (hcc.str0.equals(this.str0) &&
                    hcc.dou0 == this.dou0 &&
                    hcc.int0 == this.int0)
            {
                return true;
            }
            return false;
        }
        return false;
    }
}