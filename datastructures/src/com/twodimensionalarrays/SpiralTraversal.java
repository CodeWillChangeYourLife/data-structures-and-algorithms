package com.twodimensionalarrays;

public class SpiralTraversal {

    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int minRow = 0;
        int maxRow = arr.length - 1;
        int minCol = 0;
        int maxCol = arr[0].length - 1;
        int count = 0;
        int maxElements = arr.length * 4;

        while (count < maxElements) {

            //leftWall
            for (int i = minRow, j = minCol; i <= maxRow; i++) {
                System.out.print(arr[i][j] + " ");
                count++;
            }
            minCol++;

            //bottomWall

            for (int i = minCol, j = maxRow; i <= maxCol; i++) {
                System.out.print(arr[j][i] + " ");
                count++;
            }
            maxRow--;

            //rightWall
            for (int i = maxRow, j = maxCol; i >= minRow; i--) {
                System.out.print(arr[i][j] + " ");
                count++;
            }
            maxCol--;

            //top wall

            for (int i = maxCol, j = minRow; i >= minCol; i--) {
                System.out.print(arr[j][i] + " ");
                count++;
            }
            minRow++;
        }
    }
}
