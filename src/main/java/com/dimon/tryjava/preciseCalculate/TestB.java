package com.dimon.tryjava.preciseCalculate;

import java.math.BigDecimal;

/**
 * Created by limeng on 2018/10/1.
 */
public class TestB {
    public static void main(String[] args)
    {
        //使用double来构造BigDecimal，问题依旧
        BigDecimal a = new BigDecimal(2.0);
        BigDecimal b = new BigDecimal(1.1);
        System.out.println(a.subtract(b));
    }
}
