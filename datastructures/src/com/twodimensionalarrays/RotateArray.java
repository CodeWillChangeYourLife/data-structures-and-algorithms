package com.twodimensionalarrays;

public class RotateArray {

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d", "e", "f"};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int r = 2;
        reverse(arr, 0, arr.length - 1 - r);
        reverse(arr, arr.length - r, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void reverse(String[] arr, int startIndex, int endIndex) {

        while (startIndex < endIndex) {
            String temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
