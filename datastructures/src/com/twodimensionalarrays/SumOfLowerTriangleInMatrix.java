package com.twodimensionalarrays;

public class SumOfLowerTriangleInMatrix {

    public static void main(String[] args) {
        int [][] arr = {{1,2,3,4},
                        {5,6,7,8},
                        {8,7,6,5},
                        {4,3,2,1}};

        int lowerTriangleSum=0;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=i;j++){
                lowerTriangleSum=lowerTriangleSum+arr[i][j];
            }
        }

        System.out.println(lowerTriangleSum);
    }
}
