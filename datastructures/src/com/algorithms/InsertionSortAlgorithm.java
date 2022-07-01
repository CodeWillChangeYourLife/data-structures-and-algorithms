package com.algorithms;

public class InsertionSortAlgorithm {

    public static void main(String[] args) {
        int[] arr = {10, -1, 2, 4};

        for (int i = 1; i < arr.length; i++) {
            int firstUnsortedValue = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] > firstUnsortedValue) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = firstUnsortedValue;
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
