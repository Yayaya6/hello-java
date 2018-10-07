package com.dimon.tryjava.programmingInterview.myDataStructure.array;

import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;

public class ReverseArray_0 {

//    8. 如何使用 Java 反转一个数组？

    public static void main(String args[]) {

        int[] iArray = new int[] {101,102,103,104,105};
        String[] sArray = new String[] {"one", "two", "three", "four", "five"};


        // reverse int array using Apache commons ArrayUtils.reverse() method
        System.out.println("Original int array : " + Arrays.toString(iArray));
        ArrayUtils.reverse(iArray);
        System.out.println("reversed int array : " + Arrays.toString(iArray));

        // reverse String array using ArrayUtis class
        System.out.println("Original String array : " + Arrays.toString(sArray));
        ArrayUtils.reverse(sArray);
        System.out.println("reversed String array in Java : " + Arrays.toString(sArray));
    }


}
