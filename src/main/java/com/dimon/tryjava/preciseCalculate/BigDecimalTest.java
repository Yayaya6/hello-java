package com.dimon.tryjava.preciseCalculate;

import java.math.BigDecimal;

/**
 * Created by limeng on 2018/10/1.
 */
public class BigDecimalTest {

    public static void main(String[] args)
    {
        //使用字符串构造BigDecimal对象
        BigDecimal a =new BigDecimal("2.0");
        BigDecimal b = new BigDecimal("1.1");
        System.out.println(a.subtract(b));
    }
}
