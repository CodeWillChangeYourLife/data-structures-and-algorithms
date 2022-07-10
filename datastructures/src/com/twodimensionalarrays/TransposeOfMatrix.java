package com.twodimensionalarrays;

public class TransposeOfMatrix {

    public static void main(String[] args) {

        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("After Transpose Of Matrix");
        int[][] tpm = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                tpm[i][j] = arr[j][i];
            }

        }

        for (int row = 0; row < tpm.length; row++) {
            for (int column = 0; column < tpm[row].length; column++) {
                System.out.print(tpm[row][column] + " ");
            }
            System.out.println();
        }
    }
}
