package com.twodimensionalarrays;

public class SumOfUpperTriangleInMatrix {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {8, 7, 6, 5},
                {4, 3, 2, 1}};
        int upperTriangleSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                upperTriangleSum = upperTriangleSum + arr[i][j];
            }
        }

        System.out.println("Upper Triangle Sum : " + upperTriangleSum);
    }


}
