package com.twodimensionalarrays;

public class SumOfUppterTriangleDiagnol {

    public static void main(String[] args) {
        int [][] arr = {{1,2,3,4},
                        {5,6,7,8},
                        {8,7,6,5},
                        {4,3,2,1}};

        int  sum = 0;

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                sum = sum+arr[i][j];
            }
        }

        System.out.println("Total Sum :"+sum);
    }
}
