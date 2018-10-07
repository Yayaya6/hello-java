package com.dimon.tryjava.programmingInterview.myDataStructure.array;

public class MissingNumberInArray_1 {


    public static void main(String[] args) {

        int[] a = {1, 3, 4, 5};
        System.out.println("The Value is :" + findMissingNumberInSequentialArray(a));
    }

    public static int findMissingNumberInSequentialArray(int[] a) {
        int xorCalulated = 1;
        for (int i = 2; i <= a.length; i++) // this loop runs (n) times
        {
            xorCalulated ^= i;
        }

        int xorActual = a[0];
        for (int i = 1; i < (a.length - 1);
                i++) // this loop runs (n-1) times. Since there is one element "missing"
        {
            xorActual ^= a[i];
        }

        return xorActual ^ xorCalulated;

    }


}
