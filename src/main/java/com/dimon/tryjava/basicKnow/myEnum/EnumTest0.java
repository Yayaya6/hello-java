package com.dimon.tryjava.basicKnow.myEnum;

public class EnumTest0 {

    public static void main(String[] args) throws Exception
    {
        EnumDay0[] eds = EnumDay0.values(); // 将EnumDay中的枚举值转换为EnumDay数组
        int i = 0;
        for (EnumDay0 ed : eds)
        {
            System.out.println("EnumDay0[" + i + "]：" + ed.toString()); // 返回枚举常量的名称
            i++;
        }
        System.out.println();

        System.out.println("Enum<EnumDay0>.compareTo()：" + eds[0].compareTo(eds[1])); // 比较此枚举与指定枚举的顺序，被比较对象小于、等于、大于比较对象时，分别返回负整数、0、正整数，只能和相同枚举类型相比较
        System.out.println("Enum<EnumDay0>.equals()：" + eds[0].equals(eds[1])); // 比较指定两个枚举类型是否相同
        System.out.println("Enum<EnumDay0>.getDeclaringClass()：" + eds[0].getDeclaringClass()); // 获取指定枚举值的枚举类型对应的Class对象
        System.out.println("Enum<EnumDay0>.hashCode()：" + eds[0].hashCode()); // 获取指定枚举值对应的hashCode
        System.out.println("Enum<EnumDay0>.name()：" + eds[0].name()); // 获取指定枚举值的名称
        System.out.println("Enum<EnumDay0>.ordinal()：" + eds[0].ordinal()); // 获取指定枚举值对应的序数
    }

}
