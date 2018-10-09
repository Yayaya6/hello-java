package com.dimon.tryjava.programmingInterview.myAlgorithm;

public class QuickSort {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 9, 5, 4, 8};
        System.out.println("unSort: " + pringArr(arr));
        quictSort(arr);
        System.out.println("sort: " + pringArr(arr));
    }

    private static void quictSort(int[] arr) {
        internalQuickSort(arr, 0, arr.length - 1);
    }

    private static void internalQuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            internalQuickSort(arr, left, pivot - 1);
            internalQuickSort(arr, pivot + 1, right);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int value = arr[low];

        while (low < high) {
            while (low < high && value <= arr[high])
                high--;
            arr[low] = arr[high];
            while (low < high && value >= arr[low])
                low++;
            arr[high] = arr[low];
        }

        arr[low] = value;
        return low;
    }

    public static String pringArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int anArr : arr) {
            sb.append(anArr);
            sb.append(",");
        }
        return sb.toString();
    }
}
