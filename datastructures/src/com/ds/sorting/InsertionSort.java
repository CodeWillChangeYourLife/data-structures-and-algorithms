package com.ds.sorting;

public class InsertionSort {
    public static void main(String[] args) {

        int[] arr = {2, 1, 3, -1, 33, 9};

        for (int i = 1; i < arr.length; i++) {
            int markedElement = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= markedElement) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = markedElement;
        }

        for (int x = 0; x < arr.length; x++) {
            System.out.print(arr[x] + " ");
        }
    }
}
