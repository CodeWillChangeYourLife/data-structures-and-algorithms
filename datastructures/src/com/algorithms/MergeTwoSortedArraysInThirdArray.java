package com.algorithms;

public class MergeTwoSortedArraysInThirdArray {

    public static void main(String[] args) {

        int[] arr1 = {2, 5, 7, 10};
        int[] arr2 = {8, 9, 11};

        int[] arr3 = new int[arr1.length + arr2.length];

        int arr1Pointer = 0;
        int arr2Pointer = 0;
        int arr3Pointer = 0;

        int arr1Size = arr1.length;
        int arr2Size = arr2.length;

        while (arr1Pointer < arr1Size && arr2Pointer < arr2Size) {

            if (arr1[arr1Pointer] < arr2[arr2Pointer]) {
                arr3[arr3Pointer] = arr1[arr1Pointer];
                arr3Pointer++;
                arr1Pointer++;
            } else {
                arr3[arr3Pointer] = arr2[arr2Pointer];
                arr3Pointer++;
                arr2Pointer++;
            }
        }

        while (arr1Pointer < arr1Size) {
            arr3[arr3Pointer] = arr1[arr1Pointer];
            arr3Pointer++;
            arr1Pointer++;
        }

        while (arr2Pointer < arr2Size) {
            arr3[arr3Pointer] = arr2[arr2Pointer];
            arr3Pointer++;
            arr2Pointer++;
        }


        for (int x = 0; x < arr3.length; x++) {
            System.out.print(arr3[x] + " ");
        }

    }
}
