package com.algorithms;

public class MergeSortAlgorithm {

    public static void main(String[] args) {

        int[] arr = {10, -1, 4, 2};

        mergeArray(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void mergeArray(int[] arr) {

        int arrLength = arr.length;

        if (arrLength < 2) {
            return;
        }

        int middleIndex = arrLength / 2;

        int[] leftSide = new int[middleIndex];
        int[] rightSide = new int[arrLength - middleIndex];

        for (int i = 0; i < leftSide.length; i++) {
            leftSide[i] = arr[i];
        }

        for (int j = middleIndex; j < arr.length; j++) {
            rightSide[j - middleIndex] = arr[j];
        }

        mergeArray(leftSide);
        mergeArray(rightSide);
        merging(arr, leftSide, rightSide);
    }

    private static void merging(int[] arr, int[] leftSide, int[] rightSide) {
        int i = 0;
        int j = 0;
        int k = 0;

        int leftSideSize = leftSide.length;
        int rightSideSize = rightSide.length;

        while (i < leftSideSize && j < rightSideSize) {

            if (leftSide[i] <= rightSide[j]) {

                arr[k] = leftSide[i];
                k++;
                i++;
            } else {
                arr[k] = rightSide[j];
                k++;
                j++;
            }
        }

        while (i < leftSideSize) {
            arr[k] = leftSide[i];
            k++;
            i++;
        }

        while (j < rightSideSize) {
            arr[k] = rightSide[j];
            k++;
            j++;
        }
    }
}
