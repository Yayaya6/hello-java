package com.dimon.tryjava.programmingInterview.myDataStructure.array;

import java.util.Arrays;

public class RemovingDuplicatesInArray_1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
// TODO Auto-generated method stub

        int[] a = {3, 1, 1, 4, 1, 4, 5};

        Arrays.sort(a);
        int count = 0;

        long start = System.currentTimeMillis();

        for (int i = 0; i < a.length; i++) {
            if (i + 1 < a.length && a[i] == a[i + 1]) {
                count++;
            }

        }

        int[] b = new int[a.length - count];
        int c = 0;
        for (int j = 0; j < a.length; j++) {
            if (j + 1 < a.length && a[j] == a[j + 1]) {

            } else {
                b[c] = a[j];
                c++;
            }
        }

        a = b;
        System.out.println(Arrays.toString(a) + "took"
                + (System.currentTimeMillis() - start));

    }

}
