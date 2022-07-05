package com.algorithms;

public class QuickSortAlgorithm {

    public static void main(String[] args) {
        int[] arr = {10, -2, 4, 1, 6, 3};
        quickSort(arr, 0, arr.length - 1);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {

        if (startIndex < endIndex) {

            int partitionIndex = partitionBasedOnPivotIndex(arr, startIndex, endIndex);
            quickSort(arr, startIndex, partitionIndex-1);
            quickSort(arr,partitionIndex+1, endIndex);
        }
    }

    private static int partitionBasedOnPivotIndex(int[] arr, int startIndex, int endIndex) {

        int pivotIndex = endIndex;
        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; j++) {
            if (arr[j] <= arr[pivotIndex]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[pivotIndex];
        arr[pivotIndex] = temp;
        return i + 1;

    }
}
