package com.twodimensionalarrays;

public class TwoDimensionalArray {

    public static void main(String[] args) {

        int[][] arr = new int[3][4];

        int no = 10;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = no;
                no = no + 10;
            }
        }

        // display twod array data

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }

            System.out.println();
        }
    }
}
