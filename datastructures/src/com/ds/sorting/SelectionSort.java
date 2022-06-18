package com.ds.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, -1, 33, 9};

        for (int a = 0; a < arr.length; a++) {
            System.out.print(arr[a]+" ");
        }

        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println();
        for (int x = 0; x < arr.length; x++) {
            System.out.print(arr[x] + " ");
        }
    }
}
